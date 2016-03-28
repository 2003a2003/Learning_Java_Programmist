package lesson3.part_5.frame_10.battlefield;

import lesson3.part_5.frame_10.interfaces.Destroyable;

import java.awt.*;

public class Rock extends SomeObjectOfBattleField implements Destroyable {

    public Rock(int x, int y, BattleField bf) {
        super(x, y, bf,new Color(132, 127, 152));
    }

    @Override
    public void destroy() {
        getBf().updateQuadrant(getY(),getX()," ");
//        setX(-800);
//        setY(-800);
    }
}
