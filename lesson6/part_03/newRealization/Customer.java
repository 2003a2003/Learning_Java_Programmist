package lesson6.part_03.newRealization;

public class Customer {

    private String firstName;
    private String secondName;
    private String phoneNumber;

    public Customer() {
        this(null, null, null);
    }

    public Customer(String firstName, String secondName, String phoneNumber) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.phoneNumber = phoneNumber;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void printCustomer(int index) {
        System.out.println(index + ". Customer: " + getFirstName() +
                " " + getSecondName() + ", Phone number : " + getPhoneNumber());
    }
}