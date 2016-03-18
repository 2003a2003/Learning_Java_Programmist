package lesson2.part_6.frame_2;

public class Product {

    private String productCode;
    private String name;
    private double price;
    private String specification;


    public Product() {
        this(null, null, 0, null);
    }

    public Product(String productCode, String name, double price, String specification) {
        this.productCode = productCode;
        this.name = name;
        this.price = price;
        this.specification = specification;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public void printProduct() {
        System.out.println("Product code: " + getProductCode() + ", Tovar name: " + getName() + ", Price: " +
                getPrice() + ", Opisanie: " + getSpecification());
    }
}