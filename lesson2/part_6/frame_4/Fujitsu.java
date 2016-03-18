package lesson2.part_6.frame_4;

public class Fujitsu extends Laptops {

    public Fujitsu(String model, String description, Categories categories, Color color,
                int price, int balance){
        setBrand(Brand.FUJITSU);
        setModel(model);
        setCategories(categories);
        setDescription(description);
        setColor(color);
        setPrice(price);
        updateBalance(balance);
    }

    public Fujitsu(){

    }
}
