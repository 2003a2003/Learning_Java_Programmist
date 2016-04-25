package lesson5.part_04.frame_03;

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
