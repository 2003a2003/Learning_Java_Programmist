package lesson8.part_05.frame_02.bf.tanks;

import lesson8.part_05.frame_02.Direction;
import lesson8.part_05.frame_02.bf.BattleField;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class BT7 extends AbstractTank {

    private int step;
    private AggressorLogic aiDestroyEagle;
    private ArrayList<Object> act;

    public BT7(BattleField bf, File logFile) {
        super(bf,logFile);
        tankColor = new Color(255, 0, 0);
        towerColor = new Color(0, 255, 0);
        movePath = 1;
        setImages();
        act = new ArrayList<>();
    }

    public BT7(BattleField bf, int x, int y, Direction direction, File logFile) throws IOException {
        super(bf, x, y, direction, logFile);

        tankColor = new Color(255, 0, 0);
        towerColor = new Color(0, 255, 0);

        movePath = 1;

        setImages();

        act = new ArrayList<>();
        aiDestroyEagle = new AggressorLogic();
        aiDestroyEagle.getWorkWithLogFile().updateLogFile(getLogFile(), "bt7:" + x + "_" + y);
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

    public void attackEagle() throws IOException {
        if (getBf().scanQuadrant(8, 4).isDestroyed()) {
            System.out.println("EAGLE IS DESTROY!!!!!!!");
        }

        initStartParameterInWorkArraAgressorBT7();

        aiDestroyEagle.startDestroyEagle();
        act = aiDestroyEagle.getPart();

        //aiDestroyEagle.getWorkWithLogFile().updateLogFile(getLogFile(), "The road to the goal:\n");

        int index = 1;
        for (int i =0 ; i < act.size(); i++) {
            System.out.println(index + " " + act.get(i));
            aiDestroyEagle.getWorkWithLogFile().updateLogFile(getLogFile(), ("bt7_" + act.get(i).toString()));
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

    public ArrayList<Object> getAct() {
        return act;
    }

    public void setAct(ArrayList<Object> act) {
        this.act = act;
    }
}
