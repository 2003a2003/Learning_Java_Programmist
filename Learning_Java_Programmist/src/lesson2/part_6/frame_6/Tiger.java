package Learning_Java_Programmist.src.lesson2.part_6.frame_6;

public class Tiger extends Tank {

    private int armor;

    public Tiger (ActionField af, BattleField bf){
        super(af,bf);
        armor = 1;
    }

    public Tiger(ActionField af, BattleField bf, int x, int y, Direction direction) {
        super(af, bf, x, y, direction);
        armor = 1;
    }

    public int getArmor() {
        return armor;
    }
}
