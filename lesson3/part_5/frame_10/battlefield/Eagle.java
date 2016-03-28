package lesson3.part_5.frame_10.battlefield;

import lesson3.part_5.frame_10.interfaces.Destroyable;

import java.awt.*;

public class Eagle extends SomeObjectOfBattleField implements Destroyable {

    public Eagle(int x, int y, BattleField bf) {
        super(x, y, bf,new Color(255, 251, 51));
    }

    @Override
    public void destroy() {
        getBf().updateQuadrant(getY(),getX()," ");
    }
}
