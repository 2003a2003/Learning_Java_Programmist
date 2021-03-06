package lesson5.part_02.frame_05;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class FirstWindows extends JPanel {

    private final static String IMAGE_NAME = "iTankUP.png";
    private BufferedImage myPicher;

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
    public void paint(Graphics g) {
//        super.paintComponent(g);

        g.setColor(Color.green);
        g.fillRect(0, 0, 800, 600);

        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
        g.drawString("My First TEXT and Image on Panel ^).............", 50, 50);

        g.drawImage(myPicher, 50, 100, null);
    }

    public static void main(String[] args) throws Exception {
        FirstWindows f = new FirstWindows();
    }
}
