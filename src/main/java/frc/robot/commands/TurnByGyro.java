/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class TurnByGyro extends Command {
  private double endAngle;
  private double degrees;
  private boolean isLeft;
  public TurnByGyro(double pDegrees) {
    endAngle = Robot.kGyro.getAngle() + pDegrees;
    degrees = pDegrees;
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    if(degrees < 0){
      isLeft = true;
    }else{
      isLeft = false;
    }
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.kTankDrive.turnInPlace(isLeft);//this might not work
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if( (Robot.kGyro.getAngle() < (endAngle + 1)) && (Robot.kGyro.getAngle() > (endAngle - 1))){
    //trying to acount for error probably not nessesary, may even cause problems
    //if( Robot.kGyro.getAngle() == endAngle){
      return true;
    }
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.kTankDrive.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.kTankDrive.stop();
  }
}