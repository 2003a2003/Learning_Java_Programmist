package lesson6.part_03.newRealization;

public class Transaction {


    private String date;
    private Product product;
    private int count;
    private double price;
    private int id = 0;
    private Customer customer;

    public Transaction() {

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "№: " + id + "| " + date + "| Product: " + product + "| Count: " + count + "| Price: " + price + "| " + customer.getName();
    }
}
