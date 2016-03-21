package lesson3.part_5.frame_6.second;

/**
 * Created by otroshenko on 21.03.2016.
 */
public class Ingrid {
    private String name;
    private double price;
    private double coll;

    public Ingrid(String name, double coll) {
        this.name = name;
        this.coll = coll;
    }

    public Ingrid(String name, double price, double coll) {
        this.name = name;
        this.price = price;
        this.coll = coll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getColl() {
        return coll;
    }

    public void setColl(double coll) {
        this.coll = coll;
    }
}
