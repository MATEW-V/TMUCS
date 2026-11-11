# CPS607 - Autonomous Mobile Robotics - Assignment 1

## File Overview

- `robot_controller.ino`: Main entry point. `setup()` initializes the hardware; `loop()` runs the task continuously.
- `config.h`: Robot constants: wheel radius, wheelbase, pin numbers, and PWM calibration values. The only file to edit after recalibrating.
- `motors.ino`: Low-level motor control: `setMotors(leftPwm, rightPwm)` and `stopMotors()`. The only file that touches the motor driver pins.
- `kinematics.ino`: Forward and inverse differential-drive kinematics, plus the PWM-to-wheel-velocity mapping.
- `motion.ino`: Motion primitives built on the kinematic model: `driveStraight(distance)` and `turn(angle)`.
- `README.md`: This file.
