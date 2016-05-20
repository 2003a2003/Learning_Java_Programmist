package lesson5.part_05.frame_03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class MagicQuadrant {

    private Random random = new Random();
    private int i = 0;

    public MagicQuadrant() {

        JFrame magicQuadrant = new JFrame("Magic Quadrant");
        magicQuadrant.setMinimumSize(new Dimension(800, 600));
        magicQuadrant.setLocation(300, 300);

        magicQuadrant.getContentPane().add(createMyPanel());

        magicQuadrant.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        magicQuadrant.pack();
        magicQuadrant.setVisible(true);

    }

    private JPanel createMyPanel() {

        JPanel panel = new JPanel();
        panel.setBackground(randomColor());

        panel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panel.setBackground(randomColor());
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

        });

        return panel;
    }

    private Color randomColor() {

        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);

        return new Color(r,g,b);
    }

    public static void main(String[] args) {
        new MagicQuadrant();
    }
}