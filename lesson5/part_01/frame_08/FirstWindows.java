package lesson5.part_01.frame_08;

import javax.swing.*;
import java.awt.*;

public class FirstWindows extends JPanel {

    public static int x = 50;
    public static int y = 50;

    public FirstWindows() {
        JFrame win = new JFrame("First Windows");

        win.setMinimumSize(new Dimension(800, 600));
        win.setLocation(300, 100);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        win.getContentPane().add(this);

        win.pack();
        win.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.fillRect(x, y, 200, 200);
    }

    public static void main(String[] args) throws Exception {
        FirstWindows f = new FirstWindows();

        while (x < 300) {
            Thread.sleep(1000);
            x += 50;
            y += 50;
            f.repaint();
        }
    }
}
