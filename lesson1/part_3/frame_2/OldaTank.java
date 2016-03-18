package lesson1.part_3.frame_2;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * @version 3.0
 */
public class OldaTank extends JPanel {

    final boolean COLORDED_MODE = false;

    final int BF_WIDTH = 576;
    final int BF_HEIGHT = 576;
    final int SIZE_ONE_QUADRANT = 64;

    final int MIN = 0;
    final int MAX = 512;

    final int MOVE_UP = 1;
    final int MOVE_DOWN = 2;
    final int MOVE_LEFT = 3;
    final int MOVE_RIGHT = 4;

    // 1 - top, 2 - bottom, 3 - left, 4 - right
    int tankDirection = MOVE_UP;

    int tankX = 0;
    int tankY = 0;
    int tankSpeed = 7;

    int bulletX = -100;
    int bulletY = -100;
    int bulletSpeed = 20;
    int butlleStep = 5;

    String[][] battleField = {
            { " ", "B", "B", "B", "B", "B", "B", "B", "B" },
            { "B", "B", "B", "B", "B", "B", "B", "B", "B" },
            { "B", "B", "B", "B", "B", "B", "B", "B", "B" },
            { "B", "B", "B", " ", "B", "B", "B", "B", "B" },
            { "B", "B", "B", "B", "B", "B", "B", "B", "B" },
            { "B", "B", "B", "B", "B", "B", "B", "B", "B" },
            { "B", "B", "B", "B", "B", "B", "B", "B", "B" },
            { "B", "B", "B", "B", "B", "B", "B", "B", "B" },
            { "B", "B", "B", "B", "B", "B", "B", "B", "B" } };

    /**
     * Write your code here.
     */
    void runTheGame() throws Exception {

//		moveToQuadrant(5, 5);
//		Thread.sleep(500);
//		moveToQuadrant(3, 6);
//		Thread.sleep(500);
//		moveToQuadrant(5, 4);
//		Thread.sleep(500);
//		moveToQuadrant(6, 5);
        tankDirection = MOVE_DOWN;
        while(true) {
            fire();
        }
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

    boolean processInterception(int bulletX, int bulletY) {

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
        return y / SIZE_ONE_QUADRANT + "_" + x / SIZE_ONE_QUADRANT;
    }

    void fire() throws Exception {

        bulletX = tankX + 25;
        bulletY = tankY + 25;
        // -14 sizeButlles
        while (bulletY > -14 && bulletY < BF_HEIGHT && bulletX > -14 && bulletX < BF_WIDTH) {

            if (tankDirection == MOVE_UP) {
                bulletY -= butlleStep;
            } else if (tankDirection == MOVE_DOWN) {
                bulletY += butlleStep;
            } else if (tankDirection == MOVE_LEFT) {
                bulletX -= butlleStep;
            } else if (tankDirection == MOVE_RIGHT) {
                bulletX += butlleStep;
            }

            if (processInterception(bulletX, bulletY)) {
                bulletX = -100;
                bulletY = -100;
            }

            repaint();
            Thread.sleep(bulletSpeed);
        }
    }

    String getQuadrantXY(int v, int h) {

        if ((v > 0 && v < 10) && (h > 0 && h < 10)) {
            String resultat = (v - 1) * SIZE_ONE_QUADRANT + "_" + (h - 1) * SIZE_ONE_QUADRANT;
            return resultat;
        }
        return null;
    }

    void move(int direction) throws Exception {

        int step = 1;
        int index = 0;

        if ((direction == MOVE_LEFT && tankX == MIN) || (direction == MOVE_RIGHT && tankX == MAX)
                || (direction == MOVE_UP && tankY == MIN) || (direction == MOVE_DOWN && tankY == MAX)) {
            System.out.println("[wrong move]: " + "tankX: " + tankX + ", tankY: " + tankY);
            return;
        }

        tankTurn(direction);
        //checkQuadrant(direction);

        while (index < SIZE_ONE_QUADRANT) {
            if (direction == 1) {
                tankY -= step;
                System.out.println("[move up]: " + "tankX: " + tankX + ", tankY: " + tankY);
            } else if (direction == 2) {
                tankY += step;
                System.out.println("[move down]: " + "tankX: " + tankX + ", tankY: " + tankY);
            } else if (direction == 3) {
                tankX -= step;
                System.out.println("[move left]: " + "tankX: " + tankX + ", tankY: " + tankY);
            } else {
                tankX += step;
                System.out.println("[move right]:" + "tankX: " + tankX + ", tankY: " + tankY);
            }
            index += step;
            repaint();
            Thread.sleep(tankSpeed);
        }
    }

    private void checkQuadrant(int direction) throws Exception {

        String koorditateXY = getQuadrant(tankX, tankY);

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
        if (tankDirection != direction) {
            tankDirection = direction;
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

        if (tankX < moveToX) {
            while (tankX != moveToX) {
                tankTurn(MOVE_RIGHT);
                checkQuadrant(MOVE_RIGHT);
                move(MOVE_RIGHT);
            }
        } else {
            while (tankX != moveToX) {
                tankTurn(MOVE_LEFT);
                checkQuadrant(MOVE_LEFT);
                move(MOVE_LEFT);
            }
        }

        if (tankY < moveToY) {
            while (tankY != moveToY) {
                tankTurn(MOVE_DOWN);
                checkQuadrant(MOVE_DOWN);
                move(MOVE_DOWN);
            }
        } else {
            while (tankY != moveToY) {
                tankTurn(MOVE_UP);
                checkQuadrant(MOVE_UP);
                move(MOVE_UP);
            }
        }
    }

    // Magic bellow. Do not worry about this now, you will understand everything
    // in this course.
    // Please concentrate on your tasks only.

    public static void main(String[] args) throws Exception {
        OldaTank bf = new OldaTank();
        bf.runTheGame();
    }


    public OldaTank() throws Exception {
        JFrame frame = new JFrame("BATTLE FIELD, DAY 2");
        frame.setLocation(350, 150);
        frame.setMinimumSize(new Dimension(BF_WIDTH + 50, BF_HEIGHT + 38));
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
                if (COLORDED_MODE) {
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
        g.fillRect(tankX, tankY, 64, 64);

        g.setColor(new Color(0, 255, 0));
        if (tankDirection == 1) {
            g.fillRect(tankX + 20, tankY, 24, 34);
        } else if (tankDirection == 2) {
            g.fillRect(tankX + 20, tankY + 30, 24, 34);
        } else if (tankDirection == 3) {
            g.fillRect(tankX, tankY + 20, 34, 24);
        } else {
            g.fillRect(tankX + 30, tankY + 20, 34, 24);
        }

        g.setColor(new Color(255, 255, 0));
        g.fillRect(bulletX, bulletY, 14, 14);
    }
}