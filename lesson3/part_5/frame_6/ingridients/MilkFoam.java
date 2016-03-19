package lesson3.part_5.frame_6.ingridients;

public class MilkFoam extends AbstractIngridients {

    public MilkFoam() {
        this(1);
    }

    public MilkFoam(int dose) {
        setNameOfIngredient("Milk Foam");
        setPrice(0.8);
        setDose(dose);
    }
}
