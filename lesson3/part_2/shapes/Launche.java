package lesson3.part_2.shapes;

public class Launche {

    public static void main(String[] args) {

        Circle circle = new Circle();
        Rectangle rectangle = new Rectangle();
        Triangle triangle = new Triangle();

        circle.draw();
        circle.color(Color.BLACK);
        rectangle.draw();
        rectangle.color(Color.RED);
        triangle.draw();
        triangle.color(Color.BLUE);

    }

}
