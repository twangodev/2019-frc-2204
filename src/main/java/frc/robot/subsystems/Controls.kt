package frc.robot.subsystems

import edu.wpi.first.wpilibj.Joystick

object Controls {

    private val assistStick = Joystick(0)
    private val throttleStick = Joystick(1)
    private val turnStick = Joystick(2)

    fun getThrottle(): Double {
        return throttleStick.y
    }

    fun getTurn(): Double {
        return turnStick.y
    }

    fun driveShoot(): Boolean {
        return throttleStick.getRawButton(2)
    }

    fun getShooterSpeed(): Double {
        return assistStick.y
    }

    fun displayDegrees(): Boolean {
        return throttleStick.getRawButton(2)
    }

    fun driveReverseIntake(): Boolean {
        return turnStick.getRawButton(2)
    }

    fun isQuickTurn(): Boolean {
        return turnStick.getRawButton(1)
    }

    fun getAimButton(): Boolean {
        return throttleStick.getRawButton(1)
    }

    fun assistJoystickHatch(): Double {
        return assistStick.y
    }

    fun assistDeployHatch(): Boolean {
        return assistStick.getRawButton(4)
    }

    fun resetPiston(): Boolean {
        return assistStick.getRawButton(5)
    }

    fun assistIntake(): Boolean {
        return assistStick.getRawButton(1)
    }

    fun assistReverseIntake(): Boolean {
        return assistStick.getRawButton(3)
    }

    fun assistShoot(): Boolean {
        return assistStick.getRawButton(2)
    }


}