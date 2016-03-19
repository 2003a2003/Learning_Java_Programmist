package lesson3.part_5.frame_6.products;

import lesson3.part_5.frame_6.ingridients.*;

public class Mokachino extends AbstractProducts {

    public Mokachino() {

        setProductsName("Mokachino ");

        ingridients[0] = new Water();
        ingridients[1] = new Coffee();
        ingridients[2] = new Sugar();
        ingridients[3] = new MilkFoam();
        ingridients[4] = new Chocolate();

        setIngridients(ingridients);
        updateStandartPrice(ingridients);
    }
}
