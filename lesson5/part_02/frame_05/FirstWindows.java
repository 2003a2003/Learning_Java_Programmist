package lesson5.part_02.frame_05;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.io.*;

public class FirstWindows extends JPanel{

    private final static String IMAGE_NAME_00 = "iTankUP-01.png";
    private final static String IMAGE_NAME_01 = "iWater.png";
    private final static String IMAGE_NAME_02 = "iBrick.png";
    private final static String IMAGE_NAME_03 = "iRock.png";

    private Image myPicher_00;
    private Image myPicher_01;
    private Image myPicher_02;
    private Image myPicher_03;

    public FirstWindows() {

        try {
            myPicher_00 = ImageIO.read(new File(IMAGE_NAME_00));
            myPicher_01 = ImageIO.read(new File(IMAGE_NAME_01));
            myPicher_02 = ImageIO.read(new File(IMAGE_NAME_02));
            myPicher_03 = ImageIO.read(new File(IMAGE_NAME_03));
        } catch (IOException e) {
            System.err.println("Can't find image: ");
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
        g.drawString("My First TEXT and Image on Panel ^).............", 50, 50);

        g.drawImage(myPicher_00, 50, 100, new ImageObserver() {

            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        });

        g.drawImage(myPicher_01, 150, 100, new ImageObserver() {

            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        });

        g.drawImage(myPicher_02, 350, 100, new ImageObserver() {

            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        });

        g.drawImage(myPicher_03, 550, 100, new ImageObserver() {

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
