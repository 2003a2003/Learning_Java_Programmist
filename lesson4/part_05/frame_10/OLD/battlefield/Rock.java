package lesson4.part_05.frame_10.OLD.battlefield;

import lesson4.part_05.frame_10.OLD.interfaces.Destroyable;

import java.awt.*;

public class Rock extends SomeObjectOfBattleField implements Destroyable {

    public Rock(int x, int y, BattleField bf) {
        super(x, y, bf,new Color(132, 127, 152));
    }

    @Override
    public void destroy() {
        getBf().updateQuadrant(getY()/64,getX()/64,new Empty(getX(),getY(), getBf()));
    }
}
