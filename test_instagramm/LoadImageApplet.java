package test_instagramm;

import javax.imageio.ImageIO;
import java.applet.Applet;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class LoadImageApplet extends Applet {
    private BufferedImage img;

    public void init() {
        try {
            URL url = new URL(getCodeBase(), "https://docs.oracle.com/javase/tutorial/2d/images/examples/strawberry.jpg");
            img = ImageIO.read(url);
        } catch (IOException e) {
        }
    }

    public void paint(Graphics g) {
        g.drawImage(img, 50, 50, 200, 200, null);
    }
}
