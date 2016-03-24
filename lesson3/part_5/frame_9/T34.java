package lesson3.part_5.frame_9;

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
