package lesson3.part_5.frame_6.products;

import lesson3.part_5.frame_6.ingridients.*;

public class BlackCoffee extends AbstractProducts{
    public BlackCoffee(){
        setProductsName("Black Coffee ");

        ingridients[0] = new Water();
        ingridients[1] = new Coffee();
        ingridients[2] = new Sugar();

        setIngridients(ingridients);
        updateStandartPrice(ingridients);
    }
}