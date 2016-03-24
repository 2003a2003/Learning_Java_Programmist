package lesson3.part_5.frame_9;

import java.awt.*;

public class Eagle extends AbstractObjectBattleField implements Drawable {

    public Eagle(int x, int y, BattleField bf) {
        super(x, y, bf);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(new Color(255, 251, 51));
        g.fillRect(getX(), getY(), 64, 64);
    }

}
