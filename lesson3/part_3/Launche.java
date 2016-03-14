package lesson3.part_3;

public class Launche {

    public static void main(String[] args) {

        Circle circle = new Circle();
        Rectangle rectangle = new Rectangle();
        Triangle triangle = new Triangle();
        Square square = new Square();

        AbstractShape[] shape = new AbstractShape[4];
        shape[0] = circle;
        shape[1] = rectangle;
        shape[2] = triangle;
        shape[3] = square;

        new ShapesTemplate(shape);
    }
}
