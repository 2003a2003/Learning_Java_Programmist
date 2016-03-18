package lesson3.part_4.frame_2;

public class Tiger extends AbstractTank {

    private int armor;

    public Tiger(ActionField af, BattleField bf) {
        super(af, bf);
        armor = 1;
    }

    public Tiger(ActionField af, BattleField bf, int x, int y, Direction direction) {
        super(af, bf, x, y, direction);
        armor = 1;
    }

    public int getArmor() {
        return armor;
    }

    public void updateArmor(int armor) {
        this.armor += armor;
    }

    @Override
    public void destroy() {
        if (armor > 0) {
            updateArmor(-1);
        } else {
            super.destroy();
        }
    }
}
