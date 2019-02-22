/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;



import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;

public class TankDrivePneumatics extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	//Creates solenoid object
    
        //back left piston
		Solenoid solenoid1 = new Solenoid(1, RobotMap.backLeftPiston1);
        //back right piston
        Solenoid solenoid2 = new Solenoid(1, RobotMap.backRightPiston1);
        //front left piston
        DoubleSolenoid solenoid3= new DoubleSolenoid(1, RobotMap.frontLeftPiston1, RobotMap.frontLeftPiston2);
        //front right piston
        DoubleSolenoid solenoid4= new DoubleSolenoid(1, RobotMap.frontRightPiston1, RobotMap.frontRightPiston2);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    
    public void outFront() {
    	solenoid3.set(DoubleSolenoid.Value.kForward);
    	solenoid4.set(DoubleSolenoid.Value.kForward);
    	SmartDashboard.putString("Pnuematics Front","Out");
    }

    public void inFront() 
    {
        
    	solenoid3.set(DoubleSolenoid.Value.kReverse);
    	solenoid4.set(DoubleSolenoid.Value.kReverse);
    	SmartDashboard.putString("Pnuematics Front","In");
    }
    
public void outBack()
    {
        solenoid1.set(true);
        solenoid2.set(true);
        /*
        solenoid1.set(DoubleSolenoid.Value.kForward);
        solenoid2.set(DoubleSolenoid.Value.kForward);
        */
    	SmartDashboard.putString("Pnuematics Back","Out");
    }
    
    public void inBack() 
    {
    	//solenoid1.set(DoubleSolenoid.Value.kReverse);
    	//solenoid2.set(DoubleSolenoid.Value.kReverse);
    	SmartDashboard.putString("Pnuematics Back","In");
    }
    
    
    public void rest() {
    	solenoid3.set(DoubleSolenoid.Value.kOff);
    	solenoid4.set(DoubleSolenoid.Value.kOff);
    }

}