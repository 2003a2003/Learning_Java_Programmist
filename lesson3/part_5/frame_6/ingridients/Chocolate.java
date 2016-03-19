package lesson3.part_5.frame_6.ingridients;

public class Chocolate extends AbstractIngridients{

    public Chocolate() {
        this(1);
    }

    public Chocolate(int dose) {
        setNameOfIngredient("Chocolate");
        setPrice(2.2);
        setDose(dose);
    }
}
