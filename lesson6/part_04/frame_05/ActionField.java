package lesson6.part_04.frame_05;

import lesson6.part_04.frame_05.bf.*;
import lesson6.part_04.frame_05.bf.tanks.Action;
import lesson6.part_04.frame_05.bf.tanks.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionField extends JPanel {

    private boolean COLORDED_MODE = false;

    private BattleField battleField;

    private T34 t34;
    private BT7 bt7;
    private Tiger tiger;
    private Bullet bullet;

    private AggressorLogic al;

    private JFrame f;
    private JPanel jpStart;
    private JPanel jpGame;
    private JPanel jpGameOver;

    private int startLogick = 0;


    /**
     * Write your code here.
     */
    void runTheGame() throws Exception {

        boolean i = true;
        boolean j = true;

        if (startLogick == 1) {
            bt7.attackEagle();

            while (i) {

                if (!bt7.isDestroyed() && !t34.isDestroyed()) {

                    if (battleField.scanQuadrant(8, 4) instanceof Blank) {
                        i = false;
                        System.out.println("Eagle Destroy!!!");

                    }

                    if (!bt7.isDestroyed()) {
                        processAction(bt7.setUp(), bt7);
                    }


                }
            }
        } else if (startLogick == 2) {

            while (j) {
                tiger.attackDefender(t34);
                if (!tiger.isDestroyed() && !t34.isDestroyed()) {

                    if (!tiger.isDestroyed()) {
                        processAction(tiger.setUp(), tiger);
                    }

//                    if (!t34.isDestroyed()) {
//                        processAction(t34.setUp(), t34);
//                    }

                } else {
                    j = false;
                    System.out.println("Defender was destroy!!!");
                }
            }
        }
    }

    private void processAction(lesson6.part_04.frame_05.bf.tanks.Action a, Tank t) throws Exception {
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
        int step = 2;

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

            if (!(bfobject instanceof Blank) && !bfobject.isDestroyed()) {
                System.out.println("[illegal move] direction: " + direction
                        + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
                tank.fire();
                return;
            }

//            if (!(bfobject instanceof Blank) && !bfobject.isDestroyed() && !(bfobject instanceof Water)) {
//                System.out.println("[illegal move] direction: " + direction
//                        + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
//                return;
//            }

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
                    return true;
                } else if (bfObject instanceof Rock && bullet.getTank() instanceof Tiger) {
                    battleField.destroyObject(y, x);
                    return true;
                }
            }

            // check aggressor
            if (!bt7.isDestroyed() && checkInterception(getQuadrant(bt7.getX(), bt7.getY()),
                    coordinates) && !bullet.getTank().equals(bt7)) {
                bt7.destroy();
                return true;
            }

            // check aggressor
            if (!t34.isDestroyed() && checkInterception(getQuadrant(t34.getX(), t34.getY()), coordinates)
                    && !bullet.getTank().equals(t34)) {
                t34.destroy();
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
        return y / 64 + "_" + x / 64;
    }

    private void createBT7() {
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

        bt7 = new BT7(battleField, x, y, Direction.DOWN);
    }

    private void createTiger() {
        int x = 0;
        int y = 0;

        while (true) {
            String location = battleField.getAggressorLocation();
            y = Integer.parseInt(location.split("_")[1]);
            x = Integer.parseInt(location.split("_")[0]);
            if (battleField.scanQuadrant(y / 64, x / 64) instanceof Blank && (bt7.getX() != x)) {
                break;
            }
        }

        tiger = new Tiger(battleField, x, y, Direction.DOWN);
    }

    public ActionField() throws Exception {

        battleField = new BattleField();


        addPanelStartGame();
//		String location = battleField.getAggressorLocation();
//		aggressor = new BT7(battleField,
//			Integer.parseInt(location.split("_")[1]), Integer.parseInt(location.split("_")[0]), Direction.RIGHT);


//        f = new JFrame("BATTLE FIELD");
//        f.setLocation(350, 150);
//        f.setMinimumSize(new Dimension(battleField.getBfWidth() + 16, battleField.getBfHeight() + 38));
//        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//        f.getContentPane().add(addPanelStartGame());
//        f.pack();
//        f.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        battleField.draw(g);
        t34.draw(g);
        bt7.draw(g);
        tiger.draw(g);
        bullet.draw(g);
    }

    private void setPanelDate(JPanel panel) {

        f = new JFrame("BATTLE FIELD");
        f.setLocation(350, 150);
        f.setMinimumSize(new Dimension(battleField.getBfWidth() + 16, battleField.getBfHeight() + 38));
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        f.getContentPane().add(panel);
        f.pack();
        f.setVisible(true);

    }

    private void addPanelStartGame(){
        jpStart = new JPanel();

        jpStart.setLayout(new GridBagLayout());

        ButtonGroup bgSelectTank = new ButtonGroup();

        JButton jbBT7 = new JButton("Agressor: BT7");
        jbBT7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startLogick = 1;
                f.getContentPane().removeAll();
                try {
                    addPanelGame();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

                try {
                    runTheGame();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

            }
        });
        jpStart.add(jbBT7, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START,
                GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

        JButton jbTiger = new JButton("Agressor: TIGER");
        jpStart.add(jbTiger, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.LINE_START,
                GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

        JButton jbT34 = new JButton("Defender: T34");
        jpStart.add(jbTiger, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START,
                GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

        bgSelectTank.add(jbBT7);
        bgSelectTank.add(jbTiger);
        bgSelectTank.add(jbT34);

//        jrbTank.add(jbBT7);
//        jrbTank.add(jbTiger);
//        jrbTank.add(jbT34);

        jpStart.add(jbBT7);
        jpStart.add(jbTiger);
        jpStart.add(jbT34);

        setPanelDate(jpStart);
    }

    private void addPanelGame() throws Exception {
        t34 = new T34(battleField);
        bullet = new Bullet(-100, -100, Direction.DOWN, bt7);

        createBT7();
        createTiger();

        System.out.println("Start logic: " + startLogick);
        ;

        f.getContentPane().removeAll();

        f.getContentPane().add(this);
        f.pack();

        f.setVisible(true);

    }

    private JPanel addPanelGameOver() {
        jpGameOver = new JPanel();
        return jpGameOver;
    }
}