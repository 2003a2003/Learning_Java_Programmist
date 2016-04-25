package lesson5.part_04.frame_03;

public class Acer extends Laptops {

    public Acer(String model, String description, Categories categories, Color color,
                int price, int balance){
        setBrand(Brand.ACER);
        setModel(model);
        setCategories(categories);
        setDescription(description);
        setColor(color);
        setPrice(price);
        updateBalance(balance);
    }

    public Acer(){

    }
}
