package lesson3.part_5.frame_8;

import lesson3.part_5.frame_8.ingridients.*;
import lesson3.part_5.frame_8.products.*;

public class Services {

    public void addMenuListProducts(AbstractProducts[] productses, AbstractIngridients[] price){
        productses[0] = new BlackCoffee(price);
        productses[1] = new CoffeeWithMilk(price);
        productses[2] = new CoffeeAmericano(price);
        productses[3] = new Cappuccino(price);
        productses[4] = new Mokachino(price);
        productses[5] = new BlackTea(price);
        productses[6] = new GreenTea(price);
        productses[7] = new GreenTeaWithBergamot(price);
    }

    public void printMenuProducts(AbstractProducts[] productses) {

        System.out.println("----------------------------------MENU PRODUCTES------------------------------------");
        System.out.printf("%-3s%-28s%-45s%-11s%n", "| №", "| Products", "| Ingridients ", "| Price");
        System.out.println("------------------------------------------------------------------------------------");

        for (int i = 0; i < productses.length; i++) {
            if (productses[i] != null) {
                System.out.printf("%-4s%-28s%-45s%-11s%n", "| " + (i + 1), "| " + productses[i].getProductsName(),
                        "| " + printProductIngridients(productses[i].getIngridients()),
                        "| " + productses[i].getPriceOfProduct());
//                System.out.print("| " + (i+1) + ". " + productses[i].getProductsName());
//                printProductIngridients(productses[i].getIngridients());
//                System.out.println(productses[i].getPriceOfProduct());

            }
        }
        System.out.println("------------------------------------------------------------------------------------");
    }

    public String printProductIngridients(AbstractIngridients[] ingridientses) {
        String str = "";
        for (int i = 0; i < ingridientses.length; i++) {
            if (ingridientses[i] != null) {
                str = str + " " + ingridientses[i].getNameOfIngredient();
                //System.out.print(ingridientses[i].getNameOfIngredient() + " |");
            }
        }
        return str;
    }

    public double getPriceProdects(AbstractIngridients[] ingridientses) {
        double price = 0;
        for (AbstractIngridients ingr : ingridientses) {
            if (ingr != null) {
                price += (ingr.getPrice() * ingr.getDose());
            }
        }
        return price;
    }

    public void printMenuIngridients(AbstractIngridients[] ingridientses) {

        System.out.println("------------MENU INGRIDIENTS-----------");
        System.out.printf("%-3s%-28s%-11s%n", "| №", "| Ingridient", "| Price");
        System.out.println("---------------------------------------");

        for (int i = 0; i < ingridientses.length; i++) {
            if (ingridientses[i] != null) {
                System.out.printf("%-4s%-28s%-11s%n", "| " + (i + 1), "| " + ingridientses[i].getNameOfIngredient(),
                        "| " + ingridientses[i].getPrice());
            }
        }
        System.out.println("---------------------------------------");
    }

    public void addNewIngridients(AbstractIngridients[] i, String name, int dose, double price) {
        int tail = updateTeilIngridient(i);
        if (tail < i.length) {
            i[tail] = new NewSomeIngridients();
            i[tail].setNameOfIngredient(name);
            i[tail].setDose(dose);
            i[tail].setPrice(price);
        } else {
            //create new array + add
            //addOneIngridients();
        }
    }

    private int updateTeilIngridient(AbstractIngridients[] i) {
        int t = 0;
        for (AbstractIngridients ingr : i) {
            if (ingr != null) {
                t++;
            }
        }
        return t;
    }

    public void addNewProducts(AbstractProducts[] product, String name, double price) {
        int t = updateTeilProducts(product);
        if(t < product.length){
            product[t] = new NewSomeProducte();
            product[t].setProductsName(name);
            product[t].setPriceOfProduct(price);

        }else {
            //create new array + add
            //addOneIngridients();
        }

    }

    private int updateTeilProducts(AbstractProducts[] product) {
        int t = 0;
        for (AbstractProducts p : product) {
            if (p != null) {
                t++;
            }
        }
        return t;
    }
}
