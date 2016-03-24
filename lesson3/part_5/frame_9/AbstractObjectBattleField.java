package lesson3.part_5.frame_9;

public abstract class AbstractObjectBattleField implements Drawable{

    private int x;
    private int y;
    private BattleField bf;

    public AbstractObjectBattleField(int x, int y, BattleField bf) {
        this.x = x;
        this.y = y;
        this.bf = bf;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public BattleField getBf() {
        return bf;
    }

    public void setBf(BattleField bf) {
        this.bf = bf;
    }
}
