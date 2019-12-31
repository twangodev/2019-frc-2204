package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {

    private static Shooter getShooter = new Shooter();

    public static Shooter getInstance() {
        return getShooter;
    }

    private VictorSP firstShooter, secondShooter;

    private Shooter() {
        firstShooter = new VictorSP(2);
        secondShooter = new VictorSP(3);
    }

    private static final double intakePower = 0.2;
    private static final double shootPower = 0.55;

    private void shootAtSpeed(double speed) {
        firstShooter.set(-speed);
        secondShooter.set(-speed);
    }

    public void intakeBall() {
        shootAtSpeed(0.15);
    }

    public void shootBall() {
        shootAtSpeed(shootPower);
    }

    public void reverseIntake() {
        shootAtSpeed(-intakePower);
    }

    public void notShooting() {
        firstShooter.set(0.0);
        secondShooter.set(0.0);
    }

    @Override
    public void initDefaultCommand() {

    }
}
