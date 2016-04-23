package lesson5.part_01.frame_08;

import javax.swing.*;
import java.awt.*;

public class FirstWindows extends JPanel {

    public static int x = 0;
    public static int y = 0;

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

        g.setColor(Color.green);
        g.fillRect(x, y, 800, 600);
    }

    public static void main(String[] args) throws Exception {
        FirstWindows f = new FirstWindows();

    }
}
