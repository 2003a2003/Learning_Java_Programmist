package lesson3.part_2.shapes;

public class Launche {

    public static void main(String[] args) {

        Circle circle = new Circle();
        Rectangle rectangle = new Rectangle();

        Child child = new Child();

        child.drow(circle);
        child.drow(rectangle);
        child.drow(new Triangle());
        child.drow(new Shape());

    }

}
