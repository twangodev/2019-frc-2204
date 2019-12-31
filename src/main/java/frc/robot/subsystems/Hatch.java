package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Hatch extends Subsystem {

  private static Hatch getHatch = new Hatch();

  public static Hatch getInstance() {
	return getHatch;
  }

  private DoubleSolenoid hatchClamp;
  private DoubleSolenoid hatchClampTwo;
  private Compressor mCompressor;
  private DigitalInput limitSwitch;

  private Hatch() {
    hatchClamp = new DoubleSolenoid(0, 1);
    mCompressor = new Compressor(0);
  }

  public void deployHatch() {
    hatchClamp.set(Value.kForward);
  }

  public void returnClamp() {
    hatchClamp.set(Value.kReverse);
  }

  public void useCompressor() {
    mCompressor.setClosedLoopControl(true);
  }

  @Override
  public void initDefaultCommand() {

  }
	
}
