package lesson6.part_03.newRealization;

import java.util.ArrayList;

public class Shop {

    private ArrayList<Customer> customer;


    public Shop(){
        customer = new ArrayList<>();
    }


    public ArrayList<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(ArrayList<Customer> customer) {
        this.customer = customer;
    }
}
