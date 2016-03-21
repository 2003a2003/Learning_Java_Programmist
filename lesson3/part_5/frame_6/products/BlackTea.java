package lesson3.part_5.frame_6.products;

import lesson3.part_5.frame_6.ingridients.AbstractIngridients;
import lesson3.part_5.frame_6.ingridients.Sugar;
import lesson3.part_5.frame_6.ingridients.TeaBlack;
import lesson3.part_5.frame_6.ingridients.Water;

public class BlackTea extends AbstractProducts{

    public BlackTea(AbstractIngridients[] price) {
        setProductsName("Black Tea");
        ingridients[0] = addInfridients(new Water(),price,200);
        ingridients[1] = addInfridients(new TeaBlack(),price,1);
        ingridients[0] = addInfridients(new Sugar(),price,40);
    }
}
