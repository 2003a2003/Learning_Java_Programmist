package lesson1.part_3.frame_2;
/**
 * Created by otroshenko on 15.02.2016.
 */
public class Bullet {

    private final byte MOVE_UP    = 1;
    private final byte MOVE_DOWN  = 2;
    private final byte MOVE_LEFT  = 3;
    private final byte MOVE_RIGHT = 4;
    private final byte SPEED = 5;

    private int x;
    private int y;

    private int direction;
    private int butlleStep = 5;

    private void setDefoultXY() {
        x = -100;
        y = -100;
        direction = MOVE_UP;
    }

    private void updateDir(int direction) {
        if (getDirection() != direction) {
            this.direction = direction;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDirection() {
        return direction;
    }

    public int getSpeed() {
        return SPEED;
    }

    public void updateX(int x) {
        if(this.x != x){
            this.x = x;
        }
    }

    public void updateY(int y) {
        if (this.y != y){
            this.y = y;
        }
    }

    public void destroy() {
        x = -100;
        y = -100;
   }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getButlleStep() {
        return butlleStep;
    }

    public void setButlleStep(int butlleStep) {
        this.butlleStep = butlleStep;
    }
}
