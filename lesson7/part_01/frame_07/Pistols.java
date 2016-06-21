package lesson7.part_01.frame_07;

public class Pistols implements Comparable<Pistols>{

    public int id;
    public String model;
    public double price;

    public Pistols() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return getId() + " " + getModel() + " " + getPrice();
    }

    @Override
    public int compareTo(Pistols o) {
        return this.getModel().compareTo(o.getModel());
    }
}
