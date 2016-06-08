package lesson6.part_03;

public class Transaction {

    private String date;
    private Product product;
    private int count;
    private double price;
    private int id = 0;
    private Customer customer;

    public Transaction() {
    }

    public String[] columnNames = {"№", "Date", "Product", "Count", "Price", "Customer"};

    public void setDate(String date) {
        this.date = date;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setCount(int count) {
        this.count = count;
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

    public String getDate() {
        return date;
    }

    public Product getProduct() {
        return product;
    }

    public int getCount() {
        return count;
    }

    public double getPrice() {
        return price;
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
