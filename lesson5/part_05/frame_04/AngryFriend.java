package lesson5.part_05.frame_04;

import javax.swing.*;
import java.awt.*;

public class AngryFriend extends JPanel {

    private int x = 100;
    private int y = 100;

    public AngryFriend() {

        JFrame f = new JFrame("Angry Friend :)");

        f.setMinimumSize(new Dimension(800, 800));
        f.setLocation(100, 100);

        f.getContentPane().add(this);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.red);
        g.fillOval(x, y, 100, 100);

        g.setFont(new Font("Arial", Font.CENTER_BASELINE, 30));
        g.drawString("Click me!!", 300, 50);


    }
}
