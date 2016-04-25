package lesson5.part_04.frame_01;

public class Laptops {

    private Brand brand;
    private String model;
    private String description;
    private Categories categories;
    private Color color;
    private int price;
    private int balance;


    public Laptops() {
        this(null,null,null,null,null,0,0);
    }

    public Laptops(Brand brand, String model, String description, Categories categories, Color color,
                   int price, int balance) {
        this.brand = brand;
        this.model = model;
        this.description = description;
        this.categories = categories;
        this.color = color;
        this.price = price;
        this.balance = balance;
    }

    public Laptops(Asus asus){
        this.brand = asus.getBrand();
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getBalance() {
        return balance;
    }

    private void setBalance(int balance) {
        this.balance = balance;
    }

    public void updateBalance(int balance) {
        this.balance += balance;
    }

    public void printLaptops(int index){
        System.out.println(index + ".Brand: " + getBrand() + ", Model: " + getModel() + ", Color: " + getColor() +
        ", Balans: " + getBalance() + ", Price: " + getPrice() + ", Categoriya: " + getCategories());
    }
}
