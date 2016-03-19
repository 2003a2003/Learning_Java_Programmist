package lesson3.part_5.frame_6.ingridients;

public class Milk extends AbstractIngridients {
    public Milk() {
        this(1);
    }

    public Milk(int dose) {
        setNameOfIngredient("Milk");
        setPrice(0.5);
        setDose(dose);
    }
}
