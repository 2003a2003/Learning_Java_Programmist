package lesson5.part_04.frame_04;

import java.util.Date;

public class Transaction {

    private Date date;
    private Product product;
    private int count;
    private double price;

    public Transaction() {

    }

    public Transaction(Date date, Product product, int count, double price) {
        this.date = date;
        this.product = product;
        this.count = count;
        this.price = price;
    }

    public void setDate(Date date) {
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

    @Override
    public String toString() {
        return "transaction: " + date + ", Product: " + product + ", Count: " + count + ", Price: " + price;
    }
}
