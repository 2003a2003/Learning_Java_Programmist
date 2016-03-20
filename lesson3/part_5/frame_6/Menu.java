package lesson3.part_5.frame_6;

import lesson3.part_5.frame_6.ingridients.*;
import lesson3.part_5.frame_6.products.*;

public class Menu {

    private AbstractIngridients[] ingridientses = new AbstractIngridients[30];
    private AbstractProducts[] productses = new AbstractProducts[30];
    private Services srv;
    private Transactions[] transaction;
    private int viewSale;
    private int numberTransactions;


    public Menu() {
        srv = new Services();
        addMenuListProducts();
        addMenuListIngridients();
        transaction = new Transactions[20];
        numberTransactions = 0;
        //srv.addMenuListIngridients(ingridientses);
    }

    public void printMenuProducts(){
        srv.printMenuProducts(productses);
    }

    public void printMenuIngridients(){
        srv.printMenuIngridients(ingridientses);
    }

    public void addMenuListProducts(){
        srv.addMenuListProducts(productses);
    }

    public void addMenuListIngridients(){
        srv.addMenuListIngridients(ingridientses);
    }

    public void chengePriceIngridients(){

    }

}
