// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.arm;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {

  private final ArmIO m_io;
  private final ArmIOInputsAutoLogged m_inputs = new ArmIOInputsAutoLogged();

  private ArmSendable m_sendable = new ArmSendable();

  /** Creates a new Arm. */
  public Arm(ArmIO io) {
    m_io = io;
  }

  public ArmSendable getSendable() {
    return m_sendable;
  }

  public void setSpeed(double speed) {
    if (isSafe(speed)) m_io.runSpeed(speed);
  }

  public boolean isSafe(double speed) {
    if ((getTopLimitSwitchTriggered() && speed > 0) || (getBottomLimitSwitchTriggered() && speed < 0)){
      speed = 0;
      return false;
    } else return true;
  }

  public double getEncoderPosition() {
    return m_inputs.data.encoderValue();
  }

  public boolean getTopLimitSwitchTriggered() {
    return m_inputs.data.topLimitSwitchTriggered();
  }

  public boolean getBottomLimitSwitchTriggered() {
    return m_inputs.data.bottomLimitSwitchTriggered();
  }

  @Override
  public void periodic() {
    m_io.updateInputs(m_inputs);
    Logger.processInputs("Arm", m_inputs);
    // This method will be called once per scheduler run
  }

  public class ArmSendable implements Sendable {

    @Override
    public void initSendable(SendableBuilder builder) {
      builder.setSmartDashboardType("Arm");
      builder.addDoubleProperty("Ticks", () -> getEncoderPosition(), null);
      builder.addDoubleProperty("Speed", () -> m_inputs.data.armSpeed(), Arm.this::setSpeed);
      builder.addBooleanProperty("Top Limit Switch Triggered", () -> getTopLimitSwitchTriggered(), null);
      builder.addBooleanProperty("Bottom Limit Switch Triggered", () -> getBottomLimitSwitchTriggered(), null);
    }
  }
}
