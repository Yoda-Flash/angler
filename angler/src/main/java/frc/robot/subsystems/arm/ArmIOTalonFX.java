// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.arm;

import com.ctre.phoenix6.BaseStatusSignal;
import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import frc.robot.constants.ArmConstants;
import frc.robot.subsystems.arm.ArmIO.ArmIOInputs;

/** Add your docs here. */
public class ArmIOTalonFX implements ArmIO {
    private final TalonFX m_arm = new TalonFX(ArmConstants.kTalonID);
    private DigitalInput m_topLimitSwitch = new DigitalInput(ArmConstants.kTopLimitSwitchChannel);
    private DigitalInput m_bottomLimitSwitch = new DigitalInput(ArmConstants.kBottomLimitSwitchChannel);
    private DutyCycleEncoder m_encoder = new DutyCycleEncoder(ArmConstants.kEncoderChannel);

    public ArmIOTalonFX() {
        m_arm.setNeutralMode(NeutralModeValue.Brake);
    }

    @Override
    public void updateInputs(ArmIOInputs inputs) {
        inputs.data = new ArmIOData(
            m_arm.get(),
            m_encoder.get(),
            !m_topLimitSwitch.get(),
            !m_bottomLimitSwitch.get()
        );
    }

    @Override
    public void runSpeed(double speed) {
        m_arm.set(speed);
        System.out.println(m_arm.get());
    }

    @Override
    public void stop() {
        m_arm.stopMotor();
    }
}
