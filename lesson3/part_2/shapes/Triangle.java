package lesson3.part_2.shapes;

public class Triangle extends Shape {

    @Override
    public void draw() {
        System.out.print("You see a triangle. ");
    }

    @Override
    public void color(Color color) {
        if (color == Color.BLUE)
            super.color(Color.BLACK);

    }
}