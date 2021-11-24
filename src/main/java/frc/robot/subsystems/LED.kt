package frc.robot.subsystems

import edu.wpi.first.wpilibj.Spark
import frc.robot.Constants

private val ledController = Spark(Constants.ledPort)

enum class Color(val value: Double) {
    Purple(0.57),
    Red(0.61)
}

object LED {

    fun setColor(color: Color) {
        ledController.set(color.value)
    }

}