#include <Arduino.h>

// data types

// filtered ultrasonic readings in cm, 999 = no echo / no wall
struct USData {
  float front;
  float fr;  // front-right
  float br;  // back-right
};

// wall estimate from the two side sensors
struct WallData {
  float d;      // distance to wall, cm
  float theta;  // heading to wall, rad (+ = nose pointing away)
  bool valid;
};

// one ultrasonic sensor: pins, filter history, echo timing
struct Sonar {
  int trig;
  int echo;
  float hist[3];  // last 3 raw readings for the median
  int histIdx;
  float filtered;
  unsigned long trigUs;
  unsigned long riseUs;
};


// pins

// motor driver
const int A_1B = 5;   // right reverse
const int A_1A = 6;   // right forward
const int B_1B = 9;   // left forward
const int B_1A = 10;  // left reverse

// ultrasonic sensors
const int frontTrig = 3;
const int frontEcho = 4;
const int frTrig = 7;
const int frEcho = 8;
const int brTrig = 11;
const int brEcho = 12;


// constants

// motors
const int FULL_SPEED = 200;     // turning speed
const int WALL_SPEED = 150;     // following speed, leaves room to steer
const int RIGHT_FWD_TRIM = 12;  // right motor is faster going forward
const int LEFT_BACK_TRIM = 14;  // left motor trim when reversing

// ultrasonic
const float NO_ECHO = 999;
const unsigned long SLOT_MS = 20;                  // one sensor per slot, each sensor updates every 60 ms
const unsigned long ECHO_START_TIMEOUT_US = 7000;  // echo should rise right after trigger
const unsigned long ECHO_MAX_US = 6000;            // ~100 cm, longer = no echo
const float EMA_ALPHA = 0.5;                       // weight of newest median

const int lineTrack = 2;  // 0 = white, 1 = black

// wall following
const float TARGET_CM = 15.0;
const float SENSOR_SPACING_CM = 10.6;  // L between side sensors
const unsigned long CONTROL_MS = 30;

// controller
const float KP_D = 5.0;       // pwm per cm of distance error
const float KP_TH = 100.0;    // pwm per rad of heading error (damping)
const float KI_D = 1.0;       // pwm per cm*s
const float I_MAX = 20.0;     // integral clamp
const float MAX_STEER = 45;
const float ED_MAX = 8.0;     // distance error clamp, cm
const float RECOVER_STEER = 10;       // steer when the wall is lost

// fsm thresholds
const float FRONT_STOP_CM = 20;  // front wall closer = left turn
const float LOST_WALL_CM = 40;   // side sensor farther = wall lost
const float FOUND_WALL_CM = 35;  // both side sensors closer = wall found
const int CONFIRM = 3;           // readings in a row to trust an event

// turns and corners
const unsigned long TURN_PAUSE_MS = 100;   // stand still before turning
const unsigned long LEFT_TURN_MS = 330;    // 90 degrees
const unsigned long RIGHT_TURN_MS = 350;   // 90 degrees
const unsigned long CLEAR_MS = 250;        // drive on after back sensor loses wall to clear corner
const unsigned long FIND_SETTLE_MS = 3000;  // drive straight while filters refill
const int REACQUIRE_ARC = 10;              // bend right while searching

// debug
const bool DEBUG = true;
const unsigned long DEBUG_MS = 200;

const unsigned long START_DELAY_MS = 5000;

// sensor indexes
const int S_FR = 0;
const int S_BR = 1;
const int S_FRONT = 2;


// globals

Sonar sonars[3] = {
  {frTrig, frEcho, {999, 999, 999}, 0, 999, 0, 0},
  {brTrig, brEcho, {999, 999, 999}, 0, 999, 0, 0},
  {frontTrig, frontEcho, {999, 999, 999}, 0, 999, 0, 0}
};

// sensor read phase: i = idle, r = waiting for echo rise, f = waiting for echo fall
char usPhase = 'i';
int activeSensor = S_FR;
unsigned long slotStartMs = 0;

// consecutive readings, updated when a sensor finishes
int frontClose = 0;  // front closer than FRONT_STOP_CM
int frLost = 0;      // front-right lost the wall
int brLost = 0;      // back-right lost the wall

// w = wall follow, l = left turn, a = right approach, r = right turn, f = find wall
char state = 'f';
unsigned long stateStart = 0;
unsigned long clearStart = 0;  // when back sensor lost wall in approach, 0 = not yet

USData us;

// controller
float integral = 0;
float lastTheta = 0;  // last valid heading
unsigned long lastControlMs = 0;
unsigned long lastDebugMs = 0;


void setup() {
  Serial.begin(9600);

  pinMode(A_1B, OUTPUT);
  pinMode(A_1A, OUTPUT);
  pinMode(B_1B, OUTPUT);
  pinMode(B_1A, OUTPUT);

  for (int i = 0; i < 3; i++) {
    pinMode(sonars[i].trig, OUTPUT);
    pinMode(sonars[i].echo, INPUT);
  }

  delay(START_DELAY_MS);

  // fill the filters before moving
  slotStartMs = millis();
  unsigned long t0 = millis();
  while (millis() - t0 < 400) us = readUSData();

  if (us.fr < FOUND_WALL_CM && us.br < FOUND_WALL_CM) setState('w');
  else setState('f');
}

void loop() {
  us = readUSData();

  if (state == 'w') {
    WALL_FOLLOW();
  } else if (state == 'l') {
    LEFT_TURN();
  } else if (state == 'a') {
    RIGHT_APPROACH();
  } else if (state == 'r') {
    RIGHT_TURN();
  } else {
    FIND_WALL();
  }
}


// sensors

float median3(float a, float b, float c) {
  return max(min(a, b), min(max(a, b), c));
}

// median of last 3 removes spikes, 999 passes straight through
void finishReading(float raw) {
  Sonar &s = sonars[activeSensor];

  s.hist[s.histIdx] = raw;
  s.histIdx = (s.histIdx + 1) % 3;

  float m = median3(s.hist[0], s.hist[1], s.hist[2]);
  if (m >= NO_ECHO) s.filtered = NO_ECHO;
  else if (s.filtered >= NO_ECHO) s.filtered = m;
  else s.filtered = EMA_ALPHA * m + (1.0 - EMA_ALPHA) * s.filtered;

  // counters for the fsm
  if (activeSensor == S_FR) frLost = (s.filtered >= LOST_WALL_CM) ? frLost + 1 : 0;
  else if (activeSensor == S_BR) brLost = (s.filtered >= LOST_WALL_CM) ? brLost + 1 : 0;
  else frontClose = (s.filtered < FRONT_STOP_CM) ? frontClose + 1 : 0;

  // next sensor, only one pings at a time
  activeSensor = (activeSensor + 1) % 3;
  usPhase = 'i';
  slotStartMs = millis();
}

// non-blocking, call every loop, returns latest filtered distances
USData readUSData() {
  Sonar &s = sonars[activeSensor];

  if (usPhase == 'i') {
    if (millis() - slotStartMs >= SLOT_MS) {
      digitalWrite(s.trig, LOW);
      delayMicroseconds(2);
      digitalWrite(s.trig, HIGH);
      delayMicroseconds(10);
      digitalWrite(s.trig, LOW);
      s.trigUs = micros();
      usPhase = 'r';
    }
  } else if (usPhase == 'r') {
    if (digitalRead(s.echo) == HIGH) {
      s.riseUs = micros();
      usPhase = 'f';
    } else if (micros() - s.trigUs > ECHO_START_TIMEOUT_US) {
      finishReading(NO_ECHO);
    }
  } else {
    if (digitalRead(s.echo) == LOW) {
      finishReading((micros() - s.riseUs) / 58.0);
    } else if (micros() - s.riseUs > ECHO_MAX_US) {
      finishReading(NO_ECHO);
    }
  }

  USData data;
  data.front = sonars[S_FRONT].filtered;
  data.fr = sonars[S_FR].filtered;
  data.br = sonars[S_BR].filtered;
  return data;
}

// clear old readings, used after a turn
void flushSensors() {
  for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 3; j++) sonars[i].hist[j] = NO_ECHO;
    sonars[i].filtered = NO_ECHO;
  }
  frontClose = 0;
  frLost = 0;
  brLost = 0;
}

// distance and heading from the two side sensors
WallData estimateWall(USData data) {
  WallData w;
  w.valid = (data.fr < LOST_WALL_CM && data.br < LOST_WALL_CM);
  w.d = 0;
  w.theta = 0;
  if (w.valid) {
    w.theta = atan2(data.fr - data.br, SENSOR_SPACING_CM);
    w.d = (data.fr + data.br) / 2.0 * cos(w.theta);
  }
  return w;
}


// controller

// PI on distance, P on heading, returns omega (+ = turn left)
float steerPI(WallData w, float dt) {
  float eD = constrain(w.d - TARGET_CM, -ED_MAX, ED_MAX);  // + = too far from wall
  float eTh = w.theta;                                      // + = nose pointing away

  integral += eD * dt;
  integral = constrain(integral, -I_MAX, I_MAX);

  // + = steer right, toward wall
  float u = KP_D * eD + KP_TH * eTh + KI_D * integral;
  u = constrain(u, -MAX_STEER, MAX_STEER);

  return -u;
}


// states

void setState(char s) {
  state = s;
  stateStart = millis();
  clearStart = 0;
  integral = 0;
  if (DEBUG) {
    Serial.print("STATE ");
    Serial.println(s);
  }
}

// follow wall with PI, leave on front wall or lost wall
void WALL_FOLLOW() {
  if (digitalRead(lineTrack) == 1) {
    stopMove();
    delay(10000);
  }

  if (frontClose >= CONFIRM) {
    setState('l');
    return;
  }

  // both side sensors lost the wall, not a corner
  if (frLost >= CONFIRM && brLost >= CONFIRM) {
    setState('f');
    return;
  }


  // front-right lost it, back-right still sees it = right corner
  if (frLost >= CONFIRM && us.br < LOST_WALL_CM) {
    setState('a');
    return;
  }

  unsigned long now = millis();
  if (now - lastControlMs < CONTROL_MS) return;
  float dt = (now - lastControlMs) / 1000.0;
  lastControlMs = now;
  if (dt > 0.2) dt = 0.2;  // cap dt after a state change

  WallData wall = estimateWall(us);
  float omega;
  if (wall.valid) {
    lastTheta = wall.theta;
    omega = steerPI(wall, dt);
  } else {
    // wall lost, only correct if last heading was clearly off
    if (lastTheta > 0.1) omega = -RECOVER_STEER;        // pointing away, turn right
    else if (lastTheta < -0.1) omega = RECOVER_STEER;   // pointing at wall, turn left
    else omega = 0;
  }

  setMotors(WALL_SPEED - (int)omega, WALL_SPEED + (int)omega);

  if (DEBUG && now - lastDebugMs >= DEBUG_MS) {
    lastDebugMs = now;
    Serial.print("d="); Serial.print(wall.d, 1);
    Serial.print(" th="); Serial.print(wall.theta * 57.3, 1);
    Serial.print(" w="); Serial.print(omega, 0);
    Serial.print(" f="); Serial.println(us.front, 0);
  }
}

// wall ahead: turn left 90, then find the new wall
void LEFT_TURN() {
  if (runTurn(false, LEFT_TURN_MS)) {
    flushSensors();
    setState('f');
  }
}

// front-right lost the wall: drive until back-right loses it too, then a bit more to clear the corner
void RIGHT_APPROACH() {
  // wall came back, was just a dropout or slope
  if (frLost == 0) {
    setState('w');
    return;
  }

  moveForward(WALL_SPEED);

  if (clearStart == 0 && brLost >= CONFIRM) clearStart = millis();
  if (clearStart != 0 && millis() - clearStart >= CLEAR_MS) setState('r');
}

// turn right 90, then find the new wall
void RIGHT_TURN() {
  if (runTurn(true, RIGHT_TURN_MS)) {
    moveForward(2000);
    flushSensors();
    setState('f');
  }
}

// drive forward bending right until both side sensors see a wall
void FIND_WALL() {
  if (frontClose >= CONFIRM) {
    setState('l');
    return;
  }

  if (us.fr < FOUND_WALL_CM && us.br < FOUND_WALL_CM) {
    setState('w');
    return;
  }

  // filters still refilling, go straight
  if (millis() - stateStart < FIND_SETTLE_MS) {
    moveForward(WALL_SPEED);
    return;
  }

  setMotors(WALL_SPEED + REACQUIRE_ARC, WALL_SPEED - REACQUIRE_ARC);
}

// pause, turn, stop. returns true when done, never blocks
bool runTurn(bool right, unsigned long ms) {
  unsigned long t = millis() - stateStart;
  if (t < TURN_PAUSE_MS) {
    stopMove();
  } else if (t < TURN_PAUSE_MS + ms) {
    if (right) turnRight(); else turnLeft();
  } else {
    stopMove();
    return true;
  }
  return false;
}


// motor control

// speeds -255..255, positive = forward
void setMotors(int left, int right) {
  left = constrain(left, -255, 255);
  right = constrain(right, -255, 255);

  if (right > 0) right = max(0, right - RIGHT_FWD_TRIM);
  if (left < 0) left = min(0, left + LEFT_BACK_TRIM);

  if (right >= 0) {
    analogWrite(A_1B, 0);
    analogWrite(A_1A, right);
  } else {
    analogWrite(A_1B, -right);
    analogWrite(A_1A, 0);
  }

  if (left >= 0) {
    analogWrite(B_1B, left);
    analogWrite(B_1A, 0);
  } else {
    analogWrite(B_1B, 0);
    analogWrite(B_1A, -left);
  }
}

void moveForward(int speed) {
  setMotors(speed, speed);
}

// turns only set the motors, caller decides when to stop
void turnRight() {
  analogWrite(A_1B, FULL_SPEED);
  analogWrite(A_1A, 0);
  analogWrite(B_1B, FULL_SPEED);
  analogWrite(B_1A, 0);
}

void turnLeft() {
  analogWrite(A_1B, 0);
  analogWrite(A_1A, FULL_SPEED);
  analogWrite(B_1B, 0);
  analogWrite(B_1A, FULL_SPEED);
}

void stopMove() {
  analogWrite(A_1B, 0);
  analogWrite(A_1A, 0);
  analogWrite(B_1B, 0);
  analogWrite(B_1A, 0);
}