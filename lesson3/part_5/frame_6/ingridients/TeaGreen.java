package lesson3.part_5.frame_6.ingridients;

public class TeaGreen extends AbstractIngridients{
    public TeaGreen() {
       this(1);
    }

    public TeaGreen(int dose) {
        setNameOfIngredient("Green Tea");
        setPrice(1);
        setDose(dose);
    }
}