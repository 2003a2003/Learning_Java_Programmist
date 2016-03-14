package lesson2.part_6.frame_10;

public class BT7 extends AbstractTank {

    public BT7 (ActionField af, BattleField bf) {
        super(af, bf);
        speed = speed *2;
    }

    public BT7(ActionField af, BattleField bf, int x, int y, Direction direction) {
        super(af, bf, x, y, direction);
        speed = speed * 2;
    }


}
