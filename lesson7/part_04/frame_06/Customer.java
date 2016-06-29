package lesson7.part_04.frame_06;

import com.sun.deploy.services.*;
import lesson7.part_03.frame_06.program.*;
@Service(name = "start")
public class Customer{

    private String name;
    private String phoneNumber;

    public Customer() {
        name = null;
        phoneNumber = null;
    }

    public Customer(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Customer(String name){
        this.name = name;
        phoneNumber = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void printCustomer(int index) {
        System.out.println(index + ". Customer: " + getName() + ", Phone number : " + getPhoneNumber());
    }
}