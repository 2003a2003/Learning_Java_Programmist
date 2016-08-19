package lesson9.part_01;

import lesson1.part_4.frame_4.Color;

import javax.swing.*;
import java.awt.*;

public class Balls extends JPanel{
    public static void main(String[] args) {
        new Balls();
    }

    private static final Color[] COLORS = new Color[]{
            Color.RED,
            Color.ORANGE,
            Color.AMARANTH,
            Color.BLACK,
            Color.BLUE,
            Color.BROWN,
            Color.CERISE,
            Color.CORAL_RED,
            Color.DARK_PINK,
            Color.DARK_RED
    };

    public Balls(){
        JFrame f = new JFrame("BALL");
        f.setLocation(300,300);
        f.setMinimumSize(new Dimension(500, 300));
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.getContentPane().add(this);
        f.pack();
        f.setVisible(true);

//        createBalls();
//        action();
    }


}
