package lesson6.part_05.bf.tanks;

import lesson6.part_05.Direction;
import lesson6.part_05.bf.Destroyable;
import lesson6.part_05.bf.Drawable;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class Bullet implements Drawable, Destroyable {

    private int speed = 5;
    private int x;
    private int y;
    private Direction direction;
    private AbstractTank tank;
    private Image[] images;
    private boolean destroyed;

    public Bullet(int x, int y, Direction direction, AbstractTank tank) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.destroyed = false;
        this.tank = tank;
        setImages();
    }

    public void updateX(int x) {
        this.x += x;
    }

    public void updateY(int y) {
        this.y += y;
    }

    @Override
    public void draw(Graphics g) {
        if (!destroyed) {
            g.drawImage(images[getDirection().getId() - 1], getX(), getY(), new ImageObserver() {
                @Override
                public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                    return false;
                }
            });
        }
    }

    public void destroy() {
        destroyed = true;
    }

    @Override
    public boolean isDestroyed() {
        return destroyed;
    }

    public int getSpeed() {
        return speed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

    private void setImages() {
        images = new Image[4];
        try {
            images[0] = ImageIO.read(new File("bullet_up.png").getAbsoluteFile());
            images[1] = ImageIO.read(new File("bullet_down.png").getAbsoluteFile());
            images[2] = ImageIO.read(new File("bullet_left.png").getAbsoluteFile());
            images[3] = ImageIO.read(new File("bullet_rigth.png").getAbsoluteFile());
        } catch (IOException e) {
            System.err.println("Can't find images.");
        }
    }

    public AbstractTank getTank() {
        return tank;
    }

    public void setTank(AbstractTank tank) {
        this.tank = tank;
    }
}
