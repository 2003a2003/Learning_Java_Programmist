package lesson3.part_5.frame_6.second;

/**
 * Created by otroshenko on 21.03.2016.
 */
public class Menu {
    private Ingrid[] ingr;
    private Prod[] prod;
    private Serv serv;

    public Menu() {
        ingr = new Ingrid[5];
        prod = new Prod[5];
        serv = new Serv();
    }

    public void addDeoultIngrid(){
        serv.addDeoultIngrid(ingr);
    }

    public Ingrid[] getIngr() {
        return ingr;
    }

    public void setIngr(Ingrid[] ingr) {
        this.ingr = ingr;
    }

    public Prod[] getProd() {
        return prod;
    }

    public void setProd(Prod[] prod) {
        this.prod = prod;
    }

    public void printIngrid(){
        serv.printIngrid(ingr);
    }

    public void addDefaultProduct(){
        serv.addDefaultProduct(prod, ingr);
    }

    public void printProduct(){
        serv.printProduct(prod);
    }

}
