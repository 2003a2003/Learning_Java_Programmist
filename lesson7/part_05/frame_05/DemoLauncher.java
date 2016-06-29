package lesson7.part_05.frame_05;

import lesson7.part_05.frame_05.domain.Product;
import lesson7.part_05.frame_05.gui.ShopUI;

public class DemoLauncher {

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Shop s = new Shop();
                setUpProducts(s);
                ShopUI shopUI = new ShopUI(s);
            }
        });
    }

    private static void setUpProducts(Shop shop) {

        Product p = new Product();
        p.setName("Asus P5");
        p.setPrice(300);
        p.setQuantityInStock(10);
        shop.addProduct(p);

        p = new Product();
        p.setName("Lenovo V5");
        p.setPrice(350);
        p.setQuantityInStock(5);
        shop.addProduct(p);

        p = new Product();
        p.setName("Fudjitsu R5");
        p.setPrice(500);
        p.setQuantityInStock(6);
        shop.addProduct(p);

        p = new Product();
        p.setName("Acer RT-90");
        p.setPrice(200);
        p.setQuantityInStock(8);
        shop.addProduct(p);
    }
}
