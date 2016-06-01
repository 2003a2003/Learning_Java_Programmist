package lesson1.part_3.frame_2;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ActionField extends JPanel {

    private int step = 1;

    final int MOVE_UP = 1;
    final int MOVE_DOWN = 2;
    final int MOVE_LEFT = 3;
    final int MOVE_RIGHT = 4;

    Tank tank = new Tank();
    BattleField bf = new BattleField();
    Bullet bl = new Bullet();

    String[][] battleField = bf.getBattleField();

    void runTheGame() throws Exception {
////		moveToQuadrant(5, 5);
////		Thread.sleep(500);
////		moveToQuadrant(3, 6);
////		Thread.sleep(500);
////		moveToQuadrant(5, 4);
////		Thread.sleep(500);
////		moveToQuadrant(6, 5);
        clean();
    }

     void clean() throws Exception {
        for (int y = 1; y < 10; y++) {
            for (int x = 1; x < 10;) {
                moveToQuadrant(y, x);
                x++;
                if (x == 9 && y < 9) {
                    moveToQuadrant(y + 1, x);
                    y++;
                }
            }
        }
    }

    private boolean processInterception(int bulletX, int bulletY) {

        String koorditateXY = getQuadrant(bulletX, bulletY);

        int index = koorditateXY.indexOf("_");
        int y = Integer.parseInt(koorditateXY.substring(0, index));
        int x = Integer.parseInt(koorditateXY.substring(index + 1));

        if (y >= 0 && y < 9 && x >= 0 && x < 9) {
            if (!battleField[y][x].equals(" ")) {
                battleField[y][x] = " ";
                return true;
            }
        }
        return false;
    }

    String getQuadrant(int x, int y) {

        return y / bf.getSIZE_ONE_QUADRANT() + "_" + x / bf.getSIZE_ONE_QUADRANT();
    }

    void fire() throws Exception {

        bl.setX(tank.getTankX() + 25);
        bl.setY(tank.getTankY() + 25);
        // -14 sizeButlles

        while (bl.getY() > -14 && bl.getY() < bf.getBF_HEIGHT() && bl.getX() > -14 && bl.getX() < bf.getBF_WIDTH()) {

            if (tank.getTankDirection() == MOVE_UP) {
                bl.updateY(- bl.getButlleStep());
            } else if (tank.getTankDirection() == MOVE_DOWN) {
                bl.updateY(bl.getButlleStep());
            } else if (tank.getTankDirection() == MOVE_LEFT) {
               bl.updateX(- bl.getButlleStep());
            } else if (tank.getTankDirection() == MOVE_RIGHT) {
                bl.updateX(bl.getButlleStep());
            }

            if (processInterception(bl.getX(), bl.getY())) {
                bl.setX(-100);
                bl.setY(-100);
            }

            repaint();
            Thread.sleep(bl.getSpeed());
        }
    }

    String getQuadrantXY(int v, int h) {

        if ((v > 0 && v < 10) && (h > 0 && h < 10)) {
            String resultat = (v - 1) * bf.getSIZE_ONE_QUADRANT() + "_" + (h - 1) * bf.getSIZE_ONE_QUADRANT();
            return resultat;
        }
        return null;
    }

    void move(int direction) throws Exception {

        int step = 1;
        int index = 0;

        if ((direction == MOVE_LEFT && tank.getTankX() == bf.getMIN()) || (direction == MOVE_RIGHT && tank.getTankX() == bf.getMAX())
                || (direction == MOVE_UP && tank.getTankY() == bf.getMIN()) || (direction == MOVE_DOWN && tank.getTankY() == bf.getMAX())) {
            System.out.println("[wrong move]: " + "tankX: " + tank.getTankX() + ", tankY: " + tank.getTankY());
            return;
        }

        tankTurn(direction);
        //checkQuadrant(direction);

        while (index < bf.getSIZE_ONE_QUADRANT()) {
            if (direction == 1) {
                tank.setTankY(tank.getTankY() - step);
                System.out.println("[move up]: " + "tankX: " + tank.getTankX() + ", tankY: " + tank.getTankY());
            } else if (direction == 2) {
                tank.setTankY(tank.getTankY() + step);
                System.out.println("[move up]: " + "tankX: " + tank.getTankX() + ", tankY: " + tank.getTankY());
            } else if (direction == 3) {
                tank.setTankX(tank.getTankX() - step);
                System.out.println("[move up]: " + "tankX: " + tank.getTankX() + ", tankY: " + tank.getTankY());
            } else {
                tank.setTankX(tank.getTankX() + step);
                System.out.println("[move up]: " + "tankX: " + tank.getTankX() + ", tankY: " + tank.getTankY());
            }
            index += step;
            repaint();
            Thread.sleep(tank.getTankSpeed());
        }
    }

    private void checkQuadrant(int direction) throws Exception {

        String koorditateXY = getQuadrant(tank.getTankX(), tank.getTankY());

        int index = koorditateXY.indexOf("_");
        int y = Integer.parseInt(koorditateXY.substring(0, index));
        int x = Integer.parseInt(koorditateXY.substring(index + 1));

        if (direction == MOVE_UP) {
            if (!battleField[y - 1][x].equals(" ")) {
                fire();
            }
        } else if (direction == MOVE_DOWN) {
            if (!battleField[y + 1][x].equals(" ")) {
                fire();
            }
        } else if (direction == MOVE_LEFT) {
            if (!battleField[y][x - 1].equals(" ")) {
                fire();
            }

        } else if (direction == MOVE_RIGHT) {
            if (!battleField[y][x + 1].equals(" ")) {
                fire();
            }
        }

    }

    void tankTurn(int direction) throws InterruptedException {
        if (tank.getTankDirection() != direction) {
            tank.setTankDirection(direction);
            repaint();
        }
    }

    void moveRandom() throws Exception {
        Random r = new Random();
        int i;
        while (true) {
            i = r.nextInt(5);
            if (i > 0) {
                move(i);
            }
        }
    }

    void moveToQuadrant(int v, int h) throws Exception {

        String koordX_Y = getQuadrantXY(v, h);

        int index = koordX_Y.indexOf("_");
        int moveToX = Integer.parseInt(koordX_Y.substring(index + 1));
        int moveToY = Integer.parseInt(koordX_Y.substring(0, index));

        if (tank.getTankX() < moveToX) {
            while (tank.getTankX() != moveToX) {
                tankTurn(MOVE_RIGHT);
                checkQuadrant(MOVE_RIGHT);
                move(MOVE_RIGHT);
            }
        } else {
            while (tank.getTankX() != moveToX) {
                tankTurn(MOVE_LEFT);
                checkQuadrant(MOVE_LEFT);
                move(MOVE_LEFT);
            }
        }

        if (tank.getTankY() < moveToY) {
            while (tank.getTankY() != moveToY) {
                tankTurn(MOVE_DOWN);
                checkQuadrant(MOVE_DOWN);
                move(MOVE_DOWN);
            }
        } else {
            while (tank.getTankY() != moveToY) {
                tankTurn(MOVE_UP);
                checkQuadrant(MOVE_UP);
                move(MOVE_UP);
            }
        }
    }

    // Magic bellow. Do not worry about this now, you will understand everything
    // in this course.
    // Please concentrate on your tasks only.

    public ActionField() throws Exception {

        BattleField battleField = new BattleField();
        JFrame frame = new JFrame("BATTLE FIELD, DAY 2");
        frame.setLocation(350, 150);
        frame.setMinimumSize(new Dimension(bf.getBF_WIDTH() + 16, bf.getBF_HEIGHT() + 38));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int i = 0;
        Color cc;
        for (int v = 0; v < 9; v++) {
            for (int h = 0; h < 9; h++) {
                if (bf.isCOLORDED_MODE()) {
                    if (i % 2 == 0) {
                        cc = new Color(252, 241, 177);
                    } else {
                        cc = new Color(233, 243, 255);
                    }
                } else {
                    cc = new Color(180, 180, 180);
                }
                i++;
                g.setColor(cc);
                g.fillRect(h * 64, v * 64, 64, 64);
            }
        }

        for (int j = 0; j < battleField.length; j++) {
            for (int k = 0; k < battleField.length; k++) {
                if (battleField[j][k].equals("B")) {
                    String coordinates = getQuadrantXY(j + 1, k + 1);
                    int separator = coordinates.indexOf("_");
                    int y = Integer.parseInt(coordinates.substring(0, separator));
                    int x = Integer.parseInt(coordinates.substring(separator + 1));
                    g.setColor(new Color(0, 0, 255));
                    g.fillRect(x, y, 64, 64);
                }
            }
        }

        g.setColor(new Color(255, 0, 0));
        g.fillRect(tank.getTankX(), tank.getTankY(), 64, 64);

        g.setColor(new Color(0, 255, 0));
        if (tank.getTankDirection() == 1) {
            g.fillRect(tank.getTankX() + 20, tank.getTankY(), 24, 34);
        } else if (tank.getTankDirection() == 2) {
            g.fillRect(tank.getTankX() + 20, tank.getTankY() + 30, 24, 34);
        } else if (tank.getTankDirection() == 3) {
            g.fillRect(tank.getTankX(), tank.getTankY() + 20, 34, 24);
        } else {
            g.fillRect(tank.getTankX() + 30, tank.getTankY() + 20, 34, 24);
        }

        g.setColor(new Color(255, 255, 0));
        g.fillRect(bl.getX(), bl.getY(), 14, 14);
    }
}
