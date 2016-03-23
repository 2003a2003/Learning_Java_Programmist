package lesson3.part_5.frame_8;

import lesson3.part_5.frame_8.ingridients.*;
import lesson3.part_5.frame_8.products.*;

public class Menu {

    private AbstractIngridients[] price = new AbstractIngridients[30];
    private AbstractProducts[] productses = new AbstractProducts[30];
    private Services srv;
    private StartDefaultPriceIngridients pr;


    public Menu() {
        srv = new Services();
        pr = new StartDefaultPriceIngridients();
        price = pr.addNewStartDefoultPrice();
        addMenuListProducts();
    }

    public void printMenuProducts(){
        srv.printMenuProducts(productses);
    }

    public void printMenuIngridients(){
        srv.printMenuIngridients(price);
    }

    public void addNewIngridients(String name, int dose, double price){
        srv.addNewIngridients(this.price,name,dose,price);
    }

    public void addMenuListProducts(){
        srv.addMenuListProducts(productses, this.price);
    }

    public void addNewProducts(String name, double price){
        srv.addNewProducts(productses,name,price);
    }
}
