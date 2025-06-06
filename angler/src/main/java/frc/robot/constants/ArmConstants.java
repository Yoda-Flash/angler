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

    // Mechanical
    public static final double kGearRatio = 40.0742;
    public static final double kMomentOfInertiaKgMetersSquared = 0.248235976;
    public static final double kArmLengthMeters = 0.308;
    public static final double kMinAngleRads = Math.toRadians(-20);
    public static final double kMaxAngleRads = Math.toRadians(160);
    public static final double kStartingAngleRads = 0.0;

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
