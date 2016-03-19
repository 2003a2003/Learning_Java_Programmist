package lesson3.part_5.frame_6.ingridients;

public class Sugar extends AbstractIngridients{
    public Sugar() {
        this(1);
    }

    public Sugar(int dose) {
        setNameOfIngredient("Shuar");
        setPrice(0.2);
        setDose(dose);
    }
}
