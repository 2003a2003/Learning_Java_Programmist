package lesson1.part_3.frame_2;

public class BattleField {

    private final boolean COLORDED_MODE = false;

    private final int BF_WIDTH = 576;
    private final int BF_HEIGHT = 576;

    private final int SIZE_ONE_QUADRANT = 64;

    private final int MIN = 0;
    private final int MAX = 512;

    private String[][] battleField = {
            { " ", "B", "B", "B", "B", "B", "B", "B", "B" },
            { "B", "B", "B", "B", "B", "B", "B", "B", "B" },

            { "B", "B", "B", "B", "B", "B", "B", "B", "B" },
            { "B", "B", "B", " ", "B", "B", "B", "B", "B" },
            { "B", "B", "B", "B", "B", "B", "B", "B", "B" },
            { "B", "B", "B", "B", "B", "B", "B", "B", "B" },
            { "B", "B", "B", "B", "B", "B", "B", "B", "B" },
            { "B", "B", "B", "B", "B", "B", "B", "B", "B" },
            { "B", "B", "B", "B", "B", "B", "B", "B", "B" } };

    public int getBF_WIDTH() {
        return BF_WIDTH;
    }

    public int getBF_HEIGHT() {
        return BF_HEIGHT;
    }

    public String[][] getBattleField() {
        return battleField;
    }

    public void setBattleField(String[][] battleField) {
        this.battleField = battleField;
    }

    public int getSIZE_ONE_QUADRANT() {
        return SIZE_ONE_QUADRANT;
    }

    public int getMIN() {
        return MIN;
    }

    public int getMAX() {
        return MAX;
    }

    public boolean isCOLORDED_MODE() {
        return COLORDED_MODE;
    }
}
