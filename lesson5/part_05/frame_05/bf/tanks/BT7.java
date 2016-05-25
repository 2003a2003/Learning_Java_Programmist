package lesson5.part_05.frame_05.bf.tanks;

import lesson5.part_05.frame_05.Direction;
import lesson5.part_05.frame_05.bf.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class BT7 extends AbstractTank {

    private int step;
    private AggressorLogic ai;

    private Object[] actoins = new Object[]{
            Action.FIRE,
            Action.MOVE,
    };

    private ArrayList act;
    private int[][] workArray;
    private final int MAX_ITER = 9 * 9;
    private int countIter;


    public BT7(BattleField bf) {
        super(bf);
        tankColor = new Color(255, 0, 0);
        towerColor = new Color(0, 255, 0);
        movePath = 2;
        setImages();
        act = new ArrayList<Action>();
        workArray = new int[9][9];
        countIter = 0;
        initWorkArray();

    }

    public BT7(BattleField bf, int x, int y, Direction direction) {
        super(bf, x, y, direction);
        tankColor = new Color(255, 0, 0);
        towerColor = new Color(0, 255, 0);
        movePath = 2;
        setImages();
        act = new ArrayList<Action>();
        workArray = new int[9][9];
        countIter = 0;
        initWorkArray();
    }

    private void setImages() {
        images = new Image[4];
        try {
            images[0] = ImageIO.read(new File("bt7_UP.png").getAbsoluteFile());
            images[1] = ImageIO.read(new File("bt7_Down.png").getAbsoluteFile());
            images[2] = ImageIO.read(new File("bt7_Left.png").getAbsoluteFile());
            images[3] = ImageIO.read(new File("bt7_Rigth.png").getAbsoluteFile());

        } catch (IOException e) {
            System.err.println("Can't find image of BT7.");
        }
    }

    @Override
    public Action setUp() {

//        if (step >= actoins.length) {
//            step = 0;
//        }
//        if (!(actoins[step] instanceof Action)) {
//            turn((Direction) actoins[step++]);
//        }
//        if (step >= actoins.length) {
//            step = 0;
//        }
//        return (Action) actoins[step++];

        if (step >= act.size()) {
            //step = 0;
            return Action.NONE;
        }

        if (!(act.get(step) instanceof Action)) {
            turn((Direction) act.get(step++));
        }

        if (step >= act.size()) {
            //step = 0;
            return Action.NONE;
        }

        return (Action) act.get(step++);
    }


    public void attackEagle() {

        if (getBf().scanQuadrant(8, 4).isDestroyed()) {
            System.out.println("GAME OVER!!!!!!!");
        }

        int x = getX() / 64;
        int y = getY() / 64;

        int v = y;
        int h = x;

        int min = 9 * 9;

        if (x == 0) {
            act.add(Action.FIRE);
            act.add(Action.MOVE);
        } else if (x == 4) {
            //second logic
            attakeEagleCenterLine();
        } else {
            act.add(Action.FIRE);
            act.add(Action.MOVE);
        }

    }

    private void attakeEagleCenterLine() {

        int lineReadyToFire = scanCenterLineH();

        if (lineReadyToFire == 0) {
            act.add(Action.FIRE);
            act.add(Action.NONE);
        } else if (lineReadyToFire == 1 || lineReadyToFire == 2) {

            int number = searchNumberAction();
            for (int i = number; i >= 0; i--) {
                act.add(Action.FIRE);
            }
            act.add(Action.NONE);
        } else {
            //next line
        }
    }

    private int searchNumberAction() {
        int x = 4; //Eagle (4,8)
        int rez = 0;
        for (int i = 1; i < 9; i++) {
            if (getBf().scanQuadrant(i, x) instanceof Brick || getBf().scanQuadrant(i, x) instanceof Eagle) {
                rez++;
            }
        }
        return rez;
    }


    public int scanCenterLineH() {
        int rez = 0;
        for (int i = 1; i < 9; i++) {
            if (getBf().scanQuadrant(i, 4) instanceof Brick || getBf().scanQuadrant(i, 4) instanceof Eagle) {
                rez = 1;
            } else if (getBf().scanQuadrant(i, 4) instanceof Rock) {
                rez = -1;
            }
        }
        return rez;
    }

    private void initWorkArray() {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (getBf().scanQuadrant(j, i) instanceof Blank) {
                    workArray[i][j] = 1;
                } else if (getBf().scanQuadrant(j, i) instanceof Water) {
                    workArray[i][j] = 3;
                } else if (getBf().scanQuadrant(j, i) instanceof Brick) {
                    workArray[i][j] = 2;
                } else if (getBf().scanQuadrant(j, i) instanceof Eagle) {
                    workArray[i][j] = 0;
                } else if (getBf().scanQuadrant(j, i) instanceof Rock) {
                    workArray[i][j] = 4;
                }

                if (getX() == 0 || getX() == 64 * 4 || getX() == 512) {
                    workArray[i][j] = 100;
                }
            }
        }

        System.out.println("Init +");


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i == countIter) {

                }

            }
        }


    }
}
