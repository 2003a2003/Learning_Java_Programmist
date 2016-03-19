package lesson3.part_5.frame_6.ingridients;

public class Water extends AbstractIngridients{

    public Water() {
        this(1);
    }

    public Water(int dose) {
        setNameOfIngredient("Water");
        setPrice(0.3);
        setDose(dose);
    }
}
