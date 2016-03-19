package lesson3.part_5.frame_6.ingridients;

public class Coffee extends AbstractIngridients{

    public Coffee() {
        this(1);
    }

    public Coffee(int dose) {
        setNameOfIngredient("Coffee");
        setPrice(2);
        setDose(dose);
    }
}