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

public class SetTargets extends Command {
  double target;
  public SetTargets(double wristTarget) { //sets setpoints for the elbow and wrist
    target = wristTarget;
    
    // Use requires() here to declare subsystem dependencies
    requires(Robot.wristJointSub);
    
    /*
    requires(Robot.elbowJointSub);
    Robot.elbowJointSub.setTargetPosition(elbowTarget);
    //Robot.wristJointSub.setTargetPosition(wristTarget);
    */
    //PIDController wristPID = Robot.wristJointSub.getPIDController();
    //SmartDashboard.putNumber("Arc Length", Robot.elbowJointSub.angle);

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.wristJointSub.setTargetPosition(target);

    SmartDashboard.putNumber("Position", RobotMap.wristJointMotorRight.getSelectedSensorPosition());



  }



  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if (Robot.wristJointSub.onTarget()) {
      return true;
    }
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
