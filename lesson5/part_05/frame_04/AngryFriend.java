package lesson5.part_05.frame_04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Random;

public class AngryFriend extends JPanel{ //} implements MouseMotionListener {

    private final int PANEL_WIDTH = 800;
    private final int PANEL_HEIGHT = 800;
    private final int PANEL_X = 100;
    private final int PANEL_Y = 100;

    private int circleWidth = 100;
    private int circleHeight = 100;

    private int x = 100;
    private int y = 100;

    public AngryFriend() {

        JFrame f = new JFrame("Angry Friend :)");
        f.setMinimumSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        f.setLocation(PANEL_X, PANEL_Y);

        //addMouseMotionListener(this);
        this.setBackground(Color.BLACK);
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (((x < e.getX() && e.getX() - x < 120) && (y < e.getY() && e.getY() - y < 120)) ||
                        ((x > e.getX() && x - e.getX() < 60) && (y > e.getY() && y - e.getY() < 60))) {
                    x = randomCoord();
                    y = randomCoord();
                }
                repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                if (((x < e.getX() && e.getX() - x < 120) && (y < e.getY() && e.getY() - y < 120)) ||
                        ((x > e.getX() && x - e.getX() < 60) && (y > e.getY() && y - e.getY() < 60))) {
                    x = randomCoord();
                    y = randomCoord();
                }
                repaint();
            }
        });

        f.getContentPane().add(this);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.WHITE);
        g.fillOval(x, y, circleWidth, circleHeight);

        g.setColor(Color.PINK);
        g.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
        g.drawString("Click me!!", x + 15, y + 55);
    }

//    @Override
//    public void mouseDragged(MouseEvent e) {
//        if (((x < e.getX() && e.getX() - x < 150) &&
//                (y < e.getY() && e.getY() - y < 150)) ||
//                ((x > e.getX() && x - e.getX() < 150) &&
//                        (y > e.getY() && y - e.getY() < 150))) {
//            x = randomCoord();
//            y = randomCoord();
//        }
//        repaint();
//    }
//
//    @Override
//    public void mouseMoved(MouseEvent e) {
//        if (((x < e.getX() && e.getX() - x < 150) &&
//                (y < e.getY() && e.getY() - y < 150)) ||
//                ((x > e.getX() && x - e.getX() < 150) &&
//                        (y > e.getY() && y - e.getY() < 150))) {
//            x = randomCoord();
//            y = randomCoord();
//        }
//        repaint();
//    }

    private int randomCoord() {
        Random r = new Random();
        return r.nextInt(PANEL_HEIGHT - 150);
    }
}
