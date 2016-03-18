package lesson2.part_5.frame_1;

import java.util.Random;

public class Tank {

    private final int speed = 5;
    private int direction;
    private int x;
    private int y;

    private ActionField af;
    private BattleField bf;

    //KONSRTUKTOR
    public Tank(ActionField af, BattleField bf) {
        this(af, bf, 0, 0, 2);
    }

    public Tank(ActionField af, BattleField bf, int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.af = af;
        this.bf = bf;
    }

    //METODS
    public void turn(int direction) throws Exception {
        this.direction = direction;
        af.processTurn(this);
    }

    public void move() throws Exception {
        af.processMove(this);
    }

    public void fire() throws Exception {
        Bullet bullet = new Bullet(x + 25, y + 25, direction);
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
        while (true) {
            i = r.nextInt(5);
            if (i > 0) {
                turn(i);
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
                turn(af.MOVE_RIGHT);
                af.checkQuadrant(direction);
                move();
            }
        } else {
            while (x != moveToX) {
                turn(af.MOVE_LEFT);
                af.checkQuadrant(direction);
                move();
            }
        }
        if (y < moveToY) {
            while (y != moveToY) {
                turn(af.MOVE_DOWN);
                af.checkQuadrant(direction);
                move();
            }
        } else {
            while (y != moveToY) {
                turn(af.MOVE_UP);
                af.checkQuadrant(direction);
                move();
            }
        }
    }

    public void destroy(){
        updateX(-600);
        updateY(-600);
        af.repaint();
    }

    //get - set
    public int getSpeed() {
        return speed;
    }

    public int getDirection() {
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
}