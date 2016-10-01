package lesson9.part_01;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Balls extends JPanel {

    private int WIDTH = 300;
    private int HEIGHT = 500;

    private Ball ball;

    private ArrayList<Ball> someBolls = new ArrayList<>();
    private Color[] color;

    public Balls() throws InterruptedException {

        JFrame f = new JFrame("BALL");
        f.setLocation(300, 300);
        f.setMinimumSize(new Dimension(HEIGHT, WIDTH));
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.getContentPane().add(this);
        f.pack();
        f.setVisible(true);

        crateColorsArray();

        createBall();
    }

    private void crateColorsArray() {
        color = new Color[]{
                    Color.BLACK,
                    Color.DARK_GRAY,
                    Color.BLUE,
                    Color.GREEN,
                    Color.CYAN,
                    Color.PINK,
                    Color.pink,
                    Color.GRAY,
                    Color.YELLOW,
                    Color.ORANGE
        };
    }

    private void createBall() throws InterruptedException {
        int i = 0;
        int x = 0;
        int y = 0;
        int speed = 1;

        while (i < color.length) {
            ball = new Ball(x, y, speed, color[i]);
            someBolls.add(ball);
            ball.start();
            i++;
            y += 30;
            speed += 2;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Ball b : someBolls) {
            b.draw(g);
        }
    }

    class Ball extends Thread {

        private int x;
        private int y;
        private int speed;
        private Color color;

        public Ball(int x, int y, int speed, Color color) {
            this.x = x;
            this.y = y;
            this.speed = speed;
            this.color = color;
        }

        public void draw(Graphics g) {
            g.setColor(color);
            g.fillOval(x, y, 20, 20);
            repaint();
        }

        public void action() throws InterruptedException {
            boolean todo = true;
            while (true) {
                if (todo == true) {
                    x++;
                    if (x > HEIGHT - 40) {
                        todo = false;
                    }
                } else {
                    x--;
                    if (x < 0) {
                        todo = true;
                    }
                }
                Thread.sleep(speed);
            }
        }

        @Override
        public void run() {
            try {
                action();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}