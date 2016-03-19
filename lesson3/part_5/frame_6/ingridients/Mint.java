package lesson3.part_5.frame_6.ingridients;

public class Mint extends AbstractIngridients {
    public Mint() {
        this(1);
    }

    public Mint(int dose) {
        setNameOfIngredient("Mint");
        setPrice(0.3);
        setDose(1);
    }
}
