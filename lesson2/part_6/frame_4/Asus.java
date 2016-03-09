package lesson2.part_6.frame_4;

public class Asus extends Laptops {

    public Asus(String model, String description, Categories categories, Color color,
                int price, int balance){
        setBrand(Brand.ASUS);
        setModel(model);
        setCategories(categories);
        setDescription(description);
        setColor(color);
        setPrice(price);
        updateBalance(balance);
    }

    public Asus(){

    }
}
