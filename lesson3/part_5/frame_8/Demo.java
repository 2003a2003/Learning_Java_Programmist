package lesson3.part_5.frame_8;

public class Demo {
    public static void main(String[] args) {
        Menu m = new Menu();
        m.printMenuIngridients();
        m.printMenuProducts();
        m.addNewIngridients("Koritsy", 20,0.8);
        m.printMenuIngridients();
        m.addNewProducts("Baton", 1.8);
        m.printMenuProducts();

    }
}