package lesson2.part_6.frame_10;

public class Bullet {

    private int x;
    private int y;

    private byte speed = 20;
    private Direction direction;
    private int butlleStep = 5;
    private final int SIZE_BULLET = 14;
    private Tank tank;

    public Bullet(Tank tank) {
        x = -100;
        y = -100;
        direction = Direction.MOVE_UP;
    }

    public Bullet(int x, int y, Direction direction, Tank tank) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.tank = tank;
    }

    public void updateX(int x) {
        this.x += x;
    }

    public void updateY(int y) {
        this.y += y;
    }

    public void destroy() {
        x = -100;
        y = -100;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getSpeed() {
        return speed;
    }

    public int getButlleStep() {
        return butlleStep;
    }

    public void updateDirection(Direction direction) {
        this.direction = direction;
    }

    public int getSIZE_BULLET() {
        return SIZE_BULLET;
    }

    public Tank getTank() {
        return tank;
    }
}