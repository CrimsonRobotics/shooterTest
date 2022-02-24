// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;


/**
 * This sample program shows how to control a motor using a joystick. In the operator control part
 * of the program, the joystick is read and the value is written to the motor.
 *
 * <p>Joystick analog values range from -1 to 1 and speed controller inputs also range from -1 to 1
 * making it easy to work together.
 */
public class Robot extends TimedRobot {
  private static final int kFeeder1 = 61;
  private static final int kFeeder2 = 54;
  private static final int kShooter1 = 55;
  private static final int kShooter2 = 48;
  private static final int kJoystickPort = 0;

  private static CANSparkMax m_feeder1;
  private static CANSparkMax m_feeder2;
  private static CANSparkMax m_shooter1;
  private static CANSparkMax m_shooter2;
  private Joystick m_joystick;
  private JoystickButton m_shoot;

  @Override
  public void robotInit() {
    m_feeder1 = new CANSparkMax(kFeeder1, MotorType.kBrushless);
    m_feeder2 = new CANSparkMax(kFeeder2, MotorType.kBrushless);
    m_shooter1 = new CANSparkMax(kShooter1, MotorType.kBrushless);
    m_shooter2 = new CANSparkMax(kShooter2, MotorType.kBrushless);

     m_feeder1.setInverted(true); 
     m_feeder2.setInverted(false); 
    m_shooter1.setInverted(false);
    m_shooter2.setInverted(true);
     m_feeder1.setIdleMode(IdleMode.kCoast);
     m_feeder2.setIdleMode(IdleMode.kCoast);
    m_shooter1.setIdleMode(IdleMode.kCoast);
    m_shooter2.setIdleMode(IdleMode.kCoast);
    m_joystick = new Joystick(kJoystickPort);
    m_shoot = new JoystickButton(m_joystick, 1);
  }

  @Override
  public void teleopPeriodic() {
    double speed = 0;

    if (m_shoot.get()) speed = 0.55;
    else speed = 0;
    m_feeder1.set(speed);
    m_feeder2.set(speed);
    m_shooter1.set(speed);
    m_shooter2.set(speed);
  }
}
