package lesson3.part_3;

import java.awt.*;

public abstract class AbstractShape implements Drawable{

    protected Color color;

    public AbstractShape(){
        color = new Color(234, 246, 76);
    }

    public Color getColor() {
        return color;
    }
}