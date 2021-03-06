/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.GearsOut;
import frc.robot.commands.MoveMotorBackward;
import frc.robot.commands.MoveMotorForward;
//import frc.robot.commands.MoveMotorBackward;
//import frc.robot.commands.MoveMotorForward;
import frc.robot.commands.PneumaticsCommandInBack;
import frc.robot.commands.PneumaticsCommandInFront;
import frc.robot.commands.PneumaticsCommandOut;
import frc.robot.commands.PneumaticsCommandOutBack;
import frc.robot.commands.PneumaticsCommandOutFront;
import frc.robot.commands.ReadAnalogueGauge;
//import frc.robot.commands.ReadAnalogueGauge; 
import frc.robot.commands.SetTargets;



/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());



  public static Joystick joyLeft = new Joystick(0); 
  public static Joystick joyRight = new Joystick(1);
  public static Joystick gamepad = new Joystick(2);
  
  Button buttonFOut = new JoystickButton(joyRight, 5);
  Button buttonFIn = new JoystickButton(joyRight, 6);

  
  Button buttonBOut = new JoystickButton(joyRight, 3);
  Button buttonBIn = new JoystickButton(joyRight, 4);

  Button pneumaticIntakeButton = new JoystickButton(gamepad, 1); //change later

  Button ButtonIntakeIn = new JoystickButton(gamepad, 5); 
  Button ButtonIntakeOut = new JoystickButton(gamepad, 6);

  Button intakePositionOut = new JoystickButton(gamepad, 2);

  Button switchGear = new JoystickButton(joyRight, 1);

  Button analogGauge = new JoystickButton(joyRight, 12);

  
  
  Button wristTargetButton = new JoystickButton(gamepad, 2);
  
  Button wristTargetReset = new JoystickButton(gamepad, 3);
  
  

  //Button buttonnFOut = new JoystickButton(joyRight, 5);//not real button #, TBD
  //Button buttonFIn = new JoystickButton(joyRight, 6);//not real button #, TBD
  //Button buttonBOut = new JoystickButton(joyRight, 3);//not real button #, TBD
  //Button buttonBIn = new JoystickButton(joyRight, 4);//not real button #, TBD

  public OI(){
   
    //intake pneumatics
    pneumaticIntakeButton.whileHeld(new PneumaticsCommandOut());

    //tankdrive 
    
    buttonFOut.whenPressed(new PneumaticsCommandOutFront()); //right 6
    buttonFIn.whenPressed(new PneumaticsCommandInFront()); //right 7

    buttonBOut.whenPressed(new PneumaticsCommandOutBack()); //right 4
    buttonBIn.whenPressed(new PneumaticsCommandInBack()); //right 2
    

    //gear pneumatics
    switchGear.whileHeld(new GearsOut());

    ButtonIntakeIn.whileHeld(new MoveMotorForward());
    ButtonIntakeOut.whileHeld(new MoveMotorBackward());
    
    //analogGauge.whenPressed(new ReadAnalogueGauge() );
    

    //wristTargetButton.whenPressed(new SetTargets(1000));
    //wristTargetReset.whenPressed(new SetTargets(0));
    
  }
  
  
}

