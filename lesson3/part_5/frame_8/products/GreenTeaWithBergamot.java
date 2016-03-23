package lesson3.part_5.frame_8.products;

import lesson3.part_5.frame_8.ingridients.AbstractIngridients;
import lesson3.part_5.frame_8.ingridients.Sugar;
import lesson3.part_5.frame_8.ingridients.TeaGreebWithBergamot;
import lesson3.part_5.frame_8.ingridients.Water;

public class GreenTeaWithBergamot extends AbstractProducts {

    public GreenTeaWithBergamot(AbstractIngridients[] price) {
        setProductsName("Creen Tea with Bergamot");
        ingridients[0] = addInfridients(new Water(), price, 200);
        ingridients[1] = addInfridients(new TeaGreebWithBergamot(), price, 1);
        ingridients[0] = addInfridients(new Sugar(), price, 40);
    }
}

