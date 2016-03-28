package lesson3.part_5.frame_10.battlefield;

import lesson3.part_5.frame_10.utils.ActionField;

import java.awt.*;
import java.util.Random;

public class BattleField {

    private final int BF_WIDTH = 576;
    private final int BF_HEIGHT = 576;
    private final int SIZE_ONE_QUADRANT = 64;
    private final int MIN_QUADRANT_COORDINATE = 0;
    private final int MAX_QUADRANT_COORDINATE = 512;
    private boolean COLORDED_MODE = false;


    private String[][] battleField = {
            {" ", "B", "B", "B", " ", "B", "B", "B", " "},
            {" ", "B", "B", "B", "W", "B", "B", "B", " "},
            {" ", "B", "B", "B", "B", "B", " ", "B", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " "},
            {"B", "B", "B", "B", "R", "B", "B", "B", "B"},
            {"B", "B", "B", " ", "B", "B", " ", "B", "B"},
            {"B", " ", "B", " ", "B", "B", "B", "B", "B"},
            {"B", " ", "B", "B", " ", "B", "B", "B", "B"},
            {"B", "B", "B", "B", "E", "B", "B", "B", "B"}
    };

    public BattleField() {
    }

    public BattleField(String[][] battleField) {
        this.battleField = battleField;
    }

    public String scanQuadrant(int v, int h) {
        return battleField[v][h];
    }

    public void updateQuadrant(int v, int h, String object) {
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

    public String[][] getBattleField() {
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
                int separator = coordinates.indexOf("_");
                int y = Integer.parseInt(coordinates.substring(0, separator));
                int x = Integer.parseInt(coordinates.substring(separator + 1));

                if (scanQuadrant(j, k).equals("B")) {
                    Brick brick = new Brick(x, y, this);
                    brick.draw(g);
                } else if (scanQuadrant(j, k).equals("W")) {
                    Water water = new Water(x, y, this);
                    water.draw(g);
                } else if (scanQuadrant(j, k).equals("R")) {
                    g.setColor(new Color(132, 127, 152));
                    g.fillRect(x, y, 64, 64);
                } else if (scanQuadrant(j, k).equals("E")) {
                    Eagle eagle = new Eagle(x, y, this);
                    eagle.draw(g);
                }
            }
        }
    }


}