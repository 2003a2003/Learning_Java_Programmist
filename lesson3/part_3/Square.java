package lesson3.part_3;

import java.awt.*;

public class Square extends Rectangle {

    @Override
    public void draw(Graphics g) {
        int x = 250;
        int y = 210;
        int width = 100;
        int height = width;

        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(2));

        g.setColor(Color.BLACK);
        g.fillRect(x, y, width, height);
        System.out.println("You see a square. ");
    }
}
