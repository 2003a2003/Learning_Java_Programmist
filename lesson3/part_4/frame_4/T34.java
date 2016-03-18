package lesson3.part_4.frame_4;

import java.awt.*;

public class T34 extends AbstractTank  {

    public T34 (ActionField af, BattleField bf) {
        super(af, bf);

    }

    public T34(ActionField af, BattleField bf, int x, int y, Direction direction) {
        super(af, bf, x, y, direction);
    }

    public void drow(Graphics g) {
        g.setColor(new Color(52, 165, 78));
        g.fillRect(this.getX(), this.getY(), 64, 64);

    }

}
