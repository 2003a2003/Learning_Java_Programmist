package lesson3.part_5.frame_10.tanks;

import lesson3.part_5.frame_10.utils.*;
import lesson3.part_5.frame_10.battlefield.*;
import lesson3.part_5.frame_10.enums.*;
import lesson3.part_5.frame_10.interfaces.*;


import java.awt.*;
import java.util.Random;

public abstract class AbstractTank implements Drawable, Destroyable {

    protected int speed = 5;
    private Direction direction;
    private int x;
    private int y;

    private ActionField af;
    private BattleField bf;

    protected Color colorTank;
    protected Color colorTower;

    //KONSRTUKTOR
    public AbstractTank(ActionField af, BattleField bf) {
        this(af, bf, 0, 0, Direction.MOVE_DOWN);
    }

    public AbstractTank(ActionField af, BattleField bf, int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.af = af;
        this.bf = bf;
    }

    //METODS
    public void turn(Direction direction) throws Exception {
        this.direction = direction;
        af.processTurn(this);
    }

    public void move() throws Exception {
        af.processMove(this);
    }

    public void fire() throws Exception {
        Bullet bullet = new Bullet(x + 25, y + 25, direction, this);
        af.processFire(bullet);
    }

    public void clean() throws Exception {

        for (int y = 1; y < 10; y++) {
            for (int x = 1; x < 10; x++) {
                moveToQuadrant(y, x);

                if (x == 9 && y < 9) {
                    moveToQuadrant(y + 1, x);
                    y++;
                }
                x++;
            }
        }
    }

    public void moveRandom() throws Exception {

        Random r = new Random();
        int i;
        Direction d;
        while (true) {
            i = r.nextInt(5);
            if (i > 0) {
                if (i == 1) {
                    d = Direction.MOVE_UP;
                } else if (i == 2) {
                    d = Direction.MOVE_DOWN;
                } else if (i == 3) {
                    d = Direction.MOVE_LEFT;
                } else {
                    d = Direction.MOVE_RIGHT;
                }

                turn(d);
                fire();
                move();
            }
        }
    }

    public void moveToQuadrant(int v, int h) throws Exception {
        String koordXY = af.getQuadrantXY(v, h);

        int moveToX = Integer.parseInt(koordXY.substring(koordXY.indexOf("_") + 1));
        int moveToY = Integer.parseInt(koordXY.substring(0, koordXY.indexOf("_")));


        if (x < moveToX) {
            while (x != moveToX) {
                turn(Direction.MOVE_RIGHT);
                af.checkQuadrant(direction);
                move();
            }
        } else {
            while (x != moveToX) {
                turn(Direction.MOVE_LEFT);
                af.checkQuadrant(direction);
                move();
            }
        }
        if (y < moveToY) {
            while (y != moveToY) {
                turn(Direction.MOVE_DOWN);
                af.checkQuadrant(direction);
                move();
            }
        } else {
            while (y != moveToY) {
                turn(Direction.MOVE_UP);
                af.checkQuadrant(direction);
                move();
            }
        }
    }

    @Override
    public void destroy() {
        x = -100;
        y = -100;
        af.repaint();
    }

    @Override
    public void draw(Graphics g) {

        g.setColor(colorTank);
        g.fillRect(this.x, this.y, 64, 64);

        g.setColor(colorTower);

        if (this.getDirection() == Direction.MOVE_UP) {
            g.fillRect(this.getX() + 20, this.getY(), 24, 34);
        } else if (this.getDirection() == Direction.MOVE_DOWN) {
            g.fillRect(this.getX() + 20, this.getY() + 30, 24, 34);
        } else if (this.getDirection() == Direction.MOVE_LEFT) {
            g.fillRect(this.getX(), this.getY() + 20, 34, 24);
        } else {
            g.fillRect(this.getX() + 30, this.getY() + 20, 34, 24);
        }
    }

    //get - set
    public int getSpeed() {
        return speed;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public void updateX(int x) {
        this.x += x;
    }

    public int getY() {
        return y;
    }

    public void updateY(int y) {
        this.y += y;
    }

    private void setX(int x) {
        this.x = x;
    }

    private void setY(int y) {
        this.y = y;
    }
}