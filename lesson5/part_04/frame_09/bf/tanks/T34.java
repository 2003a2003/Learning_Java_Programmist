package lesson5.part_04.frame_09.bf.tanks;

import lesson5.part_04.frame_09.Direction;
import lesson5.part_04.frame_09.bf.BattleField;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class T34 extends AbstractTank {

    private final String I_UP = "t34_up.png";
    private final String I_DOWN = "t34_down.png";
    private final String I_LEFT = "t34_left.png";
    private final String I_RIGTH = "t34_rigth.png";

    private String NAME_IMAGE;

    public T34(BattleField bf) {
        super(bf, 128, 512, Direction.UP);
        tankColor = new Color(0, 255, 0);
        towerColor = new Color(255, 0, 0);
    }

    public T34(BattleField bf, int x, int y, Direction direction) {
        super(bf, x, y, direction);
        tankColor = new Color(0, 255, 0);
        towerColor = new Color(255, 0, 0);
    }

    private void setImages() {

        if (this.getDirection() == Direction.UP) {
            NAME_IMAGE = I_UP;
        } else if (this.getDirection() == Direction.DOWN) {
            NAME_IMAGE = I_DOWN;
        } else if (this.getDirection() == Direction.LEFT) {
            NAME_IMAGE = I_LEFT;
        } else {
            NAME_IMAGE = I_RIGTH;
        }

        try {
            img = ImageIO.read(new File(NAME_IMAGE));
        } catch (IOException e) {
            System.err.println("Can't find image of BT7: " + NAME_IMAGE);
        }
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        setImages();

        g.drawImage(img, getX(), getY(), 64, 64, new ImageObserver() {

            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        });
    }

    private Object[] actoins = new Object[]{
//            Direction.RIGHT,
            Action.NONE,
//            Action.MOVE,
//            Action.FIRE,
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
