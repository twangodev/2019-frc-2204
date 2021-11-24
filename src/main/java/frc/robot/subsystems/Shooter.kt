package frc.robot.subsystems

import edu.wpi.first.wpilibj.VictorSP
import frc.robot.Constants

private const val intakePower = 0.2
private const val shootPower = 0.55

object Shooter {

    private val leftShooter = VictorSP(Constants.leftShooter)
    private val rightShooter = VictorSP(Constants.rightShooter)

    private fun shootAtSpeed(speed: Double) {
        leftShooter.set(-speed)
        rightShooter.set(-speed)
    }


    fun intakeBall() {
        shootAtSpeed(0.15)
    }

    fun shootBall() {
        shootAtSpeed(shootPower)
    }

    fun reverseIntake() {
        shootAtSpeed(intakePower)
    }

    fun notShooting() {
        leftShooter.set(0.0)
        rightShooter.set(0.0)
    }

}