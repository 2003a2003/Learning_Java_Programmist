package lesson5.part_05.frame_05.bf.tanks;

import lesson5.part_05.frame_05.Direction;
import lesson5.part_05.frame_05.bf.BattleField;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BT7 extends AbstractTank {

    private int step;

    private Object[] actoins = new Object[]{
            Action.FIRE,
            Action.MOVE,
            Direction.RIGHT,
            Action.FIRE,
            Action.MOVE,
            Direction.LEFT,
            Action.FIRE,
            Action.MOVE,
            Direction.DOWN,
            Action.FIRE,
            Action.MOVE,
            Direction.UP,
    };

    public BT7(BattleField bf) {
        super(bf);
        tankColor = new Color(255, 0, 0);
        towerColor = new Color(0, 255, 0);
        movePath = 2;
        setImages();
    }

    public BT7(BattleField bf, int x, int y, Direction direction) {
        super(bf, x, y, direction);
        tankColor = new Color(255, 0, 0);
        towerColor = new Color(0, 255, 0);
        movePath = 2;
        setImages();
    }

    private void setImages() {
        images = new Image[4];
        try {
            images[0] = ImageIO.read(new File("bt7_UP.png").getAbsoluteFile());
            images[1] = ImageIO.read(new File("bt7_Down.png").getAbsoluteFile());
            images[2] = ImageIO.read(new File("bt7_Left.png").getAbsoluteFile());
            images[3] = ImageIO.read(new File("bt7_Rigth.png").getAbsoluteFile());

        } catch (IOException e) {
            System.err.println("Can't find image of BT7.");
        }
    }

    @Override
    public Action setUp() {
        if (step >= actoins.length) {
            step = 0;
        }
        if (!(actoins[step] instanceof Action)) {
            turn((Direction) actoins[step++]);
        }
        if (step >= actoins.length) {
            step = 0;
        }
        return (Action) actoins[step++];
    }
}
