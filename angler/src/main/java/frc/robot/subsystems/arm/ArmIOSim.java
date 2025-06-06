// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.arm;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.simulation.SingleJointedArmSim;
import frc.robot.constants.ArmConstants;

/** Add your docs here. */
public class ArmIOSim implements ArmIO {
    private final SingleJointedArmSim m_armSim = new SingleJointedArmSim(DCMotor.getFalcon500(1), ArmConstants.kGearRatio, ArmConstants.kMomentOfInertiaKgMetersSquared, ArmConstants.kArmLengthMeters, ArmConstants.kMinAngleRads, ArmConstants.kMaxAngleRads, true, ArmConstants.kStartingAngleRads);

    public ArmIOSim() {}

    @Override
    public void updateInputs(ArmIOInputs inputs) {
        inputs.data = new ArmIOData(
            0.0,
            0.0,
            false,
            false
        );
    }

    @Override
    public void runSpeed(double speed) {
        m_armSim.setInputVoltage(speed*RobotController.getBatteryVoltage());
        System.out.println(m_armSim.getInput());
    }

    @Override
    public void stop() {

    }

    @Override
    public void updateSimState() {
        m_armSim.update(0.02);
    }
}
