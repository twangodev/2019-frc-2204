package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Limelight {

  private NetworkTable limeLight;
  private NetworkTableEntry tx, ty, ta, ledMode, pipeline, camMode;

  public Limelight() {
    limeLight = NetworkTableInstance.getDefault().getTable("limelight");
    tx = limeLight.getEntry("tx");
    ty = limeLight.getEntry("ty");
    ta = limeLight.getEntry("ta");
    ledMode = limeLight.getEntry("ledMode");
    pipeline = limeLight.getEntry("pipeline");
    camMode = limeLight.getEntry("camMode");
  }

  public void usePipeline(double p) {
    pipeline.setNumber(p);
  }

  public void setLEDBlink() {
    ledMode.setNumber(2);
  }

  public void setLEDOn() {
    ledMode.setNumber(1);
  }

  public void setLEDOff() {
    ledMode.setNumber(3);
  }

  public void setVisionProcessing() {
    camMode.setNumber(0);
  }

  public void setDriverCamera() {
    camMode.setNumber(1);
  }

  public double getX() {
    return tx.getDouble(0.0);
  }

  public double getY() {
    return ty.getDouble(0.0);
  }

  public double getArea() {
    return ta.getDouble(0.0);
  }

}