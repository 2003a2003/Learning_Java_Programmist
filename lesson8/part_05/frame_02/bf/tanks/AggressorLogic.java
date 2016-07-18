package lesson8.part_05.frame_02.bf.tanks;

import lesson8.part_05.frame_02.Direction;
import lesson8.part_05.frame_02.bf.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class AggressorLogic {

    private BattleField bf;
    private AbstractTank at;

    private int sX;
    private int sY;

    private int eX = 4;
    private int eY = 8;

    private int dX;
    private int dY;

    private int countIter;
    private int maxCountIter;

    private int mapWidth;
    private int mapHeight;

    private int[][] workArray;

    private int maxIteration = 30;

    private final int freeCell = 100;
    private final int destroyCell = 111;
    private final int markerBT7 = 909;
    private final int markerTiger = 910;
    private final int markerT34 = 911;
    private final int stopPoint = 0;
    private ArrayList<Object> part;
    private T34 t34;

    public AggressorLogic(){
    }

    public void startDestroyEagle() {
        mapWidth = bf.getBfWidth() / bf.getSIZE_ONE_QUADRANT();
        mapHeight = bf.getBfHeight() / bf.getSIZE_ONE_QUADRANT();
        part = new ArrayList<>();
        workArray = new int[mapHeight][mapWidth];

        int v = at.getY() / bf.getSIZE_ONE_QUADRANT();
        int h = at.getX() / bf.getSIZE_ONE_QUADRANT();

        initNumberArrayBT7();
        initWave(v, h);
        initPath(getsY(), getsX(), at.getDirection());
    }

    public void startDestroyDefender() {
        mapWidth = bf.getBfWidth() / bf.getSIZE_ONE_QUADRANT();
        mapHeight = bf.getBfHeight() / bf.getSIZE_ONE_QUADRANT();
        part = new ArrayList<>();

        workArray = new int[mapHeight][mapWidth];

        int v = at.getY() / bf.getSIZE_ONE_QUADRANT();
        int h = at.getX() / bf.getSIZE_ONE_QUADRANT();

        initNumberArrayTiger();
        initWave(v, h);
        initPath(getsY(), getsX(), at.getDirection());
    }

    private void initNumberArrayBT7() {
        int rez = 0;

        for (int v = 0; v < mapHeight; v++) {
            for (int h = 0; h < mapWidth; h++) {
                if (h == sX && v == sY) {
                    rez = markerBT7;
                } else if (h == eX && v == eY) {
                    rez = stopPoint;
                } else {

                    if (bf.scanQuadrant(v, h) instanceof Blank) {
                        rez = freeCell;
                    } else if (bf.scanQuadrant(v, h) instanceof Brick) {
                        rez = destroyCell;
                    } else if (bf.scanQuadrant(v, h) instanceof Water) {
                        rez = 222;
                    } else if (bf.scanQuadrant(v, h) instanceof Rock) {
                        rez = 333;
                    }
                }
                workArray[v][h] = rez;
            }
        }
    }

    private void initNumberArrayTiger() {
        int rez = 0;

        for (int v = 0; v < mapHeight; v++) {
            for (int h = 0; h < mapWidth; h++) {
                if (h == sX && v == sY) {
                    rez = markerTiger;
                } else if (h == dX && v == dY) {
                    rez = stopPoint;
                } else {

                    if (bf.scanQuadrant(v, h) instanceof Blank) {
                        rez = freeCell;
                    } else if (bf.scanQuadrant(v, h) instanceof Brick) {
                        rez = destroyCell;
                    } else if (bf.scanQuadrant(v, h) instanceof Water) {
                        rez = 222;
                    } else if (bf.scanQuadrant(v, h) instanceof Rock) {
                        rez = 333;
                    }
                }
                workArray[v][h] = rez;
            }
        }
    }

    private void printArray(int[][] array) {
        System.out.println("*******************************************************");
        for (int[] a : array) {
            System.out.println(Arrays.toString(a));
        }
        System.out.println("*******************************************************");
    }

    private void initWave(int y, int x) {

        countIter = 0;
        maxCountIter = 100;
        boolean printArray = true;
        do {
            for (int v = 8; v >= 0; v--) {
                for (int h = 0; h < 9; h++) {
                    if (workArray[v][h] == countIter) {
                        if (inMap(v + 1, h) && checkFreeCell(workArray[v + 1][h])) {
                            workArray[v + 1][h] = countIter + 1;
                        }
                        if (inMap(v - 1, h) && checkFreeCell(workArray[v - 1][h])) {
                            workArray[v - 1][h] = countIter + 1;
                        }
                        if (inMap(v, h + 1) && checkFreeCell(workArray[v][h + 1])) {
                            workArray[v][h + 1] = countIter + 1;
                        }
                        if (inMap(v, h - 1) && checkFreeCell(workArray[v][h - 1])) {
                            workArray[v][h - 1] = countIter + 1;
                        }
                    }
                }
            }

            countIter++;
            if (countIter == maxCountIter) {
                printArray = false;
            }

        } while (workArray[y][x] != countIter && countIter < maxCountIter);
        //System.out.println("Counter :" + countIter);
    }

    private void initPath( int y, int x, Direction direction) {
        int h = x;
        int v = y;

        Direction dir = direction;

        if (workArray[v][h] == countIter) {

            int[] index;
            int choice = 0;

            while (workArray[v][h] != 0 && inMap(v, h)) {
                index = new int[4];
                int i = 0;

                if (inMap(v + 1, h) && workArray[v + 1][h] < workArray[v][h]) {
                    index[i] = 2;
                    i++;
                }

                if (inMap(v - 1, h) && workArray[v - 1][h] < workArray[v][h]) {
                    index[i] = 1;
                    i++;
                }

                if (inMap(v, h + 1) && workArray[v][h + 1] < workArray[v][h]) {
                    index[i] = 3;
                    i++;
                }

                if (inMap(v, h - 1) && workArray[v][h - 1] < workArray[v][h]) {
                    index[i] = 4;
                    i++;
                }

                choice = randomPath(index);

                if (choice == 1) {
                    if (dir != Direction.UP) {
                        part.add(Direction.UP);
                        dir = Direction.UP;
                    }
                    if (inMap(v - 1, h)) {
                        v = v - 1;
                        if (bf.scanQuadrant(v, h) instanceof Brick
                                || bf.scanQuadrant(v, h) instanceof Eagle
                                || (v == dY && h == dX)) {
                            part.add(Action.FIRE);
                        }
                    }
                    part.add(Action.MOVE);
                } else if (choice == 2) {
                    if (dir != Direction.DOWN) {
                        part.add(Direction.DOWN);
                        dir = Direction.DOWN;
                    }
                    if (inMap(v + 1, h)) {
                        v = v + 1;
                        if (bf.scanQuadrant(v, h) instanceof Brick || bf.scanQuadrant(v, h) instanceof Eagle
                                || (v == dY && h == dX)) {
                            part.add(Action.FIRE);
                        }
                    }
                    part.add(Action.MOVE);
                } else if (choice == 3) {
                    if (dir != Direction.RIGHT) {
                        part.add(Direction.RIGHT);
                        dir = Direction.RIGHT;
                    }
                    if (inMap(v, h + 1)) {
                        h = h + 1;
                        if (bf.scanQuadrant(v, h) instanceof Brick || bf.scanQuadrant(v, h) instanceof Eagle
                                || (v == dY && h == dX)) {
                            part.add(Action.FIRE);
                            dir = Direction.LEFT;
                        }
                    }
                    part.add(Action.MOVE);
                } else if (choice == 4) {
                    if (dir != Direction.LEFT) {
                        part.add(Direction.LEFT);
                        dir = Direction.LEFT;
                    }
                    if (inMap(v, h - 1)) {
                        h = h - 1;
                        if (bf.scanQuadrant(v, h) instanceof Brick || bf.scanQuadrant(v, h) instanceof Eagle
                                || (v == dY && h == dX)) {
                            part.add(Action.FIRE);
                        }
                    }
                    part.add(Action.MOVE);
                } else {
                    System.out.println("*******************************************************");
                    System.out.println("STOP GAME, THERE IS NO WAY!!!!!!!!!");
                    //workWithLogFile.updateLogFile(at.getLogFile(), "STOP GAME, THERE IS NO WAY!!!!!!!!!\n");
                    System.out.println("*******************************************************");
                }

            }
            //System.out.println("Part is good");
            //workWithLogFile.updateLogFile(at.getLogFile(),"Part is good");
        } else {
            System.out.println("*******************************************************");
            System.out.println("STOP GAME, THERE IS NO WAY!!!!!!!!!");
            //workWithLogFile.updateLogFile(at.getLogFile(),"STOP GAME, THERE IS NO WAY!!!!!!!!!\n");
            System.out.println("*******************************************************");
            return;
        }
    }

    private int randomPath(int[] array) {
        Random r = new Random();
        int index = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                index++;
            }
        }
        int rez = r.nextInt(index);
        return array[rez];
    }

    private boolean checkFreeCell(int number) {
        if (number == freeCell || number == destroyCell
                || number == markerBT7 || number == markerTiger || number == markerT34) {
            return true;
        }
        return false;
    }

    private boolean inMap(int v, int h) {
        if (h >= 0 && h < mapWidth && v >= 0 && v < mapHeight) {
            return true;
        } else {
            return false;
        }
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

    public AbstractTank getAt() {
        return at;
    }

    public void setAt(AbstractTank at) {
        this.at = at;
    }

    public ArrayList<Object> getPart() {
        return part;
    }

    public void setPart(ArrayList<Object> part) {
        this.part = part;
    }

    public int getdX() {
        return dX;
    }

    public void setdX(int dX) {
        this.dX = dX;
    }

    public int getdY() {
        return dY;
    }

    public void setdY(int dY) {
        this.dY = dY;
    }

    public T34 getT34() {
        return t34;
    }

    public void setT34(T34 t34) {
        this.t34 = t34;
    }

}

