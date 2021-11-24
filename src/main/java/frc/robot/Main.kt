// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot

import edu.wpi.first.wpilibj.TimedRobot
import kotlin.jvm.JvmStatic
import edu.wpi.first.wpilibj.RobotBase
import java.util.function.Supplier

/**
 * Do NOT add any static variables to this class, or any initialization at all. Unless you know what
 * you are doing, do not modify this file except to change the parameter class to the startRobot call.
 */
object Main {
    /**
     * Main initialization method. Do not perform any initialization here.
     *
     *
     * If you change your main Robot class (name), change the parameter type.
     */
    @JvmStatic
    fun main(args: Array<String>) {
        RobotBase.startRobot { Robot() }
    }
}