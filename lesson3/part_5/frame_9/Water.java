package lesson3.part_5.frame_9;

import java.awt.*;

public class Water extends AbstractObjectBattleField implements Drawable{

    public Water(int x, int y, BattleField bf) {
       super(x,y,bf);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(new Color(105, 154, 235));
        g.fillRect(getX(),getY(), 64,64);
    }
}
