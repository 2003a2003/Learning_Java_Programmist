package lesson2.part_5.frame_3;

public class BattleField {

    private final int BF_WIDTH = 576;
    private final int BF_HEIGHT = 576;
    private final int SIZE_ONE_QUADRANT = 64;
    private final int MIN_QUADRANT_COORDINATE = 0;
    private final int MAX_QUADRANT_COORDINATE = 512;


    private String[][] battleField = {
            {" ", "B", "B", "B", "B", "B", " ", "B", "B"},
            {" ", " ", "B", "B", "B", "B", "B", "B", "B"},
            {" ", "B", "B", "B", "B", "B", " ", "B", "B"},
            {" ", "B", "B", " ", "B", "B", "B", "B", "B"},
            {"B", "B", "B", "B", "B", "B", "B", "B", "B"},
            {"B", "B", "B", " ", " ", "B", " ", "B", "B"},
            {"B", " ", "B", " ", "B", "B", "B", "B", "B"},
            {"B", " ", "B", "B", "B", "B", "B", "B", "B"},
            {"B", "B", "B", "B", "B", "B", "B", "B", "B"}
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
}