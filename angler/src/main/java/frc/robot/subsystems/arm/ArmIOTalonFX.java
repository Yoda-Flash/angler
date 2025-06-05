// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.arm;

import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.configs.VoltageConfigs;
import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.ctre.phoenix6.sim.TalonFXSimState;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.RobotController;
import frc.robot.constants.ArmConstants;

/** Add your docs here. */
public class ArmIOTalonFX implements ArmIO {
    private final TalonFX m_arm = new TalonFX(ArmConstants.kTalonID);

    private MotorOutputConfigs m_motorOutputConfig = new MotorOutputConfigs();
    private VoltageConfigs m_voltageConfig = new VoltageConfigs();
    private TalonFXConfiguration m_config = new TalonFXConfiguration();
    private TalonFXSimState m_simState = m_arm.getSimState();

    private DigitalInput m_topLimitSwitch = new DigitalInput(ArmConstants.kTopLimitSwitchChannel);
    private DigitalInput m_bottomLimitSwitch = new DigitalInput(ArmConstants.kBottomLimitSwitchChannel);
    private DutyCycleEncoder m_encoder = new DutyCycleEncoder(ArmConstants.kEncoderChannel);

    private DutyCycleOut m_dutyCycleOut = new DutyCycleOut(0.0);

    public ArmIOTalonFX() {
        m_arm.setNeutralMode(NeutralModeValue.Brake);
        m_motorOutputConfig.withPeakForwardDutyCycle(1);
        m_motorOutputConfig.withPeakReverseDutyCycle(-1);
        m_motorOutputConfig.DutyCycleNeutralDeadband = 0.01;
        m_voltageConfig.PeakForwardVoltage = 12;
        m_voltageConfig.PeakReverseVoltage = 12;
        m_config.withMotorOutput(m_motorOutputConfig);
        m_config.withVoltage(m_voltageConfig);
        m_dutyCycleOut.EnableFOC = false;

        m_arm.getConfigurator().apply(m_config);
        m_simState.setSupplyVoltage(RobotController.getBatteryVoltage());
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
        // m_arm.set(speed);
        m_dutyCycleOut.Output = 0.50;
        m_arm.setControl(m_dutyCycleOut);
        m_simState = m_arm.getSimState();
        System.out.println(m_simState.getMotorVoltage()/RobotController.getBatteryVoltage());
    }

    @Override
    public void stop() {
        m_arm.stopMotor();
    }

    @Override
    public void updateSimState() {
        m_simState = m_arm.getSimState();
    }
}
