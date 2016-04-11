package lesson4.part_05.frame_10.OLD.battlefield;

import lesson4.part_05.frame_10.OLD.utils.ActionField;

import java.awt.*;
import java.util.Random;

public class BattleField {

    private final int BF_WIDTH = 576;
    private final int BF_HEIGHT = 576;
    private final int SIZE_ONE_QUADRANT = 64;
    private final int MIN_QUADRANT_COORDINATE = 0;
    private final int MAX_QUADRANT_COORDINATE = 512;
    private boolean COLORDED_MODE = false;

    private SomeObjectOfBattleField[][] battleField = {
            {new Empty(0,0, this), new Brick(64,0, this), new Brick(128,0, this), new Brick(192,0, this),
                    new Empty(256,0, this), new Brick(320,0, this),new Brick(384,0, this),new Brick(448,0, this),
                    new Empty(512,0, this)},

            {new Empty(0,64, this), new Brick(64,64, this), new Brick(128,64, this), new Brick(192,64, this),
                    new Water(256,64, this), new Brick(320,64, this), new Brick(384,64, this), new Brick(448,64, this),
                    new Empty(512,64, this)},

            {new Empty(0,128, this), new Brick(64,128, this), new Brick(128,128, this), new Brick(192,128, this),
                    new Brick(256,128, this), new Brick(320,128, this), new Brick(384,128, this),
                    new Brick(448,128, this), new Empty(512,128, this)},

            {new Empty(0,192, this), new Empty(64,192, this), new Empty(128,192, this), new Empty(192,192, this),
                    new Empty(256,192, this), new Empty(320,192, this), new Empty(384,192, this),
                    new Empty(448,192, this), new Empty(512,192, this)},

            {new Brick(0,256, this), new Brick(64,256, this), new Brick(128,256, this), new Brick(192,256, this),
                    new Rock(256,256, this), new Brick(320,256, this), new Brick(384,256, this),
                    new Brick(448,256, this), new Brick(512,256, this)},

            {new Brick(0,320, this), new Brick(64,320, this), new Brick(128,320, this), new Brick(192,320, this),
                    new Brick(256,320, this), new Brick(320,320, this), new Brick(384,320, this),
                    new Brick(448,320, this), new Brick(512,320, this)},

            {new Brick(0,384, this), new Empty(64,384, this), new Brick(128,384, this), new Brick(192,384, this),
                    new Brick(256,384, this), new Brick(320,384, this), new Brick(384,384, this),
                    new Brick(448,384, this), new Brick(512,384, this)},

            {new Brick(0,448, this), new Empty(64,448, this), new Brick(128,448, this), new Brick(192,448, this),
                    new Empty(256,448, this), new Brick(320,448, this), new Brick(384,448, this),
                    new Brick(448,448, this), new Brick(512,448, this)},

            {new Brick(0,512, this), new Brick(64,512, this), new Brick(128,512, this), new Brick(192,512, this),
                    new Eagle(256,512, this), new Brick(320,512, this), new Brick(384,512, this),
                    new Brick(448,512, this), new Brick(512,512, this)},
    };



    public BattleField() {
    }

    public BattleField(SomeObjectOfBattleField[][] battleField) {
        this.battleField = battleField;
    }

    public SomeObjectOfBattleField scanQuadrant(int v, int h) {
        return battleField[v][h];
    }

    public void updateQuadrant(int v, int h, SomeObjectOfBattleField object) {
        battleField[v][h] = object;
    }

    public int getDimentionX() {
        return BF_WIDTH / SIZE_ONE_QUADRANT;
        //return battleField[0].length;
    }

    public int getDimentionY() {
        return BF_HEIGHT / SIZE_ONE_QUADRANT;
        //return battleField.length;
    }

    public int getBF_WIDTH() {
        return BF_WIDTH;
    }

    public int getBF_HEIGHT() {
        return BF_HEIGHT;
    }

    public SomeObjectOfBattleField[][] getBattleField() {
        return battleField;
    }

    public int getSIZE_ONE_QUADRANT() {
        return SIZE_ONE_QUADRANT;
    }

    public int getMIN_QUADRANT_COORDINATE() {
        return MIN_QUADRANT_COORDINATE;
    }

    public int getMAX_QUADRANT_COORDINATE() {
        return MAX_QUADRANT_COORDINATE;
    }

    public int getCoordinatesAgressorX() {
        int coord = 4 * SIZE_ONE_QUADRANT;
        Random r = new Random();
        int index = r.nextInt(3);

        if (index == 0) {
            coord = 0 * SIZE_ONE_QUADRANT;
        } else if (index == 1) {
            coord = 4 * SIZE_ONE_QUADRANT;
        } else {
            coord = 8 * SIZE_ONE_QUADRANT;
        }
        return coord;
    }

    public int getCoordinatesAgressorY() {
        int coord = 0;
//        Random r = new Random();
//        int index = r.nextInt(3);
//
//        if (index == 0) {
//            coord = 0 * SIZE_ONE_QUADRANT;
//        } else if (index == 1) {
//            coord = 4 * SIZE_ONE_QUADRANT;
//        } else {
//            coord = 8 * SIZE_ONE_QUADRANT;
//        }
        return coord;
    }

    public String getAgressorLocation(){
        int locationX = 0;

        Random r = new Random();
        int index = r.nextInt(3);

        if (index == 1) {
            locationX = 4 * SIZE_ONE_QUADRANT;
        } else {
            locationX = 8 * SIZE_ONE_QUADRANT;
        }

        return locationX + "_0";
    }

    public void printComponent(Graphics g, ActionField af){
        int i = 0;
        Color cc;
        for (int v = 0; v < 9; v++) {
            for (int h = 0; h < 9; h++) {
                if (COLORDED_MODE) {
                    if (i % 2 == 0) {
                        cc = new Color(252, 241, 177);
                    } else {
                        cc = new Color(233, 243, 255);
                    }
                } else {
                    cc = new Color(180, 180, 180);
                }
                i++;
                g.setColor(cc);
                g.fillRect(h * 64, v * 64, 64, 64);
            }
        }

        for (int j = 0; j < getBattleField().length; j++) {
            for (int k = 0; k < getBattleField().length; k++) {
                String coordinates = af.getQuadrantXY(j + 1, k + 1);

                if (scanQuadrant(j,k) instanceof Empty) {
                    scanQuadrant(j,k).draw(g);
                }else if(scanQuadrant(j,k) instanceof Brick){
                    scanQuadrant(j,k).draw(g);
                }else if(scanQuadrant(j,k) instanceof Water) {
                    scanQuadrant(j, k).draw(g);
                }else if(scanQuadrant(j,k) instanceof Rock) {
                    scanQuadrant(j, k).draw(g);
                }else if(scanQuadrant(j,k) instanceof Eagle) {
                    scanQuadrant(j, k).draw(g);
                }
            }
        }
    }
}