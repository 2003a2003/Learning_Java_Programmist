package lesson3.part_5.frame_6.ingridients;

public abstract class AbstractIngridients {
    private String nameOfIngredient;
    private double price;

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