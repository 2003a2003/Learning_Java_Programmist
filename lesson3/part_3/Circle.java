package lesson3.part_3;

import java.awt.*;
import java.awt.Color;

public class Circle extends AbstractShape {

    public Circle(){
        color = new Color(81, 148, 44);
    }

    @Override
    public void draw(Graphics g) {
        ((Graphics2D) g).setStroke(new BasicStroke(5.0f));
        g.setColor(color);
        g.drawOval(100,100,100,100);

        g.setColor(new Color(148, 24, 16));
        g.fillOval(115,110,70,70);

        System.out.println("You see a circle. ");
    }
}
