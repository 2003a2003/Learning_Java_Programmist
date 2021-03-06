package lesson6.part_04.frame_05.bf;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class Water extends SimpleBFObject {

    private final static String NAME_IMAGE = "iWater.jpg";

    public Water(int x, int y) {
        super(x, y);
        color = new Color(0, 0, 194);

        try {
            img = ImageIO.read(new File(NAME_IMAGE));
        } catch (IOException e) {
            System.out.println("Can't find image: " + NAME_IMAGE);
        }
    }

    @Override
    public void draw(Graphics g) {

        Graphics2D g2d = (Graphics2D) g.create();
        Composite org = g2d.getComposite();

        Composite translucent = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);
        g2d.setComposite(translucent);

        g.drawImage(img, getX(), getY(), 64, 64, new ImageObserver() {
            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        });

        g2d.setComposite(org);
    }
}
