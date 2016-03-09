package lesson2.part_6.frame_4;

public class Transaction {

    private int day;
    private Customer customer;
    private Laptops laptops;

    private int number;
    private int price;
    private int total;

    public Transaction() {
        customer = null;
        laptops = null;
        number = 0;
        price = 0;
        total = 0;
    }

    public Transaction(Customer customer, Laptops laptops,  int number) {
        this.laptops = laptops;
        this.customer = customer;
        this.number = number;
        price = laptops.getPrice();
        total = price * number;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public Laptops getLaptops() {
        return laptops;
    }

    public void setLaptops(Laptops laptops) {
        this.laptops = laptops;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
        price = laptops.getPrice();
        total = price * number;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void printTransaction(int month, int day, int index) {
        System.out.println(index + ". Transaction day: " + day + ", month: " +month + ", Laptop: " + getLaptops().getClass().getSimpleName() +
                ", Customer: " + customer.getName() + ", Kollichestvo: " + getNumber() + ", Price: " + getPrice() +
                ", All price: " + getTotal());
    }
}
