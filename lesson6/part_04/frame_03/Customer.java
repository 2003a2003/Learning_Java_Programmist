package lesson6.part_04.frame_03;

public class Customer {

    private String name;
    private String phoneNumber;

    public Customer() {
        this(null, null);
    }

    public Customer(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
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