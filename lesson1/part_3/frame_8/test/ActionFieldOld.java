/*
package lesson1.part_3.frame_8.test;

import lesson1.part_3.frame_8.BattleField;
import lesson1.part_3.frame_8.Bullet;
import lesson1.part_3.frame_8.Tank;

import javax.swing.*;
import java.awt.*;

*/
/**
 * Created by otroshenko on 15.02.2016.
 *//*

public class ActionFiedOld extends JPanel{

    private boolean COLORDED_MODE = false;

    final int MOVE_UP = 1;
    final int MOVE_DOWN = 2;
    final int MOVE_LEFT = 3;
    final int MOVE_RIGHT = 4;

    private BattleField bf;
    private Tank tankDef;
    private Bullet bullet;

    public void runTheGame() throws Exception {

        tankDef.setTankDirection(2);
		//while (true){
            processFire(bullet);
        //}
//		Thread.sleep(500);
//		moveToQuadrant(3, 6);
//		Thread.sleep(500);
//		moveToQuadrant(5, 4);
//		Thread.sleep(500);
//		moveToQuadrant(6, 5);

    }

    boolean processInterception() {
        String coorditateXY = getQuadrant(bullet.getX(), bullet.getY());
        int index = coorditateXY.indexOf("_");
        int y = Integer.parseInt(coorditateXY.substring(0, index));
        int x = Integer.parseInt(coorditateXY.substring(index + 1));

        if (y >= 0 && y < 9 && x >= 0 && x < 9) {
            if (!bf.scanQuadrant(y,x).equals(" ")) {
                bf.updateQuadrant(y,x, " "); //getBattleField()[y][x] = " ";
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
        int step = 1;
        int index = 0;

        if ((tankDef.getTankDirection() == MOVE_LEFT && tankDef.getTankX() == bf.getMIN_QUADRANT_COORDINATE())
                || (tankDef.getTankDirection() == MOVE_RIGHT && tankDef.getTankX() == bf.getMIN_QUADRANT_COORDINATE())
                || (tankDef.getTankDirection() == MOVE_UP && tankDef.getTankY() == bf.getMIN_QUADRANT_COORDINATE())
                || (tankDef.getTankDirection() == MOVE_DOWN && tankDef.getTankY() == bf.getMIN_QUADRANT_COORDINATE())) {
            System.out.println("[wrong move]: " + "tankX: " + tankDef.getTankX() + ", tankY: " + tankDef.getTankY());
            return;
        }

        processTurn(tankDef);

        while (index < bf.getSIZE_ONE_QUADRANT()) {
            if (tankDef.getTankDirection() == MOVE_UP) {
                tankDef.setTankY(tankDef.getTankY() - step);
                System.out.println("[move up]: " + "tankX: " + tankDef.getTankX() + ", tankY: " + tankDef.getTankY());
            } else if (tankDef.getTankDirection() == MOVE_DOWN) {
                tankDef.setTankY(tankDef.getTankY() + step);
                System.out.println("[move down]: " + "tankX: " + tankDef.getTankX() + ", tankY: " + tankDef.getTankY());
            } else if (tankDef.getTankDirection() == MOVE_LEFT) {
                tankDef.setTankX(tankDef.getTankX() - step);
                System.out.println("[move left]: " + "tankX: " + tankDef.getTankX() + ", tankY: " + tankDef.getTankY());
            } else {
                tankDef.setTankX(tankDef.getTankX() + step);
                System.out.println("[move right]:" + "tankX: " + tankDef.getTankX() + ", tankY: " + tankDef.getTankY());
            }
            index += step;
            repaint();
            Thread.sleep(tankDef.getTankSpeed());
        }

    }

    public void processTurn(Tank tankDef){
        tankDef.setTankDirection(tankDef.getTankDirection());
    }

   public void processFire(Bullet bullet) throws Exception{

        int bulletX = tankDef.getTankX() + 25;
        int bulletY = tankDef.getTankY() + 25;

        int bulletStep = 1;

        while (bulletY > -14 && bulletY< bf.getBF_HEIGHT()
                && bulletX > -14 && bulletX < bf.getBF_WIDTH()){

            if (tankDef.getTankDirection() == MOVE_UP){
                bulletY -= bulletStep;
                this.bullet.updateY(-bulletStep);
            }else if (tankDef.getTankDirection() == MOVE_DOWN){
                bulletY += bulletStep;
                this.bullet.updateY(bulletStep);
            }else if (tankDef.getTankDirection() == MOVE_LEFT){
                bulletX -= bulletStep;
                this.bullet.updateX(-bulletStep);
            }else if (tankDef.getTankDirection() == MOVE_RIGHT){
                bulletY += bulletStep;
                this.bullet.updateX(bulletStep);
            }

            if(processInterception()){
                bulletX = -100;
                bulletY = -100;
            }

            repaint();
            Thread.sleep(bullet.getSpeed());
        }
    }

    public ActionFiedOld() throws Exception {

        bf = new BattleField();
        tankDef = new Tank(0,0,1);
        bullet = new Bullet(tankDef.getTankX()+25, tankDef.getTankY()+25, tankDef.getTankDirection());

        JFrame frame = new JFrame("BATTLE FIELD");
        frame.setLocation(350, 150);
        frame.setMinimumSize(new Dimension(bf.getBF_WIDTH() + 16, bf.getBF_HEIGHT() + 38));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g){
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

        //String[][] battleField = bf.getBattleField();

        for (int j = 0; j < bf.getBattleField().length; j++) {
            for (int k = 0; k < bf.getBattleField().length; k++) {
                if (bf.getBattleField()[j][k].equals("B")) {
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
        g.fillRect(tankDef.getTankX(), tankDef.getTankY(), 64, 64);

        g.setColor(new Color(0, 255, 0));
        if (tankDef.getTankDirection() == 1) {
            g.fillRect(tankDef.getTankX() + 20, tankDef.getTankY(), 24, 34);
        } else if (tankDef.getTankDirection() == 2) {
            g.fillRect(tankDef.getTankX() + 20, tankDef.getTankY() + 30, 24, 34);
        } else if (tankDef.getTankDirection() == 3) {
            g.fillRect(tankDef.getTankX(), tankDef.getTankY() + 20, 34, 24);
        } else {
            g.fillRect(tankDef.getTankX() + 30, tankDef.getTankY() + 20, 34, 24);
        }

        g.setColor(new Color(255, 255, 0));
        g.fillRect(bullet.getX(), bullet.getY(), 14, 14);
    }
}
*/
