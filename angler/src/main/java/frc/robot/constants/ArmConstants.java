// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.constants;

/** Add your docs here. */
public class ArmConstants {
    // IDs
    public static final int kTalonID = 23;
    public static final int kTopLimitSwitchChannel = 1;
    public static final int kBottomLimitSwitchChannel = 6;
    public static final int kEncoderChannel = 5;

    // Joystick bindings
    public static final int kManualAxis = 1;

    // Control
    public static final double kMultiplier = 0.5;

    public static final double kP = 1.6;
    public static final double kI = 0;
    public static final double kD = 0;
    public static final double kIZone = 0.05;

    // Positions
    public static final double kL1Ticks = 0.850;
    public static final double kL2Ticks = 0.863;
    public static final double kL3Ticks = 0.850;
    public static final double kL4Ticks = 0.795;

    public static final double kL2DealgaeTicks = 0.872;
    public static final double kL3DealgaeTicks = 0.872;

    public static final double kSubstationTicks = 0.420;
    public static final double kGroundIntakeTicks = 0.477;
}
