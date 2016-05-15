package lesson5.part_04.frame_09.bf.tanks;

import lesson5.part_04.frame_09.Direction;
import lesson5.part_04.frame_09.bf.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class BT7 extends AbstractTank {

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

    private int step = 0;
    private ArrayList<Object> list = new ArrayList<>();
    private int size = 0;

    private final String I_UP = "bt7_UP.png";
    private final String I_DOWN = "bt7_Down.png";
    private final String I_LEFT = "bt7_Left.png";
    private final String I_RIGTH = "bt7_Rigth.png";

    private String NAME_IMAGE;


    public BT7(BattleField bf) {
        super(bf);
        tankColor = new Color(255, 0, 0);
        towerColor = new Color(0, 255, 0);
        movePath = 1;
    }

    public BT7(BattleField bf, int x, int y, Direction direction) {
        super(bf, x, y, direction);
        tankColor = new Color(255, 0, 0);
        towerColor = new Color(0, 255, 0);
        movePath = 1;
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

    public void scanMap() {

//        if(list.size() == 0){
//            ArrayList<Object> ll = new ArrayList<>();
//        }
////        }else{
////            System.out.println("You doun't have List......");
////        }
//        list.add(new ArrayList());
//        list.add(new ArrayList());
//
//        System.out.println(list.size());
//        System.out.println("*******************");


//        int xStart = getX() / 64;
//        int yStart = getY() / 64;
//        if (xStart == 0) {
//            if (scanVLine(xStart, yStart) == 0) {
//                addVActions(xStart, yStart);
//            }
//        } else if (xStart == 4) {
//            if (scanVLine(xStart, yStart) == 0) {
//                addVActions(xStart, yStart);
//            }
//        } else {
//            if (scanVLine(xStart, yStart) == 0) {
//                addVActions(yStart,yStart);
//            }
//        }

    }


    private boolean checkQuadrant(int x, int y) {
        if (x >= 0 && x < 9 && y >= 0 && y < 9) {
            return true;
        }
        return false;
    }

    private int scanVLine(int x, int y) {
        boolean move = true;
        boolean fire = true;

        while (y < 9) {
            BFObject bfObject = getBf().scanQuadrant(y + 1, x);
            if (bfObject instanceof Water) {
                move = false;
                y++;
            } else if (bfObject instanceof Rock) {
                return 3;
            }
            y++;
        }


        if (move == false && fire == true) {
            return 2;
        } else {
            return 0;
        }
    }

    private void addVActions(int x, int y) {

        while (y < 8) {
            BFObject bfObject = getBf().scanQuadrant(y + 1, x);
            if (bfObject instanceof Blank) {
                list.add(Action.MOVE);
            } else {
                list.add(Action.FIRE);
            }
            y++;
        }

        if (y == 8 && (x >= 0 && x < 4)) {
            list.add(Direction.RIGHT);
        } else if (y == 8 && (x > 4 && x <= 8)) {
            list.add(Direction.LEFT);
        }

    }

    private int scanHLine(int x, int y) {

        boolean move = true;
        boolean fire = true;

        if (x >= 0 && x < 4) {
            while (x < 4) {
                BFObject bfObject = getBf().scanQuadrant(y, x + 1);
                if (bfObject instanceof Water) {
                    move = false;
                    x++;
                } else if (bfObject instanceof Rock) {
                    return 3;
                }
            }
        } else if (x > 4 && x <= 8) {
            while (x > 4) {
                BFObject bfObject = getBf().scanQuadrant(y, x - 1);
                if (bfObject instanceof Water) {
                    move = false;
                    x--;
                } else if (bfObject instanceof Rock) {
                    return 3;
                }
            }
        }

        if (move == false && fire == true) {
            return 2;
        } else {
            return 0;
        }
    }

    private int scanCenterLine() {
        int x = 4;
        int y = 1;
        boolean move = true;
        boolean fire = true;

        while (y < 8) {
            BFObject bfObject = getBf().scanQuadrant(y, x);
            if (bfObject instanceof Water) {
                move = false;
                y++;
            } else if (bfObject instanceof Rock) {
                move = false;
                fire = false;
                return 2;
            }
        }

        if (move == false && fire == true) {
            return 1;
        } else {
            return 0;
        }

    }


    @Override
    public Action setUp() {
//        if (step >= list.size()) {
//            step = 0;
//        }
//
//        if (!(list.get(step) instanceof Action)) {
//            turn((Direction) list.get(step++));
//        }
//
//        if (step >= list.size()) {
//            step = 0;
//        }

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
//        return (Action) list.get(step++);
    }
}