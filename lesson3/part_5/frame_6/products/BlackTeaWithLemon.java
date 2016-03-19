package lesson3.part_5.frame_6.products;

import lesson3.part_5.frame_6.ingridients.*;

public class BlackTeaWithLemon extends AbstractProducts {

    public BlackTeaWithLemon() {
        setProductsName("Black tea with lemon ");

        ingridients[0] = new Water();
        ingridients[1] = new TeaBlack();
        ingridients[2] = new Sugar();
        ingridients[3] = new Lemon();

        setIngridients(ingridients);
        updateStandartPrice(ingridients);
    }
}
