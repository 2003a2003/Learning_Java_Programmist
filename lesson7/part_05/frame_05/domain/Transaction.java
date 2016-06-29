package lesson7.part_05.frame_05.domain;

public class Transaction {

    private String date;
    private Product product;
    private int count;
    private double price;
    private int id = 0;
    private Customer customer;
    private double total;
    private int discont;

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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getDiscont() {
        return discont;
    }

    public void setDiscont(int discont) {
        this.discont = discont;
    }

    public void updateDiscont(double total) {
        if (total < 500) {
            setDiscont(1);
        } else if (total >= 500 && total < 1000) {
            setDiscont(5);
        } else {
            setDiscont(10);
        }
    }

    @Override
    public String toString() {
        return "№: " + id + "| " + date + "| Product: " + product + "| Count: " + count + "| Price: " + price + "| " + customer.getName();
    }
}
