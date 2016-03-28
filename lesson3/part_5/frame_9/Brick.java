package lesson3.part_5.frame_9;

import java.awt.*;

public class Brick extends SomeObjectOfBattleField implements Destroyable {

    public Brick(int x, int y, BattleField bf) {
        super(x, y, bf, new Color(255, 3, 9));
    }

    @Override
    public void destroy() {
        getBf().updateQuadrant(getY(), getX(), " ");
    }
}
