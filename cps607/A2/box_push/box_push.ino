#include <Arduino.h>

// both ir readings: 0 = reflects (white), 1 = empty
struct IRData {
  int left;
  int right;
};

// pins
// motor driver
const int A_1B = 5;   // right reverse
const int A_1A = 6;   // right forward
const int B_1B = 9;   // left forward
const int B_1A = 10;  // left reverse

const int rightIR = 7;
const int leftIR = 8;
const int trigPin = 3;
const int echoPin = 4;
const int lineTrack = 2;  // 0 = white, 1 = black

// motor settings
const int FULL_SPEED = 200;   // turning speed
const int CRUISE_SPEED = 255;
const int RIGHT_FWD_TRIM = 12;  // right motor runs faster going forward
const int LEFT_BACK_TRIM = 14;  // left motor trim when reversing

// search
const int MAX_US_DISTANCE = 40;
const unsigned long STEP_MS = 30;
const unsigned long SETTLE_MS = 15;
const float DIST_JUMP = 5.0;   // cm jump that means a different object
const int MAX_OBJ_STEPS = 15;  // widest one object can look, in steps
const int CONFIRM = 2;

// approach
const float STOP_DISTANCE = 3;  // cm
const unsigned long LOST_TIMEOUT_MS = 400;

// identify
const unsigned long IR_NUDGE_MS = 40;

// recover
const unsigned long RECOVER_BACK_MS = 1600;
const unsigned long RECOVER_TURN_MS = 300;

// general
const unsigned long START_DELAY_MS = 5000;

// state
// s = search, a = approach, i = identify, p = push, r = recover, anything else = done
char state = 's';
bool turnDirection = true;  // true = right, false = left


void setup() {
  Serial.begin(9600);

  pinMode(A_1B, OUTPUT);
  pinMode(A_1A, OUTPUT);
  pinMode(B_1B, OUTPUT);
  pinMode(B_1A, OUTPUT);

  pinMode(leftIR, INPUT);
  pinMode(rightIR, INPUT);
  Serial.println("--- IR Color Detector Initialized ---");
  Serial.println("Place box 2-5 cm away from the sensor.");

  pinMode(echoPin, INPUT);
  pinMode(trigPin, OUTPUT);

  pinMode(lineTrack, INPUT);

  delay(START_DELAY_MS);
}

void loop() {
  if (state == 's') {
    SEARCH();
  } else if (state == 'a') {
    APPROACH();
  } else if (state == 'r') {
    RECOVER();
  } else if (state == 'i') {
    IDENTIFY();
  } else if (state == 'p') {
    PUSH();
  } else {
    DONE();
  }
}


// sensors

// distance in cm, 999 if no echo
float readUSData() {
  digitalWrite(trigPin, LOW);
  delayMicroseconds(2);
  digitalWrite(trigPin, HIGH);
  delayMicroseconds(10);
  digitalWrite(trigPin, LOW);
  unsigned long d = pulseIn(echoPin, HIGH, 4000);
  if (d == 0) return 999;
  return d / 58.0;
}

IRData readIRSense() {
  IRData data;
  data.left  = digitalRead(leftIR);
  data.right = digitalRead(rightIR);
  return data;
}

int readlinecheck() {
  return digitalRead(lineTrack);
}


// states

// spin until the first object, then turn back to its center
void SEARCH() {
  unsigned long turned = 0, firstHit = 0, lastHit = 0;
  int hits = 0, misses = 0;
  bool inObject = false;
  float refDist = 0;

  while (true) {
    stepTurn(turnDirection, STEP_MS);
    turned += STEP_MS;

    float d = readUSData();
    bool seen = (d >= 4 && d <= MAX_US_DISTANCE);
    bool sameObject = seen && (!inObject || abs(d - refDist) <= DIST_JUMP);

    if (sameObject) {
      hits++; misses = 0;
      if (!inObject && hits >= CONFIRM) {
        inObject = true;
        firstHit = turned - (CONFIRM - 1) * STEP_MS;
      }
      if (inObject) {
        lastHit = turned;
        refDist = d;
      }
    } else {
      misses++; hits = 0;
    }

    // object ends on misses, or when it looks too wide to be one object
    bool tooWide = inObject && ((lastHit - firstHit) / STEP_MS >= MAX_OBJ_STEPS);
    if (inObject && (misses >= CONFIRM || tooWide)) {
      unsigned long center = (firstHit + lastHit) / 2;
      unsigned long backMs = turned - center;
      for (unsigned long t = 0; t < backMs; t += STEP_MS) {
        stepTurn(!turnDirection, STEP_MS);
      }
      state = 'a';
      return;
    }
  }
}

// drive at the object until close, line sensor checked every loop
void APPROACH() {
  Serial.println("APPROACH started");
  float lastDist = 999;
  unsigned long lostSince = 0;
  int closeCount = 0;

  while (true) {
    if (readlinecheck() == 1) {
      Serial.println("EXIT: line sensor read 1");
      state = 'r';
      return;
    }

    float d = readUSData();
    bool valid = (d > 0 && d < 999);

    IRData ir = readIRSense();

    // ignore impossible drops (false echo)
    if (valid && lastDist < 999 && (lastDist - d) > 15) valid = false;

    Serial.print("d="); Serial.println(d);

    if (valid) {
      lastDist = d;
      lostSince = 0;

      // need 3 close readings in a row
      if (d <= STOP_DISTANCE) {
        closeCount++;
        if (closeCount >= 3) {
          Serial.println("EXIT: reached STOP_DISTANCE");
          stopMove();
          state = 'i';
          return;
        }
      } else {
        closeCount = 0;
      }
    } else {
      // keep driving through brief bad readings
      if (lostSince == 0) lostSince = millis();
      if (millis() - lostSince > LOST_TIMEOUT_MS) {
        Serial.println("EXIT: lost target");
        state = 'r';
        return;
      }
      if (ir.left == 0 && ir.right == 1) {
        turnLeft(IR_NUDGE_MS);
      } else if (ir.left == 1 && ir.right == 0) {
        turnRight(IR_NUDGE_MS);
      }
    }

    moveForward(CRUISE_SPEED);
    delay(30);  // let echoes die out before the next ping
  }
}

// white box: line up and push, black box: recover
void IDENTIFY() {
  stopMove();
  delay(SETTLE_MS);

  for (int attempt = 0; attempt < 5; attempt++) {
    IRData ir = readIRSense();

    if (ir.left == 0 && ir.right == 0) {
      state = 'p';
      return;
    } else if (ir.left == 0 && ir.right == 1) {
      turnLeft(IR_NUDGE_MS);
    } else if (ir.left == 1 && ir.right == 0) {
      turnRight(IR_NUDGE_MS);
    } else {
      // both empty: re-check a few times before calling it black
      bool allEmpty = true;
      for (int i = 0; i < 4; i++) {
        delay(10);
        IRData again = readIRSense();
        if (again.left == 0 || again.right == 0) { allEmpty = false; break; }
      }
      if (allEmpty) {
        Serial.println("BLACK -> RECOVER");
        state = 'r';
        return;
      }
    }

    stopMove();
    delay(SETTLE_MS);
  }

  // could not center, push if at least one sensor sees white
  IRData last = readIRSense();
  if (last.left == 0 || last.right == 0) PUSH();
  else state = 'r';
}

// push the box forward until the floor sensor hits the line
void PUSH() {
  Serial.println("PUSH");
  delay(300);

  while (true) {
    if (readlinecheck() == 1) {
      stopMove();
      Serial.println("PUSH: reached line");
      state = 'd';
      return;
    }
    moveForward(CRUISE_SPEED);
  }
}

// back up, turn away, flip sweep direction, search again
void RECOVER() {
  Serial.println("RECOVER");
  stopMove();
  delay(300);

  moveBackward(CRUISE_SPEED);
  delay(RECOVER_BACK_MS);
  stopMove();
  delay(200);

  if (turnDirection) {
    turnLeft(RECOVER_TURN_MS);
    stopMove();
    delay(200);
    turnDirection = false;
  } else {
    turnRight(RECOVER_TURN_MS);
    stopMove();
    delay(200);
    turnDirection = true;
  }

  state = 's';
}

void DONE() {
  stopMove();
  delay(100000);
}


// motor control

void moveForward(int speed) {
  analogWrite(A_1B, 0);
  analogWrite(A_1A, speed - RIGHT_FWD_TRIM);
  analogWrite(B_1B, speed);
  analogWrite(B_1A, 0);
}

void moveBackward(int speed) {
  analogWrite(A_1B, speed);
  analogWrite(A_1A, 0);
  analogWrite(B_1B, 0);
  analogWrite(B_1A, speed - LEFT_BACK_TRIM);
}

// turns leave the motors running after the delay
void turnRight(int time) {
  analogWrite(A_1B, FULL_SPEED);
  analogWrite(A_1A, 0);
  analogWrite(B_1B, FULL_SPEED);
  analogWrite(B_1A, 0);
  delay(time);
}

void turnLeft(int time) {
  analogWrite(A_1B, 0);
  analogWrite(A_1A, FULL_SPEED);
  analogWrite(B_1B, 0);
  analogWrite(B_1A, FULL_SPEED);
  delay(time);
}

// turn for ms, stop, then wait so the car is still before measuring
void stepTurn(bool right, unsigned long ms) {
  if (right) turnRight(ms); else turnLeft(ms);
  stopMove();
  delay(SETTLE_MS);
}

void stopMove() {
  analogWrite(A_1B, 0);
  analogWrite(A_1A, 0);
  analogWrite(B_1B, 0);
  analogWrite(B_1A, 0);
}
