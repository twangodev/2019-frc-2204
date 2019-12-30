/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * Add your docs here.
 */
public class Controls {

    private static Controls getControls = new Controls();

    public static Controls getInstance() {
        return getControls;
    }

    private Joystick assistStick, throttleStick, turnStick;

    public Controls() {
        assistStick = new Joystick(0);
        throttleStick = new Joystick(1);
        turnStick = new Joystick(2);
    }

	public double getThrottle() {
		return throttleStick.getY();
	}

	public double getTurn() {
		return turnStick.getY();
    }
    
    public boolean driveShoot() {
        return throttleStick.getRawButton(2);
    }

    public double getShooterSpeed() {
        return assistStick.getY();
    }

    public boolean displayDegrees() {
        return throttleStick.getRawButton(2);
    }

    public boolean driveReverseIntake() {
        return turnStick.getRawButton(2);
    }

	public boolean isQuickTurn() {
		return turnStick.getRawButton(1);
	}

	public boolean getAimButton() {
		return throttleStick.getRawButton(1);
    }

    public double assistJoystickHatch() {
        return assistStick.getY();
    }

    public boolean assistDeployHatch() {
        return assistStick.getRawButton(4);
    }
    
    public boolean resetPiston() {
        return assistStick.getRawButton(5);
    }

	public boolean assistIntake() {
		return assistStick.getRawButton(1);
	}

	public boolean assistReverseIntake() {
		return assistStick.getRawButton(3);
    }
    
	public boolean assistShoot() {
		return assistStick.getRawButton(2);
	}


}