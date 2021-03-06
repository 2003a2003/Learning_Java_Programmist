package lesson3.part_5.frame_8.products;

import lesson3.part_5.frame_8.ingridients.AbstractIngridients;
import lesson3.part_5.frame_8.ingridients.Sugar;
import lesson3.part_5.frame_8.ingridients.TeaGreen;
import lesson3.part_5.frame_8.ingridients.Water;

public class GreenTea extends AbstractProducts {

    public GreenTea(AbstractIngridients[] price) {

        setProductsName("Creen Tea");
        ingridients[0] = addInfridients(new Water(), price, 200);
        ingridients[1] = addInfridients(new TeaGreen(), price, 1);
        ingridients[0] = addInfridients(new Sugar(), price, 40);

    }
}
