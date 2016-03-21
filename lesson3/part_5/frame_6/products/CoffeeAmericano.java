package lesson3.part_5.frame_6.products;

import lesson3.part_5.frame_6.ingridients.AbstractIngridients;
import lesson3.part_5.frame_6.ingridients.Coffee;
import lesson3.part_5.frame_6.ingridients.Sugar;
import lesson3.part_5.frame_6.ingridients.Water;

public class CoffeeAmericano extends AbstractProducts {

        public CoffeeAmericano(AbstractIngridients[] price) {
        setProductsName("Americano");
            ingridients[0] = addInfridients(new Water(),price,100);
            ingridients[1] = addInfridients(new Coffee(),price,10);
            ingridients[2] = addInfridients(new Sugar(),price,40);
    }
}
