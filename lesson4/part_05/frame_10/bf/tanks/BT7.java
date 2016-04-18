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
        movePath = 2;
    }

    public BT7(BattleField bf, int x, int y, Direction direction) {
        super(bf, x, y, direction);
        tankColor = new Color(255, 0, 0);
        towerColor = new Color(0, 255, 0);
        movePath = 2;
    }


    public void scanMap() {

//        Direction direction = getDirection();
//        Direction lastDirection;
//
//        int x = getX() / 64;
//        int y = getY() / 64;
//
//        if (direction != Direction.DOWN) {
//            lastDirection = Direction.DOWN;
//            list.add(Direction.DOWN);
//        }
//
//        while (y != 8) {
//            // check next quadrant before move
//            System.out.println(list.size());
//            if (x < 5) {
//                if (y < 8) {
//                    if (direction == Direction.UP) {
//                        y--;
//                    } else if (direction == Direction.DOWN) {
//                        y++;
//                    } else if (direction == Direction.RIGHT) {
//                        x++;
//                    } else if (direction == Direction.LEFT) {
//                        x--;
//                    }
//
//                    BFObject bfobject = getBf().scanQuadrant(y, x);
//
//                    if (bfobject instanceof Water && bfobject instanceof Rock) {
//                        lastDirection = direction;
//                        if (direction == Direction.DOWN) {
//                            direction = Direction.LEFT;
//                        } else if (direction == Direction.LEFT) {
//                            direction = Direction.RIGHT;
//                        } else if (direction == Direction.RIGHT) {
//                            direction = Direction.UP;
//                        } else if (direction == Direction.UP) {
//                            direction = Direction.DOWN;
//                        }
//
//                        System.out.println("STOP NOT MOVE");
//                    } else if (bfobject instanceof Blank) {
//                        list.add(Action.MOVE);
//                    } else {
//                        list.add(Action.FIRE);
//                        list.add(Action.MOVE);
//                    }
//                }
//            }
//        }

    actoins=new Object[] {
                Direction.DOWN,
                Action.FIRE,
                Action.MOVE,
    };
}


    private boolean checkQuadrant(int x, int y) {

        if (x >= 0 && x < 9 && y >= 0 && y < 9) {
            return true;
        }
        return false;
    }

    @Override
    public Action setUp() {
        if (step >= actoins.length) {
            step = 0;
        }
        if (!(actoins[step] instanceof Action)) {
            turn((Direction) actoins[step++]);
        }
        if (step >= actoins.length) {
            step = 0;
        }
        return (Action) actoins[step++];
    }
}
