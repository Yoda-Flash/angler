// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.arm;

import org.littletonrobotics.junction.AutoLog;

/** Add your docs here. */
public interface ArmIO {

    @AutoLog
    public class ArmIOInputs {
        public ArmIOData data = new ArmIOData(0.0, 0.0, false, false);
    }

    record ArmIOData(
        double armSpeed,
        double encoderValue,
        boolean topLimitSwitchTriggered,
        boolean bottomLimitSwitchTriggered
    ) {}

    default void updateInputs(ArmIOInputs inputs) {}

    default void runSpeed(double speed) {}

    default void stop() {}

    default void updateSimState() {}
}
