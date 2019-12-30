package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;

public class LED {

    private static LED getLED = new LED();

    public static LED getInstance() {
        return getLED;
    }

    private Spark ledController;

    private LED() {
        ledController = new Spark(4);
    }

    public void setPurple() {
        ledController.set(0.57);
    }

    public void setRed() {
        ledController.set(0.61);
    }

}
