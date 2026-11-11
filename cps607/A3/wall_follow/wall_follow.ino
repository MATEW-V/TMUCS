#include <Arduino.h>

// both ir readings: 0 = reflects (white), 1 = empty
struct IRData {
  int left;
  int right;
};

struct usData {
  float f1;
  float rf1;
  float rd2;
};

// pins
// motor driver
const int A_1B = 5;   // right reverse
const int A_1A = 6;   // right forward
const int B_1B = 9;   // left forward
const int B_1A = 10;  // left reverse

// motor settings
const int FULL_SPEED = 200;   // turning speed
const int CRUISE_SPEED = 255;
const int RIGHT_FWD_TRIM = 12;  // right motor runs faster going forward
const int LEFT_BACK_TRIM = 14;  // left motor trim when reversing

// general
const unsigned long START_DELAY_MS = 5000;


void setup() {
  Serial.begin(9600);

  pinMode(A_1B, OUTPUT);
  pinMode(A_1A, OUTPUT);
  pinMode(B_1B, OUTPUT);
  pinMode(B_1A, OUTPUT);

  delay(START_DELAY_MS);
}

void loop() {

}


// sensors

// distance in cm, 999 if no echo
float readUSData() {
  // digitalWrite(trigPin, LOW);
  // delayMicroseconds(2);
  // digitalWrite(trigPin, HIGH);
  // delayMicroseconds(10);
  // digitalWrite(trigPin, LOW);
  // unsigned long d = pulseIn(echoPin, HIGH, 4000);
  // if (d == 0) return 999;
  // return d / 58.0;
}

usData readUSsensors (){
  usData data;
  //raw data into 3 sensors dists
  return data;
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


void stopMove() {
  analogWrite(A_1B, 0);
  analogWrite(A_1A, 0);
  analogWrite(B_1B, 0);
  analogWrite(B_1A, 0);
}
