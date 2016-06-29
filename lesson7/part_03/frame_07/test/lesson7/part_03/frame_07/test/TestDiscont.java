package lesson7.part_03.frame_07.test;

import lesson7.part_03.frame_07.Customer;
import lesson7.part_03.frame_07.Product;
import lesson7.part_03.frame_07.Shop;
import lesson7.part_03.frame_07.Transaction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(JUnit4.class)
public class TestDiscont {

    private Shop shop;
    private Product product;
    private Transaction transaction;

    @Before
    public void init() {
        shop = new Shop();
        Product asus01 = new Product("Asus MT5", 300, 10);
        Product asus02 = new Product("Asus RT06", 150, 5);
        Product lenovo01 = new Product("Lenovo MT5", 500, 8);
        Product lenovo02 = new Product("Lenovo RT05", 1300, 3);

        shop.addProduct(asus01);
        shop.addProduct(asus02);
        shop.addProduct(lenovo01);
        shop.addProduct(lenovo02);

        transaction = new Transaction();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        String date = dateFormat.format(new Date());

        Customer c001 = new Customer();
        c001.setName("Alex");
        c001.setPhoneNumber("558585564");

        int count = 4;

        transaction.setId(1);
        transaction.setDate(date);
        transaction.setProduct(asus01);
        transaction.setCustomer(c001);
        transaction.setCount(count);
        transaction.setPrice(asus01.getPrice());
        transaction.updateDiscont(count * asus01.getPrice());
        transaction.setTotal(count * asus01.getPrice() * transaction.getDiscont());

    }

    @Test
    public void checkDiskont05() {
        int count = transaction.getCount();
        double price = transaction.getPrice();
        double total = count * price;

        //Assert.assertTrue("Diskont 5% not true: " + transaction.getDiscont(), transaction.getDiscont() == 0.95);
        Assert.assertTrue("Diskont 5% not true: ", total*0.95 == transaction.getTotal());
    }

    @Test
    public void checkDiskont10() {
        int count = transaction.getCount();
        double price = transaction.getPrice();
        double total = count * price;

        Assert.assertTrue("Diskont 10% not true: ", total*0.90 == transaction.getTotal());
//        Assert.assertTrue("Diskont 10% not true: " + transaction.getDiscont(), transaction.getDiscont() == 0.90);
    }

//    @Test
//    public void checkDefaltDiscont(){
//        Assert.assertTrue("Discont shouls be 0", transaction.getDiscont() == 0);
//    }
//
//    @Test
//    public void checkSetDiscont(){
//        double discount = 0.90;
//        Assert.assertTrue("Diskont add", transaction.getDiscont() == discount);
//    }
}
