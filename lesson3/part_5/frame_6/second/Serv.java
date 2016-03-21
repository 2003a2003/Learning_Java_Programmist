package lesson3.part_5.frame_6.second;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Serv {
    public void addDeoultIngrid(Ingrid[] ingr) {
        ingr[0] = new Ingrid("Water", 0.5, 1);
        ingr[1] = new Ingrid("Sugar", 0.4, 1);
        ingr[2] = new Ingrid("Coffee", 1, 1);
        ingr[3] = new Ingrid("Black Tea", 0.8, 1);
    }

    public void printIngrid(Ingrid[] ingr) {
        System.out.println("Print Ingridient: ");
        for (Ingrid i : ingr) {
            if (i != null) {
                System.out.println("Ingridient: " + i.getName() + ", Price: " + i.getPrice());
            }
        }
    }

    public void addDefaultProduct(Prod[] prod, Ingrid[] ingr) {

        prod[0] = addOneProduct(ingr, "Coffee", new Ingrid[]{new Ingrid("Water", 1), new Ingrid("Coffee", 1),
                new Ingrid("Sugar", 1)}, 1);
        prod[1] = addOneProduct(ingr, "Black Tea", new Ingrid[]{new Ingrid("Water", 1), new Ingrid("Black Tea", 1),
                new Ingrid("Sugar", 1)}, 1);
    }

    private Prod addOneProduct(Ingrid[] ingr, String name, Ingrid[] ingrids, int coll) {
        double price = addTotalPrice(ingrids, ingr);
        Prod prod = new Prod(name, ingrids, price * coll, coll);
        return prod;
    }


    private double addTotalPrice(Ingrid[] temp, Ingrid[] pr) {
        double price = 0;

        for (Ingrid i : temp) {
            if (i != null) {
                for (Ingrid pri : pr) {
                    if (pri != null) {
                        if (pri.getName().equals(i.getName())) {
                            price += (pri.getPrice() * i.getColl());
                            price = new BigDecimal(price).setScale(4, RoundingMode.HALF_UP).doubleValue();
                        }
                    }
                }
            }
        }
        return price;
    }

    public void printProduct(Prod[] prod) {
        System.out.println("Product Menu:");
        for (Prod p : prod) {
            if (p != null) {
                System.out.print("Product: " + p.getName() + "[ ");
                printInfridInProduct(p.getIngr());
                System.out.println("], Price: " + p.getPrice());
            }
        }
    }

    private void printInfridInProduct(Ingrid[] ingr) {
        for (Ingrid i : ingr) {
            System.out.print(i.getName() + " ");
        }

    }
}