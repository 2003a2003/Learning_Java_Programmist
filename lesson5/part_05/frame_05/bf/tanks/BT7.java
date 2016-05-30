package lesson5.part_05.frame_05.bf.tanks;

import lesson5.part_05.frame_05.Direction;
import lesson5.part_05.frame_05.bf.BattleField;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class BT7 extends AbstractTank {

    private int step;
    private AggressorLogic aiDestroyEagle;
    private ArrayList<Object> act;

    public BT7(BattleField bf) {
        super(bf);
        tankColor = new Color(255, 0, 0);
        towerColor = new Color(0, 255, 0);
        movePath = 1;
        setImages();
        act = new ArrayList<>();
    }

    public BT7(BattleField bf, int x, int y, Direction direction) {
        super(bf, x, y, direction);

        tankColor = new Color(255, 0, 0);
        towerColor = new Color(0, 255, 0);

        movePath = 1;

        setImages();

        act = new ArrayList<>();
        aiDestroyEagle = new AggressorLogic();
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

//        if (step >= actoins.length) {
//            step = 0;
//        }
//        if (!(actoins[step] instanceof Action)) {
//            turn((Direction) actoins[step++]);
//        }
//        if (step >= actoins.length) {
//            step = 0;
//        }
//        return (Action) actoins[step++];

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


    public void attackEagle() {

        if (getBf().scanQuadrant(8, 4).isDestroyed()) {System.out.println("GAME OVER!!!!!!!");}

        initStartParameterInWorkArraAgressorBT7();
        aiDestroyEagle.startDestroyEagle();
        act = aiDestroyEagle.getPart();

        int index = 1;
        for (int i =0 ; i < act.size(); i++) {
            System.out.println(index + " " + act.get(i));
            index++;
        }


    }

    private void initStartParameterInWorkArraAgressorBT7(){
        aiDestroyEagle.setsX(getX() / 64);
        aiDestroyEagle.setsY(getY() / 64);
        aiDestroyEagle.seteX(4);
        aiDestroyEagle.seteY(8);
        aiDestroyEagle.setBf(getBf());
        aiDestroyEagle.setAt(this);
    }
}
