package lesson3.part_5.frame_6.products;

import lesson3.part_5.frame_6.ingridients.*;

public class Cappuccino extends AbstractProducts {

    public Cappuccino(AbstractIngridients[] price) {
        setProductsName("Cappuccino");
        ingridients[0] = addInfridients(new Water(), price, 100);
        ingridients[1] = addInfridients(new Coffee(), price, 10);
        ingridients[2] = addInfridients(new Milk(), price, 50);
        ingridients[3] = addInfridients(new MilkFoam(), price, 20);
        ingridients[4] = addInfridients(new Sugar(), price, 40);
    }
}
