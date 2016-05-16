package lesson5.part_04.frame_09.bf.tanks;

import lesson5.part_04.frame_09.Direction;
import lesson5.part_04.frame_09.bf.BattleField;

import java.awt.*;
import java.awt.image.ImageObserver;

public abstract class AbstractTank implements Tank {

    private int speed = 10;
    protected int movePath = 1;

    // 1 - up, 2 - down, 3 - left, 4 - right
    private Direction direction;

    // current position on BF
    private int x;
    private int y;

    private boolean destroyed;

    private BattleField bf;

    protected Color tankColor;
    protected Color towerColor;
    protected Image img;

    public AbstractTank(BattleField bf) {
        this(bf, 128, 512, Direction.UP);
    }

    public AbstractTank(BattleField bf, int x, int y, Direction direction) {
        this.bf = bf;
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.destroyed = false;
    }


    public void turn(Direction direction) {
        this.direction = direction;
    }

    public void move() {
    }

    public Bullet fire() {
        int bulletX = -100;
        int bulletY = -100;
		if (direction == Direction.UP) {
			bulletX = x + 25;
			bulletY = y - 64;
		} else if (direction == Direction.DOWN) {
			bulletX = x + 25;
			bulletY = y + 64;
		} else if (direction == Direction.LEFT) {
			bulletX = x - 64;
			bulletY = y + 25;
		} else if (direction == Direction.RIGHT) {
			bulletX = x + 64;
			bulletY = y + 25;
		}
        return new Bullet(bulletX,bulletY, direction, this); //Bullet(x + 25, y + 25, direction, this);
    }

    public void draw(Graphics g) {
        if (!destroyed) {
            g.drawImage(img, getX(), getY(), 63,63, new ImageObserver() {

                @Override
                public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                    return false;
                }
            });

        }
    }

    @Override
    public boolean isDestroyed() {
        return destroyed;
    }

    public void destroy() {
        destroyed = true;
    }

    public void moveToQuadrant(int v, int h) throws Exception {
    }

    public void moveRandom() throws Exception {
    }

    public void clean() throws Exception {
    }

    public void updateX(int x) {
        this.x += x;
    }

    public void updateY(int y) {
        this.y += y;
    }

    public Direction getDirection() {
        return direction;
    }
    // 0 - up, 1 - down, 2 - left, 3 - right
    private int getIndexDirection(){
        int rez = 0;
        if(getDirection() == Direction.DOWN){
            rez = 1;
        }else if (direction == Direction.UP){
            rez = 0;
        }else if (direction == Direction.LEFT){
            rez = 2;
        }else {
            rez = 3;
        }
        return rez;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public int getMovePath() {
        return movePath;
    }

    public BattleField getBf() {
        return bf;
    }


}