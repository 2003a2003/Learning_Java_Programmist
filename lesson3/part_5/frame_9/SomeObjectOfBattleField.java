package lesson3.part_5.frame_9;

import java.awt.*;

public class SomeObjectOfBattleField implements Drawable{

    private int x;
    private int y;
    private BattleField bf;
    private Color color;

    public SomeObjectOfBattleField(int x, int y, BattleField bf,Color color) {
        this.x = x;
        this.y = y;
        this.bf = bf;
        this.color = color;
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

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x,y,64,64);
    }
}