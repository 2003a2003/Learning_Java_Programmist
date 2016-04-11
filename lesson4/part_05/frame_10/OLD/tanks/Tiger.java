package lesson4.part_05.frame_10.OLD.tanks;

import lesson4.part_05.frame_10.OLD.battlefield.BattleField;
import lesson4.part_05.frame_10.OLD.enums.Direction;
import lesson4.part_05.frame_10.OLD.utils.ActionField;

import java.awt.*;

public class Tiger extends AbstractTank {

    private int armor;

    public Tiger(ActionField af, BattleField bf) {
        super(af, bf);
        armor = 1;
        colorTank = new Color(0, 0, 0);
        colorTower = new Color(251, 249, 255);
    }

    public Tiger(ActionField af, BattleField bf, int x, int y, Direction direction) {
        super(af, bf, x, y, direction);
        armor = 1;
        colorTank = new Color(0, 0, 0);
        colorTower = new Color(251, 249, 255);
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