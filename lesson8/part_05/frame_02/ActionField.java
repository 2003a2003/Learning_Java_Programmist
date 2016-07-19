package lesson8.part_05.frame_02;

import lesson8.part_05.frame_02.bf.*;
import lesson8.part_05.frame_02.bf.tanks.Action;
import lesson8.part_05.frame_02.bf.tanks.*;
import lesson8.part_05.frame_02.utils.WorkWithLogFile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ActionField extends JPanel {

    private boolean COLORDED_MODE = false;

    private BattleField battleField;
    private JFrame frame;

    private T34 t34;
    private BT7 bt7;
    private Tiger tiger;
    private Bullet bullet;

    private AggressorLogic al;

    private int startLogick = 0;
    private File logFile;
    private WorkWithLogFile workWithLogFile;
    private boolean viewRepeatLastyGame = false;

    /**
     * Write your code here.
     */
    void runTheGame() throws Exception {

        boolean i = true;
        boolean j = true;

        if (!viewRepeatLastyGame) {
            //save to file
            workWithLogFile.addBattleFieldToFileBF(logFile, battleField);
            workWithLogFile.addDataToEndFile(logFile, "T34:" + t34.getX() + "_" + t34.getY());
            workWithLogFile.addDataToEndFile(logFile, "BT7:" + bt7.getX() + "_" + bt7.getY());
            workWithLogFile.addDataToEndFile(logFile, "Tiger:" + tiger.getX() + "_" + tiger.getY());
            if (startLogick == 1) {
                workWithLogFile.addDataToEndFile(logFile, "StartLogick_1");
            } else if (startLogick == 2) {
                workWithLogFile.addDataToEndFile(logFile, "StartLogick_2");
            }
        }

        if (startLogick == 1) {
            bt7.attackEagle(viewRepeatLastyGame);
            if (viewRepeatLastyGame) {
                bt7.setStep(0);
                bt7.setAct(workWithLogFile.returnActionList(logFile, bt7));
                ArrayList<Object> test = bt7.getAct();
                System.out.println(Arrays.toString(test.toArray()));

            }
            while (i) {
                if (!bt7.isDestroyed() && !t34.isDestroyed()) {
                    if (battleField.scanQuadrant(8, 4) instanceof Blank) {
                        i = false;
                        System.out.println("Eagle Destroy!!!");
                        readLogFileToConsole();
                        printActionList();
                        //repeatGame(bt7);
                        createGameOverPanel();
                    }
                    if (!bt7.isDestroyed()) {
                        processAction(bt7.setUp(), bt7);
                    }
                }
            }
        } else if (startLogick == 2) {
            tiger.attackDefender(t34, viewRepeatLastyGame);
            while (j) {
                if (!tiger.isDestroyed() && !t34.isDestroyed()) {
                    if (!tiger.isDestroyed()) {
                        processAction(tiger.setUp(), tiger);
                    }
                    if (!t34.isDestroyed()) {
                        processAction(t34.setUp(), t34);
                    }
                } else {
                    j = false;
                    System.out.println("Defender was destroy!!!");
                    readLogFileToConsole();
                    printActionList();
                    //repeatGame(tiger);
                    createGameOverPanel();
                }
            }
        }
        startLogick = 0;
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
        if (!viewRepeatLastyGame) {
            workWithLogFile.addDataToEndFile(logFile, (tank.getClass().getSimpleName() + "_" + tank.getDirection().toString()));
        }
        repaint();
    }

    private void processMove(Tank tank) throws Exception {
        processTurn(tank);
        Direction direction = tank.getDirection();
        int step = 2;

        if (!viewRepeatLastyGame) {
            workWithLogFile.addDataToEndFile(logFile, (tank.getClass().getSimpleName() + "_" + Action.MOVE.toString()));
        }

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

//                workWithLogFile.updateLogFile(logFile, "[illegal move] direction: " + direction
//                        + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
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

//                workWithLogFile.updateLogFile(logFile, "[illegal move] direction: " + direction
//                        + " tankX: " + tank.getX() + ", tankY: " + tank.getY());

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
//                    System.out.println("[move up] direction: " + direction + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
//                    workWithLogFile.updateLogFile(logFile, ("[move up] direction: " + direction +
//                            " tankX: " + tank.getX() + ", tankY: " + tank.getY()));
                } else if (direction == Direction.DOWN) {
                    tank.updateY(step);
//                    System.out.println("[move down] direction: " + direction + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
//                    workWithLogFile.updateLogFile(logFile, ("[move down] direction: " + direction +
//                            " tankX: " + tank.getX() + ", tankY: " + tank.getY()));
                } else if (direction == Direction.LEFT) {
                    tank.updateX(-step);
//                    System.out.println("[move left] direction: " + direction + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
//                    workWithLogFile.updateLogFile(logFile, ("[move left] direction: " + direction +
//                            " tankX: " + tank.getX() + ", tankY: " + tank.getY()));
                } else {
                    tank.updateX(step);
//                    System.out.println("[move right] direction: " + direction + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
//                    workWithLogFile.updateLogFile(logFile, ("[move right] direction: " + direction +
//                            " tankX: " + tank.getX() + ", tankY: " + tank.getY()));
                }
                covered += step;

                repaint();
                Thread.sleep(tank.getSpeed());
            }
        }
    }

    private void processFire(Bullet bullet) throws Exception {

        if (!viewRepeatLastyGame) {
            workWithLogFile.addDataToEndFile(logFile, (bullet.getTank().getClass().getSimpleName() + "_" + Action.FIRE.toString()));
        }

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

    private void createBT7() throws IOException {
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

    private void createTiger() throws IOException {
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
        createStartPanel();
    }

    private void createStartPanel() throws Exception {
        workWithLogFile = new WorkWithLogFile();
        if (!viewRepeatLastyGame) {
            workWithLogFile.createLogFile();
        }
        logFile = workWithLogFile.getLogFile();

        if (!viewRepeatLastyGame) {
            StartMenuGUI startPanelGUI = new StartMenuGUI(battleField);
            ActionEvent event = startPanelGUI.getEvent();
            while (event == null) {
                Thread.sleep(500);
                event = startPanelGUI.getEvent();
            }

            if (event.getActionCommand().equals("Agressor: BT7")) {
                startLogick = 1;
            } else if (event.getActionCommand().equals("Agressor: TIGER")) {
                startLogick = 2;
            } else if (event.getActionCommand().equals("Defender: T34")) {
                System.out.println("Netu realizatsii poka.............");
                createStartPanel();
            }
        }

        createGamePanel();
    }

    private void createGamePanel() throws Exception {

        battleField = new BattleField();

        int bfHeight = battleField.getBfHeight() / battleField.getSIZE_ONE_QUADRANT();
        int bfWidth = battleField.getBfWidth() / battleField.getSIZE_ONE_QUADRANT();

        if (viewRepeatLastyGame) {

            battleField.setBattleFieldTemplate(workWithLogFile.returnOldBattleField(logFile, bfHeight, bfWidth));
            startLogick = workWithLogFile.getStartLogick(logFile);

            String location = workWithLogFile.getCoordTank(logFile, bt7.getClass().getSimpleName());
            bt7 = new BT7(battleField, Integer.parseInt(location.split("_")[0]),
                    Integer.parseInt(location.split("_")[1]), Direction.DOWN);

//            bt7.setAct(workWithLogFile.returnActionList(logFile, bt7));

            location = workWithLogFile.getCoordTank(logFile, tiger.getClass().getSimpleName());
            tiger = new Tiger(battleField, Integer.parseInt(location.split("_")[0]),
                    Integer.parseInt(location.split("_")[1]), Direction.DOWN);

            tiger.setAct(workWithLogFile.returnActionList(logFile, tiger));

            location = workWithLogFile.getCoordTank(logFile, t34.getClass().getSimpleName());
            t34 = new T34(battleField, Integer.parseInt(location.split("_")[0]),
                    Integer.parseInt(location.split("_")[1]), Direction.UP);

            t34.setAct(workWithLogFile.returnActionList(logFile, t34));
        } else {
            t34 = new T34(battleField);
            createBT7();
            createTiger();
        }

        bullet = new Bullet(-100, -100, Direction.DOWN, bt7);

        frame = new JFrame("BATTLE FIELD");
        frame.setLocation(350, 150);
        frame.setMinimumSize(new Dimension(battleField.getBfWidth() + 16, battleField.getBfHeight() + 38));
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);

        runTheGame();
    }

    private void createGameOverPanel() throws Exception {

        frame.setVisible(false);
        frame.dispose();


        GameOverGUI gameOverGUI = new GameOverGUI(battleField);
        ActionEvent event = gameOverGUI.getEvent();

        while (event == null) {
            Thread.sleep(500);
            event = gameOverGUI.getEvent();
        }

        if (event.getActionCommand().equals("View the last game.")) {
            viewRepeatLastyGame = true;
            createGamePanel();
        } else {
            viewRepeatLastyGame = false;
            createStartPanel();
        }
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

    public int getStartLogick() {
        return startLogick;
    }

    private void readLogFileToConsole() {
        System.out.println(workWithLogFile.readLogFile(logFile));
    }

    private void printActionList() {
        System.out.println("****************************************************************************");
        if (startLogick == 1) {
            System.out.println(Arrays.toString(workWithLogFile.returnActionList(logFile, bt7).toArray()));
        } else if (startLogick == 2) {
            System.out.println(Arrays.toString(workWithLogFile.returnActionList(logFile, tiger).toArray()));
        }
        System.out.println("****************************************************************************");
    }

    private void initGameParametr() {

    }
}