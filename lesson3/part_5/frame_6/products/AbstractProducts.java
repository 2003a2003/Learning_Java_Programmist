package lesson3.part_5.frame_6.products;

import lesson3.part_5.frame_6.ingridients.AbstractIngridients;

public abstract class AbstractProducts {

    private String productsName;
    protected AbstractIngridients[] ingridients = new AbstractIngridients[10];
    private double priceOfProduct;

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

    public void updateStandartPrice(AbstractIngridients[] ingridients){
        double price = 0;
        for(AbstractIngridients ingr : ingridients){
            if (ingr !=null){
                price += (ingr.getPrice()*ingr.getDose());
            }
        }
        setPriceOfProduct(price);
    }

}
