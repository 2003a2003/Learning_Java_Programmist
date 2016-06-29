package lesson7.part_04.frame_04;

public class Customer {

    private String name;
    private String phoneNumber;

    public Customer() {
        name = null;
        phoneNumber = null;
        System.out.println("Constructor has 0 parametr");
    }

    public Customer(String name, String phoneNumber) {
        System.out.println("Constructor has 2 parametr");
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Customer(String name){
        this.name = name;
        phoneNumber = null;
        System.out.println("Constructor has 1 parametr");
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