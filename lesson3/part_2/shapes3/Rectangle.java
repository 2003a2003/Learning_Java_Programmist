package lesson3.part_2.shapes3;

import java.awt.*;
import java.awt.Color;

public class Rectangle extends Shape {

    @Override
    public void draw(Graphics g) {

        ((Graphics2D) g).setStroke(new BasicStroke(10.0f));
        g.setColor(Color.blue);
//        g.drawRect(210, 100, 170, 100);
//        g.setColor(Color.DARK_GRAY);
//        g.fillRect(260,110,80,80);
        g.drawPolygon(new int[]{110, 190, 190, 110}, new int[]{210, 210, 280, 280}, 4);

        System.out.println("You see a rectangle. ");
    }
}
