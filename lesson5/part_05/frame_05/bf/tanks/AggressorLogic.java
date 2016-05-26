package lesson5.part_05.frame_05.bf.tanks;

import lesson5.part_05.frame_05.bf.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AggressorLogic {

    private BattleField bf;

    private int[][] workArray;
    private List<Object> actions;

    private int step;

    private int sX;
    private int sY;

    private int eX;
    private int eY;

    private int x;
    private int y;

    private int sizeBfH;
    private int sizeBfV;

    private int countIter;
    private int maxCountIter;


    public AggressorLogic() {
    }

    public void startDestroyEagle() {
        initWorkArray();
        searchMinimalPath();
    }

    private void searchMinimalPath() {
        x = sX;
        y = sY;

        Action[] road = new Action[20];
        Action[] last = new Action[20];
        actions = new ArrayList<>();
        int[] index = new int[4];


        int minActions = 0;

        for (int v = 0; v < bf.getBfWidth() / bf.getSIZE_ONE_QUADRANT(); v++) {
            for (int h = sX; h < bf.getBfWidth() / bf.getSIZE_ONE_QUADRANT(); h++) {
                if (!checkOnBoard(v + 1, h) && !checkLastCounters(workArray[v + 1][h])) { //rename metod checkLastCounter
                    index[1] = workArray[v + 1][h];
                }else {
                    index[1] = -1;
                }

                if (!checkOnBoard(v - 1, h) && checkLastCounters(workArray[v - 1][h])) {
                    index[0] = workArray[v - 1][h];
                }else {
                    index[0] = -1;
                }

                if (!checkOnBoard(v, h + 1) && checkLastCounters(workArray[v][h + 1])) {
                    index[3] = workArray[v][h + 1];
                }else {
                    index[3] = -1;
                }

                if (!checkOnBoard(v, h - 1) && checkLastCounters(workArray[v][h - 1])) {
                    index[2] = workArray[v][h - 1];
                }else {
                    index[2] = -1;
                }

                int rez = findMinValue(index);




            }
        }
    }

    private int findMinValue(int[] index) {


        return -1;
    }

    private void initWorkArray() {
        workArray = new int[9][9];
        sizeBfH = bf.getBfWidth() / bf.getSIZE_ONE_QUADRANT();
        sizeBfV = bf.getBfHeight() / bf.getSIZE_ONE_QUADRANT();

        int rez = 0;

        for (int v = 0; v < sizeBfV; v++) {
            for (int h = 0; h < sizeBfH; h++) {
                if (h == sX && v == sY) {
                    rez = 909;
                } else if (h == eX && v == eY) {
                    rez = 0;
                } else {

                    if (bf.scanQuadrant(v, h) instanceof Blank) {
                        rez = 100;
                    } else if (bf.scanQuadrant(v, h) instanceof Brick) {
                        rez = 111;
                    } else if (bf.scanQuadrant(v, h) instanceof Water) {
                        rez = 222;
                    } else if (bf.scanQuadrant(v, h) instanceof Rock) {
                        rez = 333;
                    }

                }
                workArray[v][h] = rez;
            }
        }
//---------------------------------------------------------------------------------
        for (int[] array : workArray) {
            System.out.println(Arrays.toString(array));
        }
//--------------------------------------------------------------------------------
        countIter = 0;
        maxCountIter = 20;
        int iter = 6;

        step = 0;

        for (int v = 8; v >= 0; v--) {
            while (step < 4) {
                for (int h = 0; h < 9; h++) {
                    if (workArray[v][h] == countIter) {
                        if (!checkOnBoard(v + 1, h) && checkLastCounters(workArray[v + 1][h])) {
                            workArray[v + 1][h] = countIter + 1;
                        }
                        if (!checkOnBoard(v - 1, h) && checkLastCounters(workArray[v - 1][h])) {
                            workArray[v - 1][h] = countIter + 1;
                        }
                        if (!checkOnBoard(v, h + 1) && checkLastCounters(workArray[v][h + 1])) {
                            workArray[v][h + 1] = countIter + 1;
                        }
                        if (!checkOnBoard(v, h - 1) && checkLastCounters(workArray[v][h - 1])) {
                            workArray[v][h - 1] = countIter + 1;
                        }
                    }
                }
                if (countIter < maxCountIter) {
                    countIter++;
                }
                step++;
            }
            step = 0;
            countIter = countIter - 3;
        }

        System.out.println("*******************************************************");
        for (int[] array : workArray) {
            System.out.println(Arrays.toString(array));
        }
        System.out.println("*******************************************************");
    }

    private boolean checkLastCounters(int number) {

        if (number == 100 || number == 111) {
            return true;
        }
        return false;
    }

    private void firsIteration(int v, int h) {

        for (; h < sizeBfH; h++) {
            if (workArray[v][h] == step) {
                if (!checkOnBoard(v - 1, h)) {
                    if (workArray[v - 1][h] != -83 && workArray[v - 1][h] != -84) {
                        workArray[v - 1][h] = step + 1;
                    }
                }
                if (!checkOnBoard(v, h + 1)) {
                    if (workArray[v][h + 1] != -83 && workArray[v][h + 1] != -84) {
                        workArray[v][h + 1] = step + 1;
                    }
                }
                if (!checkOnBoard(v, h - 1)) {
                    if (workArray[v][h - 1] != -83 && workArray[v][h - 1] != -84) {
                        workArray[v][h - 1] = step + 1;
                    }
                }
            }
        }
    }

    private void nexIteration(int v, int h, int lastStep) {

        for (; h < sizeBfH; h++) {
            if (workArray[v][h] == step) {
                if (!checkOnBoard(v - 1, h)) {
                    if (workArray[v - 1][h] != -83 && workArray[v - 1][h] != -84) {
                        workArray[v - 1][h] = step + 1;
                    }
                }
                if (!checkOnBoard(v, h + 1)) {
                    if (workArray[v][h + 1] != -83 && workArray[v][h + 1] != -84) {
                        workArray[v][h + 1] = step + 1;
                    }
                }
                if (!checkOnBoard(v, h - 1)) {
                    if (workArray[v][h - 1] != -83 && workArray[v][h - 1] != -84) {
                        workArray[v][h - 1] = step + 1;
                    }
                }
            }
        }
    }


    private boolean checkOnBoard(int y, int x) {
        if (x >= 0 && x < 9 && y >= 0 && y < 9) {
            return false;
        }
        return true;
    }


    //Getter and Setter

    public int getsX() {
        return sX;
    }

    public void setsX(int sX) {
        this.sX = sX;
    }

    public int getsY() {
        return sY;
    }

    public void setsY(int sY) {
        this.sY = sY;
    }

    public int geteX() {
        return eX;
    }

    public void seteX(int eX) {
        this.eX = eX;
    }

    public int geteY() {
        return eY;
    }

    public void seteY(int eY) {
        this.eY = eY;
    }

    public void setBf(BattleField bf) {
        this.bf = bf;
    }
}

