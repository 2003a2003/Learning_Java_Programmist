package lesson3.part_2.shapes2;

public class Launche {

    public static void main(String[] args) {


        Circle circle = new Circle();
        Rectangle rectangle = new Rectangle();
        Triangle triangle = new Triangle();

        Shape[] shape = new Shape[3];
        shape[0] = circle;
        shape[1] = rectangle;
        shape[2] = triangle;

        new ShapesTemplate(shape);

//        Graphics2D graphics2D = (Graphics2D);
//        circle.draw();

    }

}
