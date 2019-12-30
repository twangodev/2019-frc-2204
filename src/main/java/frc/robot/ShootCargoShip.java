/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.command.TimedCommand;
import frc.robot.subsystems.Shooter;

public class ShootCargoShip extends TimedCommand {

  private Shooter mShooter = Shooter.getInstance();

  public ShootCargoShip(double timeout) {
    super(timeout);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    mShooter.shootBall();
  }

  // Called once after timeout
  @Override
  protected void end() {
    mShooter.notShooting();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
