package lesson3.part_4.frame_6;

import java.awt.*;

public class T34 extends AbstractTank {

    public T34(ActionField af, BattleField bf) {
        super(af, bf);
        colorTank = new Color(255, 0, 0);
        colorTower = new Color(0, 255, 0);
    }

    public T34(ActionField af, BattleField bf, int x, int y, Direction direction) {
        super(af, bf, x, y, direction);
        colorTank = new Color(255, 0, 0);
        colorTower = new Color(0, 255, 0);
    }
}
