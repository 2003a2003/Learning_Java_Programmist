package lesson5.part_05.frame_05.bf.tanks;

import lesson5.part_05.frame_05.Direction;
import lesson5.part_05.frame_05.bf.BattleField;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class T34 extends AbstractTank {

    public T34(BattleField bf) {
        super(bf, 128, 512, Direction.UP);
        tankColor = new Color(0, 255, 0);
        towerColor = new Color(255, 0, 0);
        setImages();
    }

    public T34(BattleField bf, int x, int y, Direction direction) {
        super(bf, x, y, direction);
        tankColor = new Color(0, 255, 0);
        towerColor = new Color(255, 0, 0);
        setImages();
    }

    private void setImages() {
        images = new Image[4];
        try {
            images[0] = ImageIO.read(new File("t34_up.png").getAbsoluteFile());
            images[1] = ImageIO.read(new File("t34_down.png").getAbsoluteFile());
            images[2] = ImageIO.read(new File("t34_left.png").getAbsoluteFile());
            images[3] = ImageIO.read(new File("t34_rigth.png").getAbsoluteFile());

        } catch (IOException e) {
            System.err.println("Can't find image of t34.");
        }
    }
    private Object[] actoins = new Object[]{
//            Direction.RIGHT,
//            Action.NONE,
//            Action.MOVE,
            Action.FIRE,
//            Action.MOVE,
//            Action.FIRE,
//            Action.MOVE,
//            Action.FIRE,
//            Action.MOVE,
//            Direction.RIGHT,
//            Action.FIRE,
//            Action.MOVE,

    };

    private int step = 0;

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
