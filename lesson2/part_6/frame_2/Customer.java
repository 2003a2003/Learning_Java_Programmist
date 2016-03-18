package lesson2.part_6.frame_2;

public class Customer {
    private String firstName;
    private String secondName;
    private String email;
    private String phoneNumber;
    private String deliveryAddress;

    public Customer() {
        this(null, null, null, null, null);
    }

    public Customer(String firstName, String secondName, String email, String phoneNumber, String deliveryAddress) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.deliveryAddress = deliveryAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public void printCustomer() {
        System.out.println("Customer: " + getFirstName() + " " + getSecondName() + ", Phone number : "
                + getPhoneNumber() + ", Mail: " + getEmail() + ", Delivery address: " + getDeliveryAddress());
    }
}