package lesson5.part_04.frame_04;

import java.util.ArrayList;

public class Shop {

    private ArrayList<Product> products;
    private ArrayList<Transaction> transactions;
    private ArrayList<Customer> customers;

    public Shop(){
        products = new ArrayList<>();
        transactions = new ArrayList<>();
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    public void addTransaction(Transaction transaction){
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

}
