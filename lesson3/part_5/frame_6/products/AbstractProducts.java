package lesson3.part_5.frame_6.products;

import lesson3.part_5.frame_6.ingridients.*;

public abstract class AbstractProducts {

    private String productsName;
    protected AbstractIngridients[] ingridients = new AbstractIngridients[10];
    private double priceOfProduct;


    //GET - SET
    public String getProductsName() {
        return productsName;
    }

    public void setProductsName(String productsName) {
        this.productsName = productsName;
    }

    public double getPriceOfProduct() {
        return priceOfProduct;
    }

    public void setPriceOfProduct(double priceOfProduct) {
        this.priceOfProduct = priceOfProduct;
    }

    public AbstractIngridients[] getIngridients() {
        return ingridients;
    }

    public void setIngridients(AbstractIngridients[] ingridients) {
        this.ingridients = ingridients;
    }

    // Metods
    public void updateStandartPrice(AbstractIngridients[] ingridients) {
        double price = 0;
        for (AbstractIngridients ingr : ingridients) {
            if (ingr != null) {
                price += ingr.getPrice();
            }
        }
        setPriceOfProduct(price);
    }

    public AbstractIngridients addInfridients(AbstractIngridients name, AbstractIngridients[] price, int dose) {
        double priceOfProducts = 0;
        for (AbstractIngridients i : price) {
            if (i.getNameOfIngredient().equals(name.getClass().getSimpleName())) {
                priceOfProduct += (dose/i.getDose())*i.getPrice();
                return i;
            }
        }
        return null;
    }

}
