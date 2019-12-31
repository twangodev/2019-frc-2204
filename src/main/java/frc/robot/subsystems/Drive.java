package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Constants;
import frc.robot.lib.Util;

public class Drive {

    private static Drive getDrive = new Drive();

    public static Drive getInstance() {
        return getDrive;
    }

    private Spark leftY, rightY;
    private AHRS navX;

    private DifferentialDrive differentialDrive;

    private Drive() {
        leftY = new Spark(Constants.leftSideSparks);
        rightY = new Spark(Constants.rightSideSparks);
        navX = new AHRS(SPI.Port.kMXP);
        differentialDrive = new DifferentialDrive(leftY, rightY);
    }


    private double setSensitivity(double controlValue) {
        return Constants.curvatureSensitivityBalancer * Math.pow(controlValue, 3) +
            (1 - Constants.curvatureSensitivityBalancer) * controlValue;
    }

    public void drive(double throttle, double turn, boolean isQuickTurn) {
        if (Math.abs(throttle) > Constants.throttleDeadband || Math.abs(turn) > Constants.throttleDeadband) {
            turn = setSensitivity(turn);
            differentialDrive.setQuickStopThreshold(0.5);
            differentialDrive.curvatureDrive(throttle, turn, isQuickTurn);
        } else {
            differentialDrive.curvatureDrive(0, 0, false);
        }
    }

    public void limeLightDrive(double throttle, double turnValue) {
        differentialDrive.arcadeDrive(throttle, turnValue);
    }

    public void arcadeDrive(double throttle, double turn) {
        differentialDrive.arcadeDrive(throttle, turn);
    }

    public void tankDrive(double left, double right) {
        differentialDrive.tankDrive(left, right);
    }

    public void resetNavX() {
        navX.reset();
    }

    public double getAngle() {
        return navX.getAngle();
    }

    public void displayDegrees() {
        System.out.println(navX.getAngle());
    }

}
