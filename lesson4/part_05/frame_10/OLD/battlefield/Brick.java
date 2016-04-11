package lesson4.part_05.frame_10.OLD.battlefield;

import lesson4.part_05.frame_10.OLD.interfaces.Destroyable;

import java.awt.*;

public class Brick extends SomeObjectOfBattleField implements Destroyable {

    public Brick(int x, int y, BattleField bf) {
        super(x, y, bf, new Color(255, 3, 9));
    }

    @Override
    public void destroy() {
        getBf().updateQuadrant(getY()/64,getX()/64, new Empty(getX(),getY(),getBf()));
    }
}
