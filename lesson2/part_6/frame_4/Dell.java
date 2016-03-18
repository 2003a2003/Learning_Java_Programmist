package lesson2.part_6.frame_4;

public class Dell extends Laptops {

    public Dell(String model, String description, Categories categories, Color color,
                int price, int balance){
        setBrand(Brand.DELL);
        setModel(model);
        setCategories(categories);
        setDescription(description);
        setColor(color);
        setPrice(price);
        updateBalance(balance);
    }

    public Dell(){

    }
}
