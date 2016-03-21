package lesson3.part_5.frame_6.products;

import lesson3.part_5.frame_6.ingridients.AbstractIngridients;
import lesson3.part_5.frame_6.ingridients.Coffee;
import lesson3.part_5.frame_6.ingridients.Sugar;
import lesson3.part_5.frame_6.ingridients.Water;

public class BlackCoffee extends AbstractProducts{

    public BlackCoffee(AbstractIngridients[] price) {
        setProductsName("Black Coffee");
        ingridients[0] = addInfridients(new Coffee(),price,10);
        ingridients[1] = addInfridients(new Water(),price,50);
        ingridients[2] = addInfridients(new Sugar(),price,20);
    }
}
