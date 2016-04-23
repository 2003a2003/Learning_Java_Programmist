package lesson5.part_02.frame_05;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class FirstWindows extends JPanel {

    private final static String IMAGE_NAME = "firstImage.gif";
    private Image myPicher;

    public FirstWindows() {

        try {
            myPicher = ImageIO.read(new File(IMAGE_NAME));
        } catch (IOException e) {
            System.err.println("Can't find image: " + IMAGE_NAME);
        }

        JFrame win = new JFrame("First Windows");

        win.setMinimumSize(new Dimension(800, 600));
        win.setLocation(300, 100);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        win.getContentPane().add(this);

        win.pack();
        win.setVisible(true);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.green);
        g.fillRect(0, 0, 800, 600);

        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
        g.drawString("My First TEXT on Panel ^).............", 50, 50);

        g.setColor(Color.RED);
        g.setFont(new Font("Verdana", Font.PLAIN, 20));
        g.drawString("My First TEXT on Panel ^).............", 50, 80);

        g.drawImage(myPicher, 50, 100, new ImageObserver() {

            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        });
    }

    public static void main(String[] args) throws Exception {
        FirstWindows f = new FirstWindows();
    }
}
