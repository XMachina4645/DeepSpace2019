/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import frc.robot.subsystems.ElbowJoint;
import frc.robot.commands.PneumaticsCommandInFront;
import frc.robot.subsystems.ClimbingPneumatics;
import frc.robot.subsystems.ElbowJoint;
import frc.robot.subsystems.IntakePneumatics;
import frc.robot.subsystems.RevAirPressureSensor; 
import frc.robot.subsystems.TankDrive;
import frc.robot.subsystems.TankDriveGears;
//import frc.robot.subsystems.TankDrivePneumatics;
import frc.robot.subsystems.WristJoint;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer; 
import frc.robot.subsystems.WristJoint;
import frc.robot.subsystems.IntakeMotorSubsystem;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static OI m_oi; 
  public static TankDrive tankDriveSubsystem = new TankDrive();
  public static ElbowJoint elbowJointSub = new ElbowJoint();
  public static WristJoint wristJointSub = new WristJoint();
  public static IntakePneumatics pneumaticsSubsystem = new IntakePneumatics();
  public static IntakeMotorSubsystem motorSub = new IntakeMotorSubsystem();
  public static TankDriveGears tankDriveGears = new TankDriveGears();
  public static ClimbingPneumatics climbingPneumaticsOb = new ClimbingPneumatics(); 
  
  public static RevAirPressureSensor revAirPressureOb= new RevAirPressureSensor();//not real channel

  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  UsbCamera deepSpaceCamera = CameraServer.getInstance().startAutomaticCapture(0);

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    m_oi = new OI();

   // m_chooser.setDefaultOption("Default Auto", new Command());

    //m_chooser.setDefaultOption("Default Auto", new Command());

    // chooser.addOption("My Auto", new MyAutoCommand());
    SmartDashboard.putData("Auto mode", m_chooser);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_chooser.getSelected();

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    //Scheduler.getInstance().run();
    teleopPeriodic();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
