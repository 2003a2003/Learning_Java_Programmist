package lesson1.part_3.frame_10;

import javax.swing.*;
import java.awt.*;

/**
 * Created by otroshenko on 16.02.2016.
 */
public class ActionField extends JPanel {

    private boolean COLORDED_MODE = false;

    final int MOVE_UP = 1;
    final int MOVE_DOWN = 2;
    final int MOVE_LEFT = 3;
    final int MOVE_RIGHT = 4;

    private BattleField bf;
    private Tank tankDef;
    private Bullet bullet;

    public void runTheGame() throws Exception {
        tankDef.turn(4);
        tankDef.fire();
        tankDef.fire();
        tankDef.fire();
        tankDef.move();
        tankDef.turn(2);
        tankDef.fire();
        tankDef.fire();
        tankDef.move();
        tankDef.turn(4);
        tankDef.fire();
        tankDef.fire();
        tankDef.fire();
        tankDef.move();
        tankDef.fire();
        tankDef.fire();
        tankDef.fire();
        tankDef.fire();
        tankDef.fire();
    }

    private boolean processInterception() {
        String coorditateXY = getQuadrant(bullet.getX(), bullet.getY());
        int index = coorditateXY.indexOf("_");
        int y = Integer.parseInt(coorditateXY.substring(0, index));
        int x = Integer.parseInt(coorditateXY.substring(index + 1));

        if (y >= 0 && y < 9 && x >= 0 && x < 9) {
            if (!bf.scanQuadrant(y, x).equals(" ")) {
                bf.updateQuadrant(y, x, " ");
                return true;
            }
        }
        return false;
    }

    public String getQuadrant(int x, int y) {
        return y / bf.getSIZE_ONE_QUADRANT() + "_" + x / bf.getSIZE_ONE_QUADRANT();
    }

    public String getQuadrantXY(int v, int h) {

        if ((v > 0 && v < 10) && (h > 0 && h < 10)) {
            String resultat = (v - 1) * bf.getSIZE_ONE_QUADRANT() + "_" + (h - 1) * bf.getSIZE_ONE_QUADRANT();
            return resultat;
        }
        return null;
    }

    public void processMove(Tank tankDef) throws Exception {

        this.tankDef = tankDef;

        int step = 1;
        int index = 0;

        if ((tankDef.getDirection() == MOVE_LEFT && tankDef.getX() == bf.getMIN_QUADRANT_COORDINATE())
                || (tankDef.getDirection() == MOVE_RIGHT && tankDef.getX() == bf.getMAX_QUADRANT_COORDINATE())
                || (tankDef.getDirection() == MOVE_UP && tankDef.getY() == bf.getMIN_QUADRANT_COORDINATE())
                || (tankDef.getDirection() == MOVE_DOWN && tankDef.getY() == bf.getMAX_QUADRANT_COORDINATE())) {
            System.out.println("[wrong move]: " + "tankX: " + tankDef.getX() + ", tankY: " + tankDef.getY());
            return;
        }

        tankDef.turn(tankDef.getDirection());

        while (index < bf.getSIZE_ONE_QUADRANT()) {
            if (tankDef.getDirection() == MOVE_UP) {
                tankDef.updateY(-step);
            } else if (tankDef.getDirection() == MOVE_DOWN) {
                tankDef.updateY(step);
            } else if (tankDef.getDirection() == MOVE_LEFT) {
                tankDef.updateX(-step);
            } else {
                tankDef.updateX(step);
            }

            index += step;
            repaint();
            Thread.sleep(tankDef.getSpeed());
        }
    }

    public void processTurn(Tank tankDef) throws Exception{
//        if (this.tankDef.getDirection() != tankDef.getDirection()) {
//            this.tankDef.turn(tankDef.getDirection());
            repaint();
//        }
    }

    public void processFire(Bullet bull) throws Exception {
        this.bullet = bull;

        while (bullet.getX() > -bullet.getSIZE_BULLET() && bullet.getX() < bf.getBF_WIDTH()
                && bullet.getY() > -bullet.getSIZE_BULLET() && bullet.getY() < bf.getBF_HEIGHT()) {

            if (tankDef.getDirection() == MOVE_UP) {
                bullet.updateY(-bullet.getButlleStep());
            } else if (tankDef.getDirection() == MOVE_DOWN) {
                bullet.updateY(bullet.getButlleStep());
            } else if (tankDef.getDirection() == MOVE_LEFT) {
                bullet.updateX(-bullet.getButlleStep());
            } else {
                bullet.updateX(bullet.getButlleStep());
            }

            if (processInterception()) {
                bullet.destroy();
            }
            repaint();
            Thread.sleep(bullet.getSpeed());
        }
    }


    public ActionField() throws Exception {

        bf = new BattleField();
        tankDef = new Tank(this, bf, 0, 0, 2);
        bullet = new Bullet();

        JFrame frame = new JFrame("BATTLE FIELD");
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

        for (int j = 0; j < bf.getBattleField().length; j++) {
            for (int k = 0; k < bf.getBattleField().length; k++) {
                if (bf.scanQuadrant(j, k).equals("B")) {
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
        g.fillRect(tankDef.getX(), tankDef.getY(), 64, 64);

        g.setColor(new Color(0, 255, 0));
        if (tankDef.getDirection() == 1) {
            g.fillRect(tankDef.getX() + 20, tankDef.getY(), 24, 34);
        } else if (tankDef.getDirection() == 2) {
            g.fillRect(tankDef.getX() + 20, tankDef.getY() + 30, 24, 34);
        } else if (tankDef.getDirection() == 3) {
            g.fillRect(tankDef.getX(), tankDef.getY() + 20, 34, 24);
        } else {
            g.fillRect(tankDef.getX() + 30, tankDef.getY() + 20, 34, 24);
        }

        g.setColor(new Color(255, 255, 0));
        g.fillRect(bullet.getX(), bullet.getY(), 14, 14);
    }

}
