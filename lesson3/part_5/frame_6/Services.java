package lesson3.part_5.frame_6;

import lesson3.part_5.frame_6.ingridients.*;
import lesson3.part_5.frame_6.products.*;

public class Services {


    public void addMenuListProducts(AbstractProducts[] productses, AbstractIngridients[] price){
//        productses[0] = new BlackCoffee(price);
//        productses[1] = new CoffeeWithMilk(price);
//        productses[2] = new CoffeeAmericano();
//        productses[3] = new Cappuccino();
//        productses[4] = new Mokachino();
//
//        productses[5] = new BlackTea();
//        productses[6] = new BlackTeaWithLemon();
//        productses[7] = new GreenTea();
//        productses[8] = new GreenTeaWithBergamot();
    }

    public void printMenuProducts(AbstractProducts[] productses) {

        System.out.println("----------------------------------MENU PRODUCTES------------------------------------");
        System.out.printf("%-3s%-28s%-45s%-11s%n", "| №", "| Products", "| Ingridients ", "| Price");
        System.out.println("------------------------------------------------------------------------------------");

        for (int i = 0; i < productses.length; i++) {
            if (productses[i] != null) {
                System.out.printf("%-4s%-28s%-45s%-11s%n", "| " + (i + 1), "| " + productses[i].getProductsName(),
                        "| " + printProductIngridients(productses[i].getIngridients()),
                        "| " + productses[i].getPriceOfProduct() + " |");
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
                        "| " + ingridientses[i].getPrice() + " |");
            }
        }
        System.out.println("---------------------------------------");
    }

    public void addNewIngridients(AbstractIngridients[] i, String name, int dose, double price) {
        int tail = updateTeil(i);
        if (tail < i.length) {
            i[tail] = new NewSomeIngridients();
            i[tail].setNameOfIngredient(name);
            i[tail].setDose(dose);
            i[tail].setPrice(price);
            tail++;
        } else {
            //create new array + add
            //addOneIngridients();
        }
    }

    private int updateTeil(AbstractIngridients[] i) {
        int t = 0;
        for (AbstractIngridients ingr : i) {
            if (ingr != null) {
                t++;
            }
        }
        return t;
    }
}
