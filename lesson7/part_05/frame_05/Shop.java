package lesson7.part_05.frame_05;

import lesson7.part_05.frame_05.domain.Customer;
import lesson7.part_05.frame_05.domain.Product;
import lesson7.part_05.frame_05.domain.Transaction;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Shop {

    private ArrayList<? extends Customer> customer;
    private ArrayList<Product> products;
    private ArrayList<Transaction> transactions;
    private int id;

    public Shop(){
        customer = new ArrayList<>();
        products = new ArrayList<>();
        transactions = new ArrayList<>();
        id = 0;
    }

    public ArrayList<? extends Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(ArrayList<? extends Customer> customer) {
        this.customer = customer;
    }

    public ArrayList<? extends Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void sell(Product p, Customer c, int count) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        String date = dateFormat.format(new Date());

        if(count <=  p.getQuantityInStock()){
            Transaction t = new Transaction();

            id++;
            t.setId(id);
            t.setDate(date);
            t.setProduct(p);
            t.setCustomer(c);
            t.setCount(count);
            t.setPrice(p.getPrice());
            t.updateDiscont(count * p.getPrice());
            t.setTotal((count * p.getPrice()) - (count*p.getPrice()) / 100 * t.getDiscont());

            transactions.add(t);
            p.setQuantityInStock(p.getQuantityInStock() - count);
            System.out.println(t.toString());
        }else {
            System.out.println("We don't have this product  ");
        }
    }

    private String setDiscountToPrint(){
        String rezult = "";

        return rezult;
    }

    public ArrayList<? extends Transaction> getTransactions() {
        return transactions;
    }
}