package lesson4.part_05.frame_10.OLD.tanks;

import lesson4.part_05.frame_10.OLD.battlefield.BattleField;
import lesson4.part_05.frame_10.OLD.enums.Direction;
import lesson4.part_05.frame_10.OLD.utils.ActionField;

import java.awt.*;

public class T34 extends AbstractTank {

    public T34(ActionField af, BattleField bf) {
        super(af, bf);
        colorTank = new Color(68, 52, 178);
        colorTower = new Color(0, 255, 0);
    }

    public T34(ActionField af, BattleField bf, int x, int y, Direction direction) {
        super(af, bf, x, y, direction);
        colorTank = new Color(68, 52, 178);
        colorTower = new Color(0, 255, 0);
    }
}
