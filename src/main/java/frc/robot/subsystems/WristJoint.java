/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.OI;
import frc.robot.RobotMap;
import frc.robot.commands.ArmWithTrigger;
import frc.robot.commands.WristWithTrigger;

/**
 * Add your docs here.
 */
public class WristJoint extends PIDSubsystem {
  
  public boolean wristMovingWithTrigger = false;

  public WristJoint() {
    // Intert a subsystem name and PID values here
    super("WristJoint", 0.001, 0, 0);
    setPercentTolerance(20); //Error should be within 5 percent
    getPIDController().setContinuous(false); 
    setOutputRange(-0.3, 0.3); //test if this is necessary
    //RobotMap.wristJointMotorRight.follow(RobotMap.wristJointMotorLeft);
    RobotMap.wristJointMotorLeft.setSelectedSensorPosition(0, 0, 0);
    setSetpoint(RobotMap.wristJointMotorLeft.getSelectedSensorPosition());
    enable();

    // Use these to get going:
    // setSetpoint() - Sets where the PID controller should move the system
    // to
    // enable() - Enables the PID controller.
  }

  public void moveWristWithTrigger() {
    int target_value = RobotMap.wristJointMotorLeft.getSelectedSensorPosition();
    if (OI.gamepad.getPOV() == 90) { //If you press right on the d-pad, make the wrist move right
      //RobotMap.wristJointMotorLeft.set(0.1);
      wristMovingWithTrigger = true;
      setSetpoint(target_value - 100);

    }
    else if (OI.gamepad.getPOV() == 270) { //If you press left on the d-pad, make the wrist move left
      //RobotMap.wristJointMotorLeft.set(-0.1);
      wristMovingWithTrigger = true;
      setSetpoint(target_value + 100);

    }
    else if (OI.gamepad.getPOV() == -1) { //Stop the wrist when you release the d-pad
      //RobotMap.wristJointMotorLeft.set(0);
      wristMovingWithTrigger = false;
      
    }
    SmartDashboard.putNumber("wrist target value", target_value);
  }
/*
  public void moveWristUp()
  {
    RobotMap.wristJointMotorLeft.set(0.3);
    RobotMap.wristJointMotorRight.set(-0.3);
  }

  public void moveWristDown()
  {
    RobotMap.wristJointMotorLeft.set(-0.3);
    RobotMap.wristJointMotorRight.set(0.3);
  }

  public void stopWristMovement()
  {
    RobotMap.wristJointMotorLeft.set(0);
    RobotMap.wristJointMotorRight.set(0);
  }
*/
  public void setTargetPosition(double angle) { //rotate by a certain angle
    double arcLength = (angle / 360) * (16 * Math.PI);
    setSetpoint(arcLength); //setpoint is the arclength encoder moves
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    //setDefaultCommand(new WristWithTrigger());
  }

  

  @Override
  protected double returnPIDInput() {
    // Return your input value for the PID loop
    // e.g. a sensor, like a potentiometer:
    // yourPot.getAverageVoltage() / kYourMaxVoltage;
    SmartDashboard.putNumber("PID input(wrist encoder)", RobotMap.wristJointMotorLeft.getSelectedSensorPosition(0));
    return RobotMap.wristJointMotorLeft.getSelectedSensorPosition();
  }

  @Override
  protected void usePIDOutput(double output) {
    // Use output to drive your system, like a motor
    // e.g. yourMotor.set(output);
    RobotMap.wristJointMotorLeft.pidWrite(output);
    SmartDashboard.putNumber("PID output(wrist joint power)", output);
  }
}
