package frc.robot.subsystems

import com.kauailabs.navx.frc.AHRS
import edu.wpi.first.wpilibj.SPI
import edu.wpi.first.wpilibj.Spark
import edu.wpi.first.wpilibj.drive.DifferentialDrive
import frc.robot.Constants
import kotlin.math.abs
import kotlin.math.pow

object Drive {

    private val leftSpark = Spark(Constants.leftSideSparks)
    private val rightSpark = Spark(Constants.rightSideSparks)

    private val navX = AHRS(SPI.Port.kMXP)
    val angle: Double get() = navX.angle
    fun resetNavX() = navX.reset()

    private val differentialDrive = DifferentialDrive(leftSpark, rightSpark)

    private fun setSensitivity(controlValue: Double): Double {
        return Constants.curvatureSensitivityBalancer * controlValue.pow(3.0) + (1 - Constants.curvatureSensitivityBalancer) * controlValue
    }

    fun drive(throttle: Double, turn: Double, isQuickTurn: Boolean) {
        if (abs(throttle) > Constants.throttleDeadband || abs(turn) > Constants.throttleDeadband) {
            val sensitivityTurn = setSensitivity(turn)
            differentialDrive.setQuickStopThreshold(0.5)
            differentialDrive.curvatureDrive(throttle, sensitivityTurn, isQuickTurn)
        } else {
            differentialDrive.curvatureDrive(0.0, 0.0, false)
        }
    }

    fun limeLightDrive(throttle: Double, turnValue: Double) {
        differentialDrive.arcadeDrive(throttle, turnValue)
    }

    fun arcadeDrive(throttle: Double, turn: Double) {
        differentialDrive.arcadeDrive(throttle, turn)
    }

    fun tankDrive(left: Double, right: Double) {
        differentialDrive.tankDrive(left, right)
    }

}