package lesson3.part_5.frame_6.products;

import lesson3.part_5.frame_6.ingridients.*;

public class Cappuccino extends AbstractProducts {

    public Cappuccino() {

        setProductsName("Cappuccino ");

        ingridients[0] = new Water();
        ingridients[1] = new Coffee();
        ingridients[2] = new Sugar();
        ingridients[3] = new MilkFoam();

        setIngridients(ingridients);
        updateStandartPrice(ingridients);
    }
}
