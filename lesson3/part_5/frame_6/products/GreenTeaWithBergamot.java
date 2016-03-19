package lesson3.part_5.frame_6.products;

import lesson3.part_5.frame_6.ingridients.*;

public class GreenTeaWithBergamot extends AbstractProducts {
    public GreenTeaWithBergamot(){
        setProductsName("Green Tea with Bergamot ");

        ingridients[0] = new Water();
        ingridients[1] = new TeaGreebWithBergamot();
        ingridients[2] = new Sugar();

        setIngridients(ingridients);
        updateStandartPrice(ingridients);
    }
}
