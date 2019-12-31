package frc.robot;

import edu.wpi.cscore.MjpegServer;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import frc.robot.subsystems.*;

public class Robot extends TimedRobot {

    private Drive mDrive = Drive.getInstance();
    private Shooter mShooter = Shooter.getInstance();
    private Controls mControls = Controls.getInstance();
    private Hatch mHatch = Hatch.getInstance();
    private LED mLED = LED.getInstance();

    private NetworkTable limeLight;
    private NetworkTableEntry tx, cam;

    @Override
    public void robotInit() {
        try {
            limeLight = NetworkTableInstance.getDefault().getTable("limelight");
            tx = limeLight.getEntry("tx");
            mHatch.useCompressor();

            UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
            camera.setResolution(320, 240);
            camera.setFPS(15);

        } catch (Throwable t) {
            throw t;
        }
    }

    @Override
    public void autonomousInit() {
        teleopInit();
    }

    @Override
    public void autonomousPeriodic() {
        teleopPeriodic();
    }


    @Override
    public void teleopInit() {
        mLED.setPurple();
        mDrive.resetNavX();
    }

    @Override
    public void teleopPeriodic() {
        try {

            double throttle = mControls.getThrottle();
            double turn = -mControls.getTurn();

            double leftPower = mControls.getThrottle();
            double rightPower = mControls.getTurn();

            double xValue = tx.getDouble(0.0);

            if (mControls.getAimButton()) {} else {
                mDrive.drive(throttle, -turn, mControls.isQuickTurn());
            }

            if (mControls.assistJoystickHatch() == -1.0) {
                mHatch.deployHatch();
            } else if (mControls.assistJoystickHatch() == 1.0) {
                mHatch.returnClamp();
            }

            //shoot and intake are reversed, change variable names

            if (mControls.assistShoot()) {
                mShooter.intakeBall();
            } else if (mControls.assistReverseIntake()) {
                mShooter.reverseIntake();
            } else if (mControls.assistIntake()) {
                mShooter.shootBall();
            } else {
                mShooter.notShooting();
            }

        } catch (Throwable t) {
            throw t;
        }

    }
  
}
