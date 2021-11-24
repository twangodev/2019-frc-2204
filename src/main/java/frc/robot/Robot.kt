// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot

import edu.wpi.first.networktables.NetworkTable
import edu.wpi.first.networktables.NetworkTableEntry
import edu.wpi.first.networktables.NetworkTableInstance
import edu.wpi.first.wpilibj.TimedRobot
import frc.robot.subsystems.Controls
import frc.robot.subsystems.Drive
import frc.robot.subsystems.Drive.drive
import frc.robot.subsystems.Hatch
import frc.robot.subsystems.Shooter

/**
 * The VM is configured to automatically run this class, and to call the methods corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class
 * or the package after creating this project, you must also update the build.gradle file in the
 * project.<br></br>
 * <br></br>
 * This class, via its super class, provides the following methods which are called by the main loop:<br></br>
 * <br></br>
 * - startCompetition(), at the appropriate times:<br></br>
 * <br></br>
 * - robotInit() -- provide for initialization at robot power-on<br></br>
 * <br></br>
 * init methods -- each of the following methods is called once when the appropriate mode is entered:<br></br>
 * - disabledInit()   -- called each and every time disabled is entered from another mode<br></br>
 * - autonomousInit() -- called each and every time autonomous is entered from another mode<br></br>
 * - teleopInit()     -- called each and every time teleop is entered from another mode<br></br>
 * - testInit()       -- called each and every time test is entered from another mode<br></br>
 * <br></br>
 * periodic methods -- each of these methods is called on an interval:<br></br>
 * - robotPeriodic()<br></br>
 * - disabledPeriodic()<br></br>
 * - autonomousPeriodic()<br></br>
 * - teleopPeriodic()<br></br>
 * - testPeriodic()<br></br>
 */
class Robot : TimedRobot() {

    private lateinit var limelight: NetworkTable
    private lateinit var tx: NetworkTableEntry

    /**
     * This method is run when the robot is first started up and should be used for any
     * initialization code.
     */
    override fun robotInit() {
        limelight = NetworkTableInstance.getDefault().getTable("limelight")
        tx = limelight.getEntry("tx")

    }

    override fun robotPeriodic() {}
    override fun autonomousInit() {}
    override fun autonomousPeriodic() {}
    override fun teleopInit() {}
    override fun teleopPeriodic() {
        val throttle = Controls.getThrottle()
        val turn = -Controls.getTurn()

        val leftPower = Controls.getThrottle()
        val rightPower = Controls.getTurn()

        val xValue: Double = tx.getDouble(0.0)

        if (!Controls.getAimButton()) {
            drive(throttle, -turn, Controls.isQuickTurn())
        }

        if (Controls.assistJoystickHatch() == -1.0) {
            Hatch.deployHatch()
        } else if (Controls.assistJoystickHatch() == 1.0) {
            Hatch.returnClamp()
        }

        //shoot and intake are reversed, change variable names
        //shoot and intake are reversed, change variable names
        if (Controls.assistShoot()) {
            Shooter.intakeBall()
        } else if (Controls.assistReverseIntake()) {
            Shooter.reverseIntake()
        } else if (Controls.assistIntake()) {
            Shooter.shootBall()
        } else {
            Shooter.notShooting()
        }
    }
    override fun disabledInit() {}
    override fun disabledPeriodic() {}
    override fun testInit() {}
    override fun testPeriodic() {}
}