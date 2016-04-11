package lesson4.part_05.frame_10.bf.tanks;

import lesson4.part_05.frame_10.bf.BattleField;
import lesson4.part_05.frame_10.Direction;

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

        if ((getX() >= 0 && getX() <= 512) && (getY() >= 0 && getY() <= 512)) {
            if (getDirection() == Direction.DOWN) {
                if (getY() != 512) {
                    actoins = new Object[]{
                            Action.FIRE,
                            Action.MOVE,
                    };
                } else if (getX() == 0) {
                    actoins = new Object[]{
                            Direction.RIGHT,
                            Action.FIRE,
                    };
                } else if (getX() == 512) {
                    actoins = new Object[]{
                            Direction.LEFT,
                            Action.FIRE,
                    };
                }

            } else if (getDirection() == Direction.UP) {
                if (getY() != 0) {
                    actoins = new Object[]{
                            Action.FIRE,
                            Action.MOVE,
                    };
                } else if (getX() == 0) {
                    actoins = new Object[]{
                            Direction.LEFT,
                    };
                }
            } else if (getDirection() == Direction.RIGHT) {

                if (getX() != 512) {
                    actoins = new Object[]{
                            Action.FIRE,
                            Action.MOVE,
                    };
                } else if (getY() == 512) {
                    actoins = new Object[]{
                            Direction.UP,
                            Action.FIRE,
                    };
                }

            } else if (getDirection() == Direction.LEFT) {

                if (getX() != 0) {
                    actoins = new Object[]{
                            Action.FIRE,
                            Action.MOVE,
                    };
                } else if (getX() == 0 && getY() == 512) {
                    actoins = new Object[]{
                            Direction.UP,
                            Action.FIRE,
                    };
                }

            }
        }
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
