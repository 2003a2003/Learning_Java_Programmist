package lesson4.part_05.frame_10.OLD.utils;

import lesson4.part_05.frame_10.OLD.battlefield.*;
import lesson4.part_05.frame_10.OLD.enums.Direction;
import lesson4.part_05.frame_10.OLD.tanks.AbstractTank;
import lesson4.part_05.frame_10.OLD.tanks.T34;
import lesson4.part_05.frame_10.OLD.tanks.Tiger;

import javax.swing.*;
import java.awt.*;

public class ActionField extends JPanel {

    private boolean COLORDED_MODE = false;

    private BattleField bf;
    private AbstractTank defender;
    private Bullet bullet;
    private AbstractTank agressor;

    public void runTheGame() throws Exception {

        defender.turn(Direction.MOVE_UP);
        agressor.turn(Direction.MOVE_DOWN);
        agressor.fire();
        //agressor.fire();
        defender.fire();
        defender.fire();
        defender.fire();
        agressor.fire();
        agressor.fire();
        agressor.fire();
    }

    private boolean processInterception() throws Exception {
        String coorditateXY = getQuadrant(bullet.getX(), bullet.getY());
        int index = coorditateXY.indexOf("_");
        int y = Integer.parseInt(coorditateXY.substring(0, index));
        int x = Integer.parseInt(coorditateXY.substring(index + 1));

        if (y >= 0 && y < 9 && x >= 0 && x < 9) {
            if (bf.scanQuadrant(y, x) instanceof Brick) {
                Brick b = (Brick) bf.scanQuadrant(y, x);
                b.destroy();
                return true;
            } else if ( bf.scanQuadrant(y, x) instanceof Eagle) {
                Eagle e = (Eagle) bf.scanQuadrant(y, x);
                e.destroy();
                return true;
            }else if((bf.scanQuadrant(y, x) instanceof Rock && bullet.getTank() instanceof Tiger)){
                Rock r = (Rock) bf.scanQuadrant(y,x);
                r.destroy();
                return true;
            } else if (bf.scanQuadrant(y, x) instanceof Rock && bullet.getTank() instanceof T34) {
                return true;
            }
        }

        if (checkInterception(getQuadrant(agressor.getX(), agressor.getY()), coorditateXY) &&
                !bullet.getTank().equals(agressor)) {
            agressor.destroy();
            return true;
        }

        if (getQuadrant(defender.getX(), defender.getY()).equals(coorditateXY) && bullet.getTank() != defender) {
            defender.destroy();
            return true;
        }

        return false;
    }

    private boolean checkInterception(String object, String quadrant) {
        int oy = Integer.parseInt(object.split("_")[0]);
        int ox = Integer.parseInt((object.split("_")[1]));

        int qy = Integer.parseInt(quadrant.split("_")[0]);
        int qx = Integer.parseInt(quadrant.split("_")[1]);

        if (oy >= 0 && oy < 9 && ox >= 0 && ox < 9) {
            if (oy == qy && ox == qx) {
                return true;
            }
        }
        return false;
    }

    private void addAgressor() throws Exception {
        Thread.sleep(3000);
        createAgressor();
        repaint();
    }

    public String getQuadrant(int x, int y) {
        return y / bf.getSIZE_ONE_QUADRANT() + "_" + x / bf.getSIZE_ONE_QUADRANT();
    }

    public int getQuadrantX(int x) {
        return x / bf.getSIZE_ONE_QUADRANT();
    }

    public int getQuadrantY(int y) {
        return y / bf.getSIZE_ONE_QUADRANT();
    }

    public String getQuadrantXY(int v, int h) {

        if ((v > 0 && v < 10) && (h > 0 && h < 10)) {
            String resultat = (v - 1) * bf.getSIZE_ONE_QUADRANT() + "_" + (h - 1) * bf.getSIZE_ONE_QUADRANT();
            return resultat;
        }
        return null;
    }

    public void processMove(AbstractTank tank) throws Exception {

        if (tank instanceof T34) {
            this.defender = tank;
        } else {
            this.agressor = tank;
        }

        int step = 1;
        int index = 0;

        if ((tank.getDirection() == Direction.MOVE_LEFT && tank.getX() == bf.getMIN_QUADRANT_COORDINATE())
                || (tank.getDirection() == Direction.MOVE_RIGHT && tank.getX() == bf.getMAX_QUADRANT_COORDINATE())
                || (tank.getDirection() == Direction.MOVE_UP && tank.getY() == bf.getMIN_QUADRANT_COORDINATE())
                || (tank.getDirection() == Direction.MOVE_DOWN && tank.getY() == bf.getMAX_QUADRANT_COORDINATE())) {
            System.out.println("[wrong move]: " + "tankX: " + tank.getX() + ", tankY: " + tank.getY());
            return;
        }

        if (tank instanceof T34) {
            defender.turn(defender.getDirection());
        } else {
            agressor.turn(agressor.getDirection());
        }
        //tank.turn(tank.getDirection());

        while (index < bf.getSIZE_ONE_QUADRANT()) {
            if (tank.getDirection() == Direction.MOVE_UP) {
                tank.updateY(-step);
            } else if (tank.getDirection() == Direction.MOVE_DOWN) {
                tank.updateY(step);
            } else if (tank.getDirection() == Direction.MOVE_LEFT) {
                tank.updateX(-step);
            } else {
                tank.updateX(step);
            }

            index += step;
            repaint();
            Thread.sleep(tank.getSpeed());
        }
    }

    public void processTurn(AbstractTank tankDef) throws Exception {
        repaint();
    }

    public void processFire(Bullet bull) throws Exception {
        this.bullet = bull;

        while (bullet.getX() > -bullet.getSIZE_BULLET() && bullet.getX() < bf.getBF_WIDTH() + bullet.getSIZE_BULLET()
                && bullet.getY() > -bullet.getSIZE_BULLET() && bullet.getY() < bf.getBF_HEIGHT() + bullet.getSIZE_BULLET()) {

            if (bullet.getDirection() == Direction.MOVE_UP) {
                bullet.updateY(-bullet.getButlleStep());
            } else if (bullet.getDirection() == Direction.MOVE_DOWN) {
                bullet.updateY(bullet.getButlleStep());
            } else if (bullet.getDirection() == Direction.MOVE_LEFT) {
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

    public void checkQuadrant(Direction direction) throws Exception {

        String koordXY = getQuadrant(defender.getX(), defender.getY());

        int moveToX = Integer.parseInt(koordXY.substring(koordXY.indexOf("_") + 1));
        int moveToY = Integer.parseInt(koordXY.substring(0, koordXY.indexOf("_")));

        SomeObjectOfBattleField[][] battleField = bf.getBattleField();

        if (direction == Direction.MOVE_UP) {
            if (!battleField[moveToY - 1][moveToX].equals(" ")) {
                defender.fire();
            }
        } else if (direction == Direction.MOVE_DOWN) {
            if (!battleField[moveToY + 1][moveToX].equals(" ")) {
                defender.fire();
            }
        } else if (direction == Direction.MOVE_LEFT) {
            if (!battleField[moveToY][moveToX - 1].equals(" ")) {
                defender.fire();
            }
        } else if (direction == Direction.MOVE_RIGHT) {
            if (!battleField[moveToY][moveToX + 1].equals(" ")) {
                defender.fire();
            }
        }
    }

    private void createAgressor() {
        int x = 0;
        int y = 0;

        while (true) {
            x = bf.getCoordinatesAgressorX();
            y = bf.getCoordinatesAgressorY();
            if (bf.scanQuadrant(getQuadrantY(y), getQuadrantX(x)).equals(" ")) {
                break;
            }
        }

        agressor = new Tiger(this, bf, x, y, Direction.MOVE_DOWN);
    }

    public ActionField() throws Exception {

        bf = new BattleField();
        defender = new T34(this, bf, 256, 448, Direction.MOVE_DOWN);
        agressor = new Tiger(this, bf, 256, 0, Direction.MOVE_DOWN);
//        createAgressor();
//        agressor = new Tank(this,bf,Integer.parseInt(bf.getAgressorLocation().split("_")[1]),
//                Integer.parseInt(bf.getAgressorLocation().split("_")[0]),Direction.MOVE_DOWN);

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

        bf.printComponent(g, this);

        defender.draw(g);

        agressor.draw(g);

        bullet.draw(g);
    }
}