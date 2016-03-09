package lesson2.part_6.frame_4;

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
