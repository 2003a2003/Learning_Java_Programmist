package lesson4.part_05.frame_10.OLD.tanks;

import lesson4.part_05.frame_10.OLD.battlefield.BattleField;
import lesson4.part_05.frame_10.OLD.enums.Direction;
import lesson4.part_05.frame_10.OLD.utils.ActionField;

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
