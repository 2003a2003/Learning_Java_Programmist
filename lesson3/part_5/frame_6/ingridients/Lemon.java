package lesson3.part_5.frame_6.ingridients;

public class Lemon extends AbstractIngridients{
    public Lemon() {
        this(1);
    }

    public Lemon(int dose) {
        setNameOfIngredient("Lemon");
        setPrice(0.2);
        setDose(dose);
    }
}
