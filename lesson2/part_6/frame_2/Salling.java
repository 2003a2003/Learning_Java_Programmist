package lesson2.part_6.frame_2;

public class Salling {

    private Product prd;
    private Customer cstmr;
    private int number;
    private double price;
    private double allPrice;
    private String note;

    public Salling() {
        this(null, null, 0, 0, null);
    }

    public Salling(Product prd, Customer cstmr, int number, double price, String note) {
        this.prd = prd;
        this.cstmr = cstmr;
        this.number = number;
        this.price = price;
        this.note = note;
        allPrice = 0;
    }

    public Product getPrd() {
        return prd;
    }

    public void setPrd(Product prd) {
        this.prd = prd;
    }

    public Customer getCstmr() {
        return cstmr;
    }

    public void setCstmr(Customer cstmr) {
        this.cstmr = cstmr;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getAllPrice() {
        return allPrice;
    }

    public void setAllPrice(double allPrice) {
        this.allPrice = allPrice;
    }

    public void printSalling(){
        System.out.println("Salling product: " + getPrd().getName() + ", Customer: " +
                getCstmr().getFirstName() + " " +getCstmr().getSecondName() + " " + ", Kollichestvo: " + getNumber() +
                ", Price: " + getPrice() +
                ", All price: " + getAllPrice() + ", Note: " + getNote());
    }
}