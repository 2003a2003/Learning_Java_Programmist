package lesson3.part_5.frame_10.tanks;

import lesson3.part_5.frame_10.utils.ActionField;
import lesson3.part_5.frame_10.battlefield.BattleField;
import lesson3.part_5.frame_10.enums.Direction;

import java.awt.*;

public class BT7 extends AbstractTank {

    public BT7 (ActionField af, BattleField bf) {
        super(af, bf);
        speed = speed *2;
        colorTank = new Color(55, 52, 255);
        colorTower = new Color(255, 43, 60);
    }

    public BT7(ActionField af, BattleField bf, int x, int y, Direction direction) {
        super(af, bf, x, y, direction);
        speed = speed * 2;
        colorTank = new Color(55, 52, 255);
        colorTower = new Color(255, 43, 60);
    }
}
