package lesson3.part_2.shapes3;

import java.awt.*;
import java.awt.Color;

public class Triangle extends Shape {

    @Override
    public void draw(Graphics g) {
        ((Graphics2D) g).setStroke(new BasicStroke(6.0f));
        int[] x = {450, 390, 510};
        int[] y = {100, 200, 200};

        g.drawPolygon(x,y,3);

        int[] x2 = {450, 420, 480};
        int[] y2 = {130, 180, 180};
        g.setColor(Color.CYAN);
        g.fillPolygon(x2,y2,3);
        System.out.println("You see a Triangle. ");
    }
}
