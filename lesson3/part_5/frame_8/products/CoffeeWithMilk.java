package lesson3.part_5.frame_8.products;

import lesson3.part_5.frame_8.ingridients.*;

public class CoffeeWithMilk extends AbstractProducts{

    public CoffeeWithMilk(AbstractIngridients[] price) {
        setProductsName("Coffee with Milk");
        ingridients[0] = addInfridients(new Coffee(),price,10);
        ingridients[1] = addInfridients(new Water(),price,50);
        ingridients[2] = addInfridients(new Milk(), price, 50);
        ingridients[3] = addInfridients(new Sugar(),price,40);
    }
}
