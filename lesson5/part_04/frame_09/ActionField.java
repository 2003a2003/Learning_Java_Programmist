package lesson5.part_04.frame_09;

import lesson5.part_04.frame_09.bf.*;
import lesson5.part_04.frame_09.bf.tanks.Action;
import lesson5.part_04.frame_09.bf.tanks.*;

import javax.swing.*;
import java.awt.*;

public class ActionField extends JPanel {

    private boolean COLORDED_MODE = false;

    private BattleField battleField;
    private Tank defender;
    private BT7 aggressor;
    private Bullet bullet;

    /**
     * Write your code here.
     */
    void runTheGame() throws Exception {

        aggressor.scanMap();
        while (true) {
            if (!aggressor.isDestroyed() && !defender.isDestroyed()) {
            //if (!aggressor.isDestroyed()) {
                processAction(aggressor.setUp(), aggressor);
            }
//			if (!aggressor.isDestroyed() && !defender.isDestroyed()) {
//				processAction(defender.setUp(), defender);
//			}
        }
    }

    private void processAction(Action a, Tank t) throws Exception {
        if (a == Action.MOVE) {
            processMove(t);
        } else if (a == Action.FIRE) {
            processTurn(t);
            processFire(t.fire());
        }
    }

    private void processTurn(Tank tank) throws Exception {
        repaint();
    }

    private void processMove(Tank tank) throws Exception {
        processTurn(tank);
        Direction direction = tank.getDirection();
        int step = 1;

        for (int i = 0; i < tank.getMovePath(); i++) {
            int covered = 0;

            String tankQuadrant = getQuadrant(tank.getX(), tank.getY());
            int v = Integer.parseInt(tankQuadrant.split("_")[0]);
            int h = Integer.parseInt(tankQuadrant.split("_")[1]);

            // check limits x: 0, 513; y: 0, 513
            if ((direction == Direction.UP && tank.getY() == 0) || (direction == Direction.DOWN && tank.getY() >= 512)
                    || (direction == Direction.LEFT && tank.getX() == 0) || (direction == Direction.RIGHT && tank.getX() >= 512)) {
                System.out.println("[illegal move] direction: " + direction
                        + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
                return;
            }

            // check next quadrant before move
            if (direction == Direction.UP) {
                v--;
            } else if (direction == Direction.DOWN) {
                v++;
            } else if (direction == Direction.RIGHT) {
                h++;
            } else if (direction == Direction.LEFT) {
                h--;
            }

            BFObject bfobject = battleField.scanQuadrant(v, h);

//			if (!(bfobject instanceof Blank) && !bfobject.isDestroyed()) {
//				System.out.println("[illegal move] direction: " + direction
//						+ " tankX: " + tank.getX() + ", tankY: " + tank.getY());
//				return;
//			}

            if (!(bfobject instanceof Blank) && !bfobject.isDestroyed() ) {
				System.out.println("[illegal move] direction: " + direction
						+ " tankX: " + tank.getX() + ", tankY: " + tank.getY());
                return;
            }

            // process move
            while (covered < 64) {
                if (direction == Direction.UP) {
                    tank.updateY(-step);
                    //				System.out.println("[move up] direction: " + direction + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
                } else if (direction == Direction.DOWN) {
                    tank.updateY(step);
                    //				System.out.println("[move down] direction: " + direction + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
                } else if (direction == Direction.LEFT) {
                    tank.updateX(-step);
                    //				System.out.println("[move left] direction: " + direction + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
                } else {
                    tank.updateX(step);
                    //				System.out.println("[move right] direction: " + direction + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
                }
                covered += step;

                repaint();
                Thread.sleep(tank.getSpeed());
            }
        }
    }

    private void processFire(Bullet bullet) throws Exception {
        this.bullet = bullet;
        int step = 1;
        while ((bullet.getX() > -14 && bullet.getX() < 590)
                && (bullet.getY() > -14 && bullet.getY() < 590)) {
            if (bullet.getDirection() == Direction.UP) {
                bullet.updateY(-step);
            } else if (bullet.getDirection() == Direction.DOWN) {
                bullet.updateY(step);
            } else if (bullet.getDirection() == Direction.LEFT) {
                bullet.updateX(-step);
            } else {
                bullet.updateX(step);
            }
            if (processInterception()) {
                bullet.destroy();
            }

            repaint();
            Thread.sleep(bullet.getSpeed());
            if (bullet.isDestroyed()) {
                break;
            }
        }
    }

    private boolean processInterception() {
        String coordinates = getQuadrant(bullet.getX(), bullet.getY());
        int y = Integer.parseInt(coordinates.split("_")[0]);
        int x = Integer.parseInt(coordinates.split("_")[1]);

        if (y >= 0 && y < 9 && x >= 0 && x < 9) {
            BFObject bfObject = battleField.scanQuadrant(y, x);
//			if (!bfObject.isDestroyed() && !(bfObject instanceof Blank)) {
//				battleField.destroyObject(y, x);
//				return true;
//			}

            if (!bfObject.isDestroyed()) {
                if (bfObject instanceof Brick || bfObject instanceof Eagle) {
                    battleField.destroyObject(y, x);
                } else if (bfObject instanceof Rock && bullet.getTank() instanceof Tiger) {
                    battleField.destroyObject(y, x);
                }else if(bfObject instanceof Blank || bfObject instanceof Water){
                    return false;
                }
                return true;
            }

            // check aggressor
            if (!aggressor.isDestroyed() && checkInterception(getQuadrant(aggressor.getX(), aggressor.getY()),
                    coordinates) && !bullet.getTank().equals(aggressor)) {
                aggressor.destroy();
                return true;
            }

            // check aggressor
            if (!defender.isDestroyed() && checkInterception(getQuadrant(defender.getX(), defender.getY()), coordinates)) {
                defender.destroy();
                return true;
            }
        }
        return false;
    }

    private boolean checkInterception(String object, String quadrant) {
        int oy = Integer.parseInt(object.split("_")[0]);
        int ox = Integer.parseInt(object.split("_")[1]);

        int qy = Integer.parseInt(quadrant.split("_")[0]);
        int qx = Integer.parseInt(quadrant.split("_")[1]);

        if (oy >= 0 && oy < 9 && ox >= 0 && ox < 9) {
            if (oy == qy && ox == qx) {
                return true;
            }
        }
        return false;
    }

    public String getQuadrant(int x, int y) {
        // input data should be correct
        return y / 64 + "_" + x / 64;
    }

    private void createAgressor() {
        int x = 0;
        int y = 0;

        while (true) {
            String location = battleField.getAggressorLocation();
            y = Integer.parseInt(location.split("_")[1]);
            x = Integer.parseInt(location.split("_")[0]);
            if (battleField.scanQuadrant(y / 64, x / 64) instanceof Blank) {
                break;
            }
        }

        aggressor = new BT7(battleField, x, y, Direction.DOWN);
    }

    public ActionField() throws Exception {
        battleField = new BattleField();
        defender = new T34(battleField);
        createAgressor();
//		String location = battleField.getAggressorLocation();
//		aggressor = new BT7(battleField,
//			Integer.parseInt(location.split("_")[1]), Integer.parseInt(location.split("_")[0]), Direction.RIGHT);

//        bullet = new Bullet(-100, -100, Direction.NONE);

        JFrame frame = new JFrame("BATTLE FIELD");
        frame.setLocation(350, 150);
        frame.setMinimumSize(new Dimension(battleField.getBfWidth() + 16, battleField.getBfHeight() + 38));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        battleField.draw(g);
        defender.draw(g);
        aggressor.draw(g);
        bullet.draw(g);
    }
}