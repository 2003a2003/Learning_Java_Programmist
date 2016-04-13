package lesson4.part_05.frame_10.bf.tanks;

import lesson4.part_05.frame_10.bf.*;
import lesson4.part_05.frame_10.Direction;
import test.Direct;

import java.awt.*;

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


    public void destoryEagle() {

//        int x = getX() / 64;
//        int y = getY() / 64;
//
//        if (getDirection() == Direction.DOWN && checkQuadrant(x, y + 1)) {
//            if (getBf().scanQuadrant(y + 1, x) instanceof Destroyable) {
//                if (!(getBf().scanQuadrant(y + 1, x) instanceof Rock)) {
//                    actoins = new Object[]{
//                            Action.FIRE,
//                            Action.MOVE,
//                    };
//                } else {
//                    actoins = new Object[]{
//                            Direction.LEFT,
//                    };
//                }
//            }else {
//                actoins = new Object[]{
//                        Direction.LEFT,
//                };
//            }
//        }
        if (getX() == 0) {
            actoins = new Object[]{
                    Action.FIRE,
                    Action.FIRE,
                    Action.FIRE,

                    Action.MOVE,
                    Action.MOVE,
                    Action.MOVE,
                    Direction.RIGHT,

                    Action.FIRE,
                    Action.FIRE,
                    Action.MOVE,
                    Action.MOVE,
                    Action.MOVE,

                    Direction.DOWN,
            };

        } else if (getX() == 256){
            actoins = new Object[]{
                    Direction.DOWN,
                    Action.FIRE,
                    Action.FIRE,
                    Action.FIRE,
                    Action.FIRE,
                    Action.NONE,
            };

        }else if(getX() == 512){
            actoins = new Object[]{
                    Action.FIRE,
                    Action.FIRE,
                    Action.FIRE,
                    Action.FIRE,
                    Action.NONE,
            };
        }
    }


    private boolean checkQuadrant(int x, int y) {

        if (x >= 0 && x <= 512 && y >= 0 && y <= 512) {
            return true;
        }
        return false;
    }

    @Override
    public Action setUp() {
        destoryEagle();
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
