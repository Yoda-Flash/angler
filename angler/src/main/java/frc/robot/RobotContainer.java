// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.util.sendable.SendableRegistry;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.arm.ArcadeArm;
import frc.robot.constants.JoystickConstants;
import frc.robot.subsystems.arm.Arm;
import frc.robot.subsystems.arm.ArmIOSim;
import frc.robot.subsystems.arm.ArmIOTalonFX;

public class RobotContainer {

  private final Joystick m_driverJoystick = new Joystick(JoystickConstants.kDriverJoystickPortID);

  // private final ArmIOTalonFX m_armIO = new ArmIOTalonFX();
  private final ArmIOSim m_armIO = new ArmIOSim();
  private final Arm m_arm = new Arm(m_armIO);
  private final ArcadeArm m_arcadeArm = new ArcadeArm(m_arm, m_driverJoystick);

  public RobotContainer() {
    m_arm.setDefaultCommand(m_arcadeArm);

    SendableRegistry.add(m_arm.getSendable(), "Arm");
    Shuffleboard.getTab("SmartDashboard").add(m_arm.getSendable()).withWidget("Arm");

    configureBindings();
  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return null;
  }
}
