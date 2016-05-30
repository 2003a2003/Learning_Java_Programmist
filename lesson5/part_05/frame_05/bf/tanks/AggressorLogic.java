package lesson5.part_05.frame_05.bf.tanks;

import lesson5.part_05.frame_05.Direction;
import lesson5.part_05.frame_05.bf.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class AggressorLogic {

    private BattleField bf;
    private AbstractTank at;

    private int sX;
    private int sY;

    private int eX;
    private int eY;

    private int countIter;
    private int maxCountIter;

    private int mapWidth;
    private int mapHeight;

    private int[][] workArray;
    private int[][] workDirs;

    private int maxIteration = 30;

    private int freeCell = 100;
    private int destroyCell = 111;
    private int startPoint = 909;
    private int stopPoint = 0;
    private ArrayList<Object> part;


    public AggressorLogic() {
    }

    public void startDestroyEagle() {
        mapWidth = bf.getBfWidth() / bf.getSIZE_ONE_QUADRANT();
        mapHeight = bf.getBfHeight() / bf.getSIZE_ONE_QUADRANT();
        part = new ArrayList<>();
        workArray = new int[mapHeight][mapWidth];

        initWorkArray();
        initPath();

    }

    private void initWorkArray() {

        initNumberArray();
//        printArray(workArray);
        boolean printArray = initWave();

//        if (printArray) {
//            printArray(workArray);
//        }
    }

    private void initNumberArray() {
        int rez = 0;

        for (int v = 0; v < mapHeight; v++) {
            for (int h = 0; h < mapWidth; h++) {
                if (h == sX && v == sY) {
                    rez = startPoint;
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

    private void printArray(int[][] array) {
        System.out.println("*******************************************************");
        for (int[] a : array) {
            System.out.println(Arrays.toString(a));
        }
        System.out.println("*******************************************************");
    }

    private boolean initWave() {
        countIter = 0;
        maxCountIter = 50;
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
        } while (workArray[getsY()][getsX()] != countIter && countIter < maxCountIter);

        return printArray;
    }

    private void initPath() {
        int h = getsX();
        int v = getsY();
        Direction dir = at.getDirection();

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
                        if (bf.scanQuadrant(v, h) instanceof Brick || bf.scanQuadrant(v, h) instanceof Eagle) {
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
                        if (bf.scanQuadrant(v, h) instanceof Brick || bf.scanQuadrant(v, h) instanceof Eagle) {
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
                        if (bf.scanQuadrant(v, h) instanceof Brick || bf.scanQuadrant(v, h) instanceof Eagle) {
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
                        if (bf.scanQuadrant(v, h) instanceof Brick || bf.scanQuadrant(v, h) instanceof Eagle) {
                            part.add(Action.FIRE);
                        }
                    }
                    part.add(Action.MOVE);
                } else {
                    System.out.println("*******************************************************");
                    System.out.println("STOP GAME, THERE IS NO WAY!!!!!!!!!");
                    System.out.println("*******************************************************");
                }
            }
            System.out.println("Part is good");
        } else {
            System.out.println("*******************************************************");
            System.out.println("STOP GAME, THERE IS NO WAY!!!!!!!!!");
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

        if (number == freeCell || number == destroyCell || number == startPoint) {
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
}

