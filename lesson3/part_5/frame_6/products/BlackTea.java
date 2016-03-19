package lesson3.part_5.frame_6.products;

import lesson3.part_5.frame_6.ingridients.*;

public class BlackTea extends AbstractProducts{

    public BlackTea(){
        setProductsName("Black Tea ");

        ingridients[0] = new Water();
        ingridients[1] = new TeaBlack();
        ingridients[2] = new Sugar();
        setIngridients(ingridients);

        updateStandartPrice(ingridients);
    }
}
