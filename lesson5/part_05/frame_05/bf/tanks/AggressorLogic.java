package lesson5.part_05.frame_05.bf.tanks;

import lesson5.part_05.frame_05.Direction;
import lesson5.part_05.frame_05.bf.*;
import lesson5.part_05.frame_05.bf.tanks.*;

import java.util.ArrayList;
import java.util.List;

public class AggressorLogic {

    //private List<String> novigator = ArrayList(9*9);
    private BattleField bf;
    private AbstractTank at;

    //Start and finish coordinates
    private int xs;
    private int ys;

    private int xe = 4;
    private int ye = 8;

    List<Object> actions;


    public AggressorLogic(BattleField bf, AbstractTank at) {
        this.bf = bf;
        this.at = at;
        xs = at.getX() / 64;
        ys = at.getY() / 64;
        actions = new ArrayList<>();
    }

    public int scanCenterLineH() {
        int rez = 0;

        int xCetnerStart = xe;
        int yCenterStart = 0;

        int v = yCenterStart;
        int h = xCetnerStart;

        if (!(bf.scanQuadrant(v, h) instanceof Water) && !(bf.scanQuadrant(v, h) instanceof Rock)) {
            for (int i = 1; i < 8; i++) {
                if (bf.scanQuadrant(i, h) instanceof Water) {
                    rez = 2;
                } else if (bf.scanQuadrant(i, h) instanceof Rock) {
                    rez = -1;
                } else if (bf.scanQuadrant(i, h) instanceof Brick) {
                    rez = 1;
                }
            }
        }

        return rez;
    }

    public int scanH() {
        int x = xs;
        int y = ys;

        int rez = 0;

        if (x == 0) {
            for (x++; x < 4; x++) {
                if (bf.scanQuadrant(y, x) instanceof Water) {
                    rez = 2;
                } else if (bf.scanQuadrant(y, x) instanceof Rock) {
                    return -1;
                }else if(bf.scanQuadrant(y, x) instanceof Brick){
                    rez = 1;
                }
            }

        } else if (x == 512) {
            for (x--; x > 4; x--) {
                if (bf.scanQuadrant(y, x) instanceof Water) {
                    rez = 1;
                } else if (bf.scanQuadrant(y, x) instanceof Rock) {
                    return -1;
                }else if(bf.scanQuadrant(y, x) instanceof Brick){
                    rez = 1;
                }
            }
        }
        return rez;
    }

    public List<Object> startDestroyEagle() {

        int x = xs;
        int y = ys;

        int iterV = 0;
        int iterH = 0;

        int rezScanCenterLine = scanCenterLineH();
        int rezScanH = scanH();

        if (rezScanCenterLine == 0 || rezScanCenterLine == 1) {

            iterV = getIter();

            if (rezScanH == 0 || rezScanH == 1) {
                iterH = getIter();
            }
        }


        return actions;
    }

    private void getActions(int x, int y, int iter) {

        if (x == 0) {
            actions.add(Direction.RIGHT);
            for (int i = 1 + at.getMovePath(); i < 5; i++) {
                actions.add(Action.MOVE);
            }

            actions.add(Direction.DOWN);
        } else if (x == 8) {
            actions.add(Direction.LEFT);
            for (int i = 1 + at.getMovePath(); i < 5; i++) {
                actions.add(Action.MOVE);
            }
            actions.add(Direction.DOWN);
        }

        for (; iter > 0; iter--){
            actions.add(Action.FIRE);
        }

    }


    public int getIter() {
        int rez = 0;
        for (int i = 1; i < 9; i++) {
            if (bf.scanQuadrant(i, 4) instanceof Brick || bf.scanQuadrant(i, 4) instanceof Eagle) {
                rez ++;
            }
        }
        return rez;
    }
}
