package lesson3.part_5.frame_6.ingridients;

public abstract class AbstractIngridients {

    private String nameOfIngredient;
    private double price;
    private int dose;

    public AbstractIngridients(){
    }

    public AbstractIngridients(String nameOfIngredient, int dose, double price){
        this.nameOfIngredient = nameOfIngredient;
        this.price = price;
        this.dose = dose;
    }

    public int getDose() {
        return dose;
    }

    public void setDose(int dose) {
        this.dose = dose;
    }

    public String getNameOfIngredient() {
        return nameOfIngredient;
    }

    public void setNameOfIngredient(String nameOfIngredient) {
        this.nameOfIngredient = nameOfIngredient;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}