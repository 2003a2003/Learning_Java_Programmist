package lesson8.part_05.frame_02.bf.tanks;

import lesson8.part_05.frame_02.Direction;
import lesson8.part_05.frame_02.bf.BattleField;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Tiger extends AbstractTank {

    private int armor;
    private int step;
    private AggressorLogic aiDestroyDefender;
    private ArrayList<Object> act;

    public Tiger(BattleField bf) {
        super(bf);
        tankColor = new Color(255, 0, 0);
        towerColor = new Color(0, 255, 0);
        armor = 1;
        setImages();
        act = new ArrayList<>();
        aiDestroyDefender = new AggressorLogic();
    }

    public Tiger(BattleField bf, int x, int y, Direction direction) {
        super(bf, x, y, direction);
        tankColor = new Color(255, 0, 0);
        towerColor = new Color(0, 255, 0);
        armor = 1;
        setImages();
        act = new ArrayList<>();
        aiDestroyDefender = new AggressorLogic();
    }

    @Override
    public void destroy() {
        if (armor > 0) {
            armor--;
        } else {
            super.destroy();
        }
    }

    private void setImages() {
        images = new Image[4];
        try {
            images[0] = ImageIO.read(new File("tiger_up.png").getAbsoluteFile());
            images[1] = ImageIO.read(new File("tiger_down.png").getAbsoluteFile());
            images[2] = ImageIO.read(new File("tiger_left.png").getAbsoluteFile());
            images[3] = ImageIO.read(new File("tiger_rigth.png").getAbsoluteFile());

        } catch (IOException e) {
            System.err.println("Can't find image of t34.");
        }
    }

    @Override
    public Action setUp() {
        //step = 0;
        if (step >= act.size()) {
            return Action.NONE;
        }
        if (!(act.get(step) instanceof Action)) {
            turn((Direction) act.get(step++));
        }
        if (step >= act.size()) {
            return Action.NONE;
        }
        return (Action) act.get(step++);
    }

    public void attackDefender(T34 t34) {
        initStartParameterInWorkArraAgressorTiger(t34);
        aiDestroyDefender.startDestroyDefender();
        act = aiDestroyDefender.getPart();

        int index = 1;
        for (int i =0 ; i < act.size(); i++) {
            System.out.println(index + " " + act.get(i));
            index++;
        }
    }

    private void initStartParameterInWorkArraAgressorTiger(T34 t34) {
        aiDestroyDefender.setsX(getX() / 64);
        aiDestroyDefender.setsY(getY() / 64);
        aiDestroyDefender.setdX(t34.getX() / getBf().getSIZE_ONE_QUADRANT());
        aiDestroyDefender.setdY(t34.getY() / getBf().getSIZE_ONE_QUADRANT());
        aiDestroyDefender.setBf(getBf());
        aiDestroyDefender.setAt(this);
        aiDestroyDefender.setT34(t34);
    }
}
