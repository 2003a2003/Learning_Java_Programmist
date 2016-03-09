package lesson2.part_6.frame_4;

public class Customer {
    private String name;
    private String phoneNumber;
    private String deliveryAddress;

    public Customer() {
        this(null, null, null);
    }

    public Customer(String name, String phoneNumber, String deliveryAddress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.deliveryAddress = deliveryAddress;
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

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public void printCustomer(int index) {
        System.out.println(index + ". Customer: " + getName() + ", Phone number : " + getPhoneNumber() +
                ", Delivery address: " + getDeliveryAddress());
    }
}