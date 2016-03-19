package lesson3.part_5.frame_6.products;

import lesson3.part_5.frame_6.ingridients.*;

public class CoffeeWithMilk extends AbstractProducts{

    public CoffeeWithMilk() {
        setProductsName("Black Coffee whis Milk ");

        ingridients[0] = new Water();
        ingridients[1] = new Coffee();
        ingridients[2] = new Milk();
        ingridients[3] = new Sugar();

        setIngridients(ingridients);
        updateStandartPrice(ingridients);
    }

}
