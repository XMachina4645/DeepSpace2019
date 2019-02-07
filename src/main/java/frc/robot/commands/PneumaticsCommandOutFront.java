package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class PneumaticsCommandOutFront extends Command
{
    public PneumaticsCommandOutFront()
    {
       requires(Robot.pneumaticsOb);
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {

        Robot.pneumaticsOb.outFront();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
        return false;
    }

    // Called once after isFinished returns true
    protected void end()
    {
        Robot.pneumaticsOb.inFront();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted()
    {
        Robot.pneumaticsOb.inFront();
    }


}