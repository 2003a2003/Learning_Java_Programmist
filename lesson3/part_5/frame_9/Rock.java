package lesson3.part_5.frame_9;

import java.awt.*;

public class Rock extends AbstractObjectBattleField implements Drawable{

    public Rock(int x, int y, BattleField bf) {
        super(x, y, bf);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(new Color(132, 127, 152));
        g.fillRect(getX(), getY(), 64, 64);
    }
}
