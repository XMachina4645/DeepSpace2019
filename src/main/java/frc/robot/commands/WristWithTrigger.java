/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;
 
public class WristWithTrigger extends Command {
  
  public WristWithTrigger() {
    // Use requires() here to declare subsystem dependencies
    //requires(Robot.elbowJointSub);
    requires(Robot.wristJointSub);
    //PIDController elbowPID = Robot.elbowJointSub.getPIDController();
    //RobotMap.armJointMotorLeft.setInverted(true);
  
  }


  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    RobotMap.wristJointMotorLeft.setInverted(true);
    RobotMap.wristJointMotorLeft.follow(RobotMap.wristJointMotorRight);
  }


  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    //Robot.elbowJointSub.moveArmWithTrigger();
    Robot.wristJointSub.moveWristWithTrigger();
    //SmartDashboard.putNumber("left arm motor power", RobotMap.armJointMotorLeft.get());
    //SmartDashboard.putNumber("current left arm econder value", RobotMap.armJointMotorLeft.getSelectedSensorPosition());
    //SmartDashboard.putNumber("left wrist joint motor power", RobotMap.wristJointMotorLeft.get());
    SmartDashboard.putNumber("right wrist joint motor power", RobotMap.wristJointMotorRight.get());
    SmartDashboard.putNumber("current right wrist joint encoder value", RobotMap.wristJointMotorRight.getSelectedSensorPosition());

  }
  
  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
  
}


