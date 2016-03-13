package lesson3.part_2.shapes3;

import java.awt.*;
import java.awt.Color;

public class Rectangle extends Shape {

    @Override
    public void draw(Graphics g) {

        ((Graphics2D) g).setStroke(new BasicStroke(10.0f));
        g.setColor(Color.blue);
        g.drawRect(250, 100, 100, 100);
        g.setColor(Color.DARK_GRAY);
        g.fillRect(260,110,80,80);

        System.out.print("You see a rectangle. ");
    }
}
