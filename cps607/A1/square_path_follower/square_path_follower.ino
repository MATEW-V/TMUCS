#include <Arduino.h>

// Motor driver pins
const int A_1B = 5;   // Motor A (right) - reverse
const int A_1A = 6;   // Motor A (right) - forward
const int B_1B = 9;   // Motor B (left)  - forward
const int B_1A = 10;  // Motor B (left)  - reverse

// Calibration: per-motor PWM offset to compensate for motor mismatch
const int RIGHT_FWD_TRIM  = 12;  // right motor runs faster than left going forward
const int RIGHT_BACK_TRIM = 5;   // right motor trim when reversing

// Full speed PWM
const int FULL_SPEED = 255;

// Timings (ms)
const unsigned long START_DELAY_MS = 5000;  // time to place robot before first lap
const unsigned long FORWARD_MS     = 5338;  // one side of the square
const unsigned long TURN_MS        = 550;   // 90 degree in-place turn
const unsigned long PAUSE_MS       = 1000;  // settle time between motions

const int SIDES_PER_LAP = 4;

// Function prototypes
void moveForward(int speed);
void moveBackward(int speed);
void turnRight();
void turnLeft();
void stopMove();
void driveSide();
void turnRightAndSettle();

void setup() {
  pinMode(A_1B, OUTPUT);
  pinMode(A_1A, OUTPUT);
  pinMode(B_1B, OUTPUT);
  pinMode(B_1A, OUTPUT);

  delay(START_DELAY_MS);
}

void loop() {
  // One lap = 4 sides, each followed by a 90 degree right turn.
  // The final turn returns the robot to its starting heading so the
  // next lap begins correctly.
  for (int side = 0; side < SIDES_PER_LAP; side++) {
    driveSide();
    turnRightAndSettle();
  }
}

// Path segments
void driveSide() {
  moveForward(FULL_SPEED);
  delay(FORWARD_MS);
  stopMove();
  delay(PAUSE_MS);
}

void turnRightAndSettle() {
  turnRight();
  delay(TURN_MS);
  stopMove();
  delay(PAUSE_MS);
}

// Motor control
void moveForward(int speed) {
  analogWrite(A_1B, 0);
  analogWrite(A_1A, speed - RIGHT_FWD_TRIM);  // right motor offset
  analogWrite(B_1B, speed);
  analogWrite(B_1A, 0);
}

void moveBackward(int speed) {
  analogWrite(A_1B, speed - RIGHT_BACK_TRIM); // right motor offset
  analogWrite(A_1A, 0);
  analogWrite(B_1B, 0);
  analogWrite(B_1A, speed);
}

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
  analogWrite(A_1B, 1);
  analogWrite(A_1A, 1);
  analogWrite(B_1B, 1);
  analogWrite(B_1A, 1);
}