package lesson1.part_3.frame_2;

/**
 * Created by otroshenko on 15.02.2016.
 */
public class Tank {


    // 1 - top, 2 - bottom, 3 - left, 4 - right
    private int tankDirection = 1;

    private int tankX = 0;
    private int tankY = 0;
    private int tankSpeed = 5;

    public int getTankDirection() {
        return tankDirection;
    }

    public int getTankX() {
        return tankX;
    }

    public int getTankY() {
        return tankY;
    }

    public int getTankSpeed() {
        return tankSpeed;
    }

    public void setTankDirection(int tankDirection) {
            this.tankDirection = tankDirection;
     }

    public void setTankX(int tankX) {
        this.tankX = tankX;
    }

    public void setTankY(int tankY) {
        this.tankY = tankY;
    }

    public void setTankSpeed(int tankSpeed) {
        this.tankSpeed = tankSpeed;
    }
}