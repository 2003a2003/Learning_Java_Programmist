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
import java.io.PrintStream;

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
    private PrintStream console;
    private File logFile;
    private WorkWithLogFile workWithLogFile;

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
                        workWithLogFile.updateLogFile(logFile, "Eagle Destroy!!!\n");
                        readLogFileToConsole();
                        createGameOverPanel();
                    }

                    if (!bt7.isDestroyed()) {
                        processAction(bt7.setUp(), bt7);
                    }
                }
            }
        } else if (startLogick == 2) {
            tiger.attackDefender(t34);
            while (j) {
//                tiger.attackDefender(t34);
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
                    workWithLogFile.updateLogFile(logFile, "Defender was destroy!!!\n");
                    readLogFileToConsole();
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

                workWithLogFile.updateLogFile(logFile, "[illegal move] direction: " + direction
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

                workWithLogFile.updateLogFile(logFile, "[illegal move] direction: " + direction
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
//                    System.out.println("[move up] direction: " + direction + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
                    workWithLogFile.updateLogFile(logFile, ("[move up] direction: " + direction +
                            " tankX: " + tank.getX() + ", tankY: " + tank.getY()));
                } else if (direction == Direction.DOWN) {
                    tank.updateY(step);
//                    System.out.println("[move down] direction: " + direction + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
                    workWithLogFile.updateLogFile(logFile, ("[move down] direction: " + direction +
                            " tankX: " + tank.getX() + ", tankY: " + tank.getY()));
                } else if (direction == Direction.LEFT) {
                    tank.updateX(-step);
//                    System.out.println("[move left] direction: " + direction + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
                    workWithLogFile.updateLogFile(logFile, ("[move left] direction: " + direction +
                            " tankX: " + tank.getX() + ", tankY: " + tank.getY()));
                } else {
                    tank.updateX(step);
//                    System.out.println("[move right] direction: " + direction + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
                    workWithLogFile.updateLogFile(logFile, ("[move right] direction: " + direction +
                            " tankX: " + tank.getX() + ", tankY: " + tank.getY()));
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

        bt7 = new BT7(battleField, x, y, Direction.DOWN, logFile);
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

        tiger = new Tiger(battleField, x, y, Direction.DOWN, logFile);
    }

    public ActionField() throws Exception {
        workWithLogFile = new WorkWithLogFile();
        workWithLogFile.createLogFile();
        logFile = workWithLogFile.getLogFile();

        battleField = new BattleField();
//        t34 = new T34(battleField);
//        createBT7();
//        createTiger();
//		  String location = battleField.getAggressorLocation();
//		  aggressor = new BT7(battleField,
//			Integer.parseInt(location.split("_")[1]), Integer.parseInt(location.split("_")[0]), Direction.RIGHT);
//        bullet = new Bullet(-100, -100, Direction.DOWN, bt7);
        createStartPanel();
//        JFrame frame = new JFrame("BATTLE FIELD");
//        frame = new JFrame("BATTLE FIELD");
//        frame.setLocation(350, 150);
//        frame.setMinimumSize(new Dimension(battleField.getBfWidth() + 16, battleField.getBfHeight() + 38));
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//        frame.getContentPane().add(this);
//        frame.pack();
//        frame.setVisible(true);
    }

    private void createStartPanel() throws Exception {
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

        createGamePanel();
    }

    private void createGamePanel() throws Exception {

        //if(battleField.scanQuadrant(8,4) instanceof Blank){
        battleField = new BattleField();
        //}

        t34 = new T34(battleField, logFile);

        createBT7();
        createTiger();

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

        createStartPanel();
    }

//    public ActionField(JPanel panel) throws Exception {
//        battleField = new BattleField();
//        t34 = new T34(battleField);
//        bullet = new Bullet(-100, -100, Direction.DOWN, bt7);
//        createBT7();
//        createTiger();
//        JFrame frame = new JFrame("BATTLE FIELD");
//        frame = new JFrame("BATTLE FIELD");
//        frame.setLocation(350, 150);
//        frame.setMinimumSize(new Dimension(battleField.getBfWidth() + 16, battleField.getBfHeight() + 38));
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        String location = battleField.getAggressorLocation();
//		  aggressor = new BT7(battleField,
//			Integer.parseInt(location.split("_")[1]), Integer.parseInt(location.split("_")[0]), Direction.RIGHT);
//        frame.getContentPane().add(panel);
//        frame.pack();
//        frame.setVisible(true);
//    }

//    private void createLogFile() throws IOException {
//        String fileName = "action_log.txt";
//        String path = "/src/lesson8/part_05/frame_02/log/";
//
//        logFile = new File(System.getProperty("user.dir") + (path + fileName).replace("/", File.separator));
//        if(!logFile.exists()){
//            logFile.createNewFile();
//        }
//    }
//
//    private void updateLogFile(File file, String data) throws IOException {
//        StringBuilder sb = new StringBuilder();
//        String oldFile = readLogFile(file);
//        sb.append(oldFile);
//        sb.append(data);
//        writeLogFile(file, sb.toString());
//    }
//
//    private void writeLogFile(File file, String data) {
//        try (
//                FileOutputStream fos = new FileOutputStream(file.getAbsolutePath());
//                BufferedOutputStream bos = new BufferedOutputStream(fos, 256)
//        ) {
//            bos.write(data.getBytes());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private String readLogFile(File file) {
//        StringBuilder builder = new StringBuilder();
//        try (
//                FileInputStream fis = new FileInputStream(file.getAbsolutePath());
//                BufferedInputStream bis = new BufferedInputStream(fis, 256);
//        ) {
//            int i;
//            while ((i = bis.read()) != -1) {
//                builder.append((char) i);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return builder.toString();
//    }


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
}