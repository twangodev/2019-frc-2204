package frc.robot.subsystems

import edu.wpi.first.wpilibj.Compressor
import edu.wpi.first.wpilibj.DoubleSolenoid

object Hatch {

    private val hatchClamp = DoubleSolenoid(0, 1)
    private val compressor = Compressor(0)

    fun deployHatch() {
        hatchClamp.set(DoubleSolenoid.Value.kForward)
    }

    fun returnClamp() {
        hatchClamp.set(DoubleSolenoid.Value.kReverse)
    }

    fun useCompressor() {
        compressor.closedLoopControl = true
    }

}