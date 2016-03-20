package lesson3.part_5.frame_6;

import lesson3.part_5.frame_6.products.*;

public class Transactions {

    private int numberTransaction;
    private AbstractProducts[] product;
    private double totalPrice;

    public Transactions(int numberTransaction, AbstractProducts[] product, double totalPrice) {
        this.numberTransaction = numberTransaction;
        this.product = product;
        this.totalPrice = totalPrice;
    }
}
