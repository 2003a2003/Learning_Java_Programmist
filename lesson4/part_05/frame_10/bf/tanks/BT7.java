package lesson4.part_05.frame_10.bf.tanks;

import lesson4.part_05.frame_10.Direction;
import lesson4.part_05.frame_10.bf.*;

import java.awt.*;
import java.util.ArrayList;

public class BT7 extends AbstractTank {

//    private Object[] actoins = new Object[]{
//            Action.FIRE,
//            Action.MOVE,
//            Direction.RIGHT,
//            Action.FIRE,
//            Action.MOVE,
//            Direction.LEFT,
//            Action.FIRE,
//            Action.MOVE,
//            Direction.DOWN,
//            Action.FIRE,
//            Action.MOVE,
//            Direction.UP,
//    };

    private Object[] actoins;
    private int step = 0;
    private ArrayList<Object> list = new ArrayList<>();

    public BT7(BattleField bf) {
        super(bf);
        tankColor = new Color(255, 0, 0);
        towerColor = new Color(0, 255, 0);
        movePath = 1;
    }

    public BT7(BattleField bf, int x, int y, Direction direction) {
        super(bf, x, y, direction);
        tankColor = new Color(255, 0, 0);
        towerColor = new Color(0, 255, 0);
        movePath = 1;
    }


    public void scanMap() {
        int xStart = getX() / 64;
        int yStart = getY() / 64;
        if (xStart == 0) {
            if (scanVLine(xStart, yStart) == 0) {
                addVActions(xStart, yStart);
            }
        } else if (xStart == 4) {
            if (scanVLine(xStart, yStart) == 0) {
                addVActions(xStart, yStart);
            }
        } else {
            if (scanVLine(xStart, yStart) == 0) {
                addVActions(yStart,yStart);
            }
        }


    }


    private boolean checkQuadrant(int x, int y) {
        if (x >= 0 && x < 9 && y >= 0 && y < 9) {
            return true;
        }
        return false;
    }

    private int scanVLine(int x, int y) {
        boolean move = true;
        boolean fire = true;

        while (y < 9) {
            BFObject bfObject = getBf().scanQuadrant(y + 1, x);
            if (bfObject instanceof Water) {
                move = false;
                y++;
            } else if (bfObject instanceof Rock) {
                return 3;
            }
            y++;
        }



        if (move == false && fire == true) {
            return 2;
        } else {
            return 0;
        }
    }

    private void addVActions(int x, int y) {

        while (y < 8) {
            BFObject bfObject = getBf().scanQuadrant(y + 1, x);
            if (bfObject instanceof Blank) {
                list.add(Action.MOVE);
            } else {
                list.add(Action.FIRE);
            }
            y++;
        }

        if (y == 8 && (x >= 0 && x < 4)) {
            list.add(Direction.RIGHT);
        } else if (y == 8 && (x > 4 && x <= 8)) {
            list.add(Direction.LEFT);
        }

    }

    private int scanHLine(int x, int y) {

        boolean move = true;
        boolean fire = true;

        if (x >= 0 && x < 4) {
            while (x < 4) {
                BFObject bfObject = getBf().scanQuadrant(y, x + 1);
                if (bfObject instanceof Water) {
                    move = false;
                    x++;
                } else if (bfObject instanceof Rock) {
                    return 3;
                }
            }
        } else if (x > 4 && x <= 8) {
            while (x > 4) {
                BFObject bfObject = getBf().scanQuadrant(y, x - 1);
                if (bfObject instanceof Water) {
                    move = false;
                    x--;
                } else if (bfObject instanceof Rock) {
                    return 3;
                }
            }
        }

        if (move == false && fire == true) {
            return 2;
        } else {
            return 0;
        }
    }

    private int scanCenterLine() {
        int x = 4;
        int y = 1;
        boolean move = true;
        boolean fire = true;

        while (y < 8) {
            BFObject bfObject = getBf().scanQuadrant(y, x);
            if (bfObject instanceof Water) {
                move = false;
                y++;
            } else if (bfObject instanceof Rock) {
                move = false;
                fire = false;
                return 2;
            }
        }

        if (move == false && fire == true) {
            return 1;
        } else {
            return 0;
        }

    }


    @Override
    public Action setUp() {
        if (step >= list.size()) {
            step = 0;
        }

        if (!(list.get(step) instanceof Action)) {
            turn((Direction) list.get(step++));
        }

        if (step >= list.size()) {
            step = 0;
        }

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
        return (Action) list.get(step++);
    }
}
