package lesson3.part_3;

public class Launche {

    public static void main(String[] args) {

        Circle circle = new Circle();
        Rectangle rectangle = new Rectangle();
        Triangle triangle = new Triangle();
        Square square = new Square();

        Drawable[] shape = new Drawable[4];
        shape[0] = circle;
        shape[1] = rectangle;
        shape[2] = triangle;
        shape[3] = square;
        if(circle instanceof Drawable){
            System.out.println("+++++++++++++++++++++++");
        }

        new ShapesTemplate(shape);
    }
}
