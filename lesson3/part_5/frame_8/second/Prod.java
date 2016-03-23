package lesson3.part_5.frame_8.second;

/**
 * Created by otroshenko on 21.03.2016.
 */
public class Prod {
    private String name;
    private Ingrid[] ingr;
    private double price;
    private double coll;

    public Prod(String name, Ingrid[] ingr, double price, double coll) {
        this.name = name;
        this.ingr = ingr;
        this.price = price;
        this.coll = coll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ingrid[] getIngr() {
        return ingr;
    }

    public void setIngr(Ingrid[] ingr) {
        this.ingr = ingr;
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
