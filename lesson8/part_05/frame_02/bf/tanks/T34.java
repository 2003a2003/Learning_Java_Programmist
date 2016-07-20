package lesson8.part_05.frame_02.bf.tanks;

import lesson8.part_05.frame_02.Direction;
import lesson8.part_05.frame_02.bf.BattleField;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class T34 extends AbstractTank {

    private ArrayList<Object> act;
    private int step = 0;

    public T34(BattleField bf) {
        super(bf, 128, 512, Direction.UP);
        tankColor = new Color(0, 255, 0);
        towerColor = new Color(255, 0, 0);
        setImages();
        act = new ArrayList<>();
    }

    public T34(BattleField bf, int x, int y, Direction direction) {
        super(bf, x, y, direction);
        tankColor = new Color(0, 255, 0);
        towerColor = new Color(255, 0, 0);
        setImages();
        act = new ArrayList<>();
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

    @Override
    public Action setUp() {
        if (step >= act.size()) {
            //step = 0;
            return Action.NONE;
        }
        if (!(act.get(step) instanceof Action)) {
            turn((Direction) act.get(step++));
        }
        if (step >= act.size()) {
            //step = 0;
            return Action.NONE;
        }
        return (Action) act.get(step++);
    }

    public ArrayList<Object> getAct() {
        return act;
    }

    public void setAct(ArrayList<Object> act) {
        this.act = act;
    }
}
