package lesson3.part_5.frame_8.products;

import lesson3.part_5.frame_8.ingridients.*;

public class Mokachino extends AbstractProducts {

    public Mokachino(AbstractIngridients[] price) {
        setProductsName("Mokacino");
        ingridients[0] = addInfridients(new Water(),price,100);
        ingridients[1] = addInfridients(new Coffee(),price,10);
        ingridients[2] = addInfridients(new Milk(), price, 50);
        ingridients[3] = addInfridients(new MilkFoam(),price,20);
        ingridients[4] = addInfridients(new Sugar(),price,40);
        ingridients[5] = addInfridients(new Chocolate(),price,20);
    }
}
