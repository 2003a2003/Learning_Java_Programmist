package lesson9.part_01;

import lesson1.part_4.frame_4.Color;

import javax.swing.*;
import java.awt.*;

public class Balls extends JPanel{

    private int speed;
    private Color color;
    private int x;
    private int y;
    private int WIDTH = 300;
    private int HEIGHT = 500;

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

    public Balls() throws InterruptedException {
        JFrame f = new JFrame("BALL");
        f.setLocation(300,300);
        f.setMinimumSize(new Dimension(HEIGHT, WIDTH));
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.getContentPane().add(this);
        f.pack();
        f.setVisible(true);

//        createBalls();
            action();

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(java.awt.Color.BLUE);
        g.fillOval(x,y,20,20);
    }

    public void action() throws InterruptedException {
        boolean todo = true;
        while (true){
            if(todo == true){
                x++;
                if (x > HEIGHT-40){
                    todo = false;
                }
            } else {
                x--;
                if (x < 0) {
                    todo = true;
                }
            }
            Thread.sleep(10);
            repaint();
        }
    }

}
