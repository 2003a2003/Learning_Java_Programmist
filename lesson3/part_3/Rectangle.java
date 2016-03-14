package lesson3.part_3;

import java.awt.*;
import java.awt.Color;

public class Rectangle extends AbstractShape {

    public Rectangle(){
        color = new Color(90,90,90);
    }
    @Override
    public void draw(Graphics g) {

        ((Graphics2D) g).setStroke(new BasicStroke(10.0f));
        g.setColor(Color.blue);
        g.drawPolygon(new int[]{210, 380, 380, 210}, new int[]{100, 100, 200, 200}, 4);
//        g.drawRect(210, 100, 170, 100);
        g.setColor(color);
        g.fillRect(260,110,80,80);


        System.out.println("You see a rectangle. ");
    }
}
