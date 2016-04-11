package lesson4.part_05.frame_10.OLD.utils;

import lesson4.part_05.frame_10.OLD.enums.Direction;
import lesson4.part_05.frame_10.OLD.interfaces.Destroyable;
import lesson4.part_05.frame_10.OLD.interfaces.Drawable;
import lesson4.part_05.frame_10.OLD.tanks.AbstractTank;

import java.awt.*;

public class Bullet implements Drawable, Destroyable {

    private int x;
    private int y;

    private byte speed = 20;
    private Direction direction;
    private int butlleStep = 5;
    private final int SIZE_BULLET = 14;
    private AbstractTank tank;

    public Bullet() {
        x = -100;
        y = -100;
        direction = Direction.MOVE_UP;
    }

    public Bullet(int x, int y, Direction direction, AbstractTank tank) {
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

    @Override
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

    public AbstractTank getTank() {
        return tank;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(this.x,this.y, 14,14);
    }
}