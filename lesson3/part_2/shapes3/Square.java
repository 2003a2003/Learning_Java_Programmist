package lesson3.part_2.shapes3;

import java.awt.*;
import java.awt.Color;

public class Square extends Shape{


    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(6));

        g.setColor(Color.blue);
        g.drawRect(250, 210, 100, 100);

    }
}
