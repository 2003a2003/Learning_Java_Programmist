package lesson7.part_01.frame_06;

public class Pistols {

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
}
