package lesson6.part_03;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Shop {

    private ArrayList<Product> products;
    private ArrayList<Transaction> transactions;
    private ArrayList<Customer> customers;
    private int id = 0;

    public Shop() {
        products = new ArrayList<>();
        transactions = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void sell(Product p, Customer c, int count) {

        //String[] columnNames = {"№", "Date", "Product", "Count", "Price", "Customer"};

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

            //Object[][] data = {new Object[id], date, p.getName(), count, p.getPrice(), c.getName()};

            p.setQuantityInStock(p.getQuantityInStock() - count);
            System.out.println(t.toString());
        }else {
            System.out.println("We don't have this product  ");
        }
    }
}
