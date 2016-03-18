package lesson1.part_3.frame_8;

/**
 * Created by otroshenko on 15.02.2016.
 */
public class Tank {


    // 1 - top, 2 - bottom, 3 - left, 4 - right
    private int direction;

    private int x = 0;
    private int y = 0;
    private int tankSpeed = 5;

    public Tank(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getTankDirection() {
        return direction;
    }

    public int getTankX() {
        return x;
    }

    public int getTankY() {
        return y;
    }

    public int getTankSpeed() {
        return tankSpeed;
    }

    public void setTankDirection(int direction) {
        chengeDirection(direction);
    }

    public void setTankX(int tankX) {
        this.x = tankX;
    }

    public void setTankY(int tankY) {
        this.y = tankY;
    }

    public void chengeDirection(int direction) {
        if (getTankDirection() != direction) {
            this.direction = direction;
        }
    }

    public void updateX(int x) {
        this.x += x;
    }

    public void updateY(int y) {
        this.y += y;
    }

}
