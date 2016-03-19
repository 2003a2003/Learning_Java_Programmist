package lesson3.part_5.frame_6.products;

import lesson3.part_5.frame_6.ingridients.*;

public class GreenTea extends AbstractProducts {
    public GreenTea() {
        setProductsName("Green Tea ");

        ingridients[0] = new Water();
        ingridients[1] = new TeaGreen();
        ingridients[2] = new Sugar();

        setIngridients(ingridients);
        updateStandartPrice(ingridients);
    }
}
