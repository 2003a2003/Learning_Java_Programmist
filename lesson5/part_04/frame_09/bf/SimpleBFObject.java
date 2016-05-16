package lesson5.part_04.frame_09.bf;

import java.awt.*;


public abstract class SimpleBFObject implements BFObject {

    // current position on BF
    private int x;
    private int y;

    protected Color color;
    private boolean isDestroyed = false;
    protected Image img;

    public SimpleBFObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void destroy() {
        isDestroyed = true;
    }

    @Override
    public void draw(Graphics g) {
        if (!isDestroyed) {
//            g.drawImage(img, x, y, 65,65, new ImageObserver() {
//                @Override
//                public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
//                    return false;
//                }
//            });
            g.drawImage(img, x, y, 65,65, null);
        }else{
            Blank b = new Blank(x,y);
            b.draw(g);
        }
    }

    public boolean isDestroyed() {
        return isDestroyed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
