package lesson2.part_6.frame_2;

public class Shop {

    private Salling[] sllng;
    private Product[] prd;
    private Customer[] cstmr;

    private int number;
    private double price;

    private int cstmrTail;
    private int sllngTail;
    private int prdTail;

    private int sizeFirstCreateBase;

    public Shop() {
        sizeFirstCreateBase = 20;
        sllng = new Salling[sizeFirstCreateBase];
        updadeSllngTail();
        prd = new Product[sizeFirstCreateBase];
        updadePrdTail();
        cstmr = new Customer[sizeFirstCreateBase];
        updadeCstmeTail();

    }

    public void updadeCstmeTail() {
        int tail = 0;
        if (cstmr != null) {
            for (Customer c : cstmr) {
                if (c != null) {
                    tail++;
                }
            }
        }
        cstmrTail = tail;
    }

    public void updadeSllngTail() {
        int tail = 0;
        if (sllng != null) {
            for (Salling s : sllng) {
                if (s != null) {
                    tail++;
                }
            }
        }
        sllngTail = tail;
    }

    public void updadePrdTail() {
        int tail = 0;
        if (prd != null) {
            for (Product p : prd) {
                if (p != null) {
                    tail++;
                }
            }
        }
        prdTail = tail;
    }

    public void cstmrAdd(String firstName, String secondName, String email, String phone, String delivAddress) {
        if (cstmrTail == cstmr.length) {
            //Create New arrays
        } else {
            cstmr[cstmrTail] = new Customer();
            cstmr[cstmrTail].setFirstName(firstName);
            cstmr[cstmrTail].setSecondName(secondName);
            cstmr[cstmrTail].setEmail(email);
            cstmr[cstmrTail].setPhoneNumber(phone);
            cstmr[cstmrTail].setDeliveryAddress(delivAddress);
        }
        updadeCstmeTail();
    }

    public void prdAdd(String productCode, String name, double price, String specification) {
        if (prdTail == prd.length) {
            //Create New arrays
        } else {
            prd[prdTail] = new Product();
            prd[prdTail].setProductCode(productCode);
            prd[prdTail].setName(name);
            prd[prdTail].setPrice(price);
            prd[prdTail].setSpecification(specification);
        }
        updadePrdTail();
    }

    public void sllngAdd(Product prd, Customer cstmr, int number, String note) {
        if (sllngTail == sllng.length) {
            //Create New arrays
        } else {
            sllng[sllngTail] = new Salling();
            sllng[sllngTail].setPrd(prd);
            sllng[sllngTail].setCstmr(cstmr);
            sllng[sllngTail].setNumber(number);
            sllng[sllngTail].setPrice(prd.getPrice());
            sllng[sllngTail].setAllPrice(prd.getPrice()*number);
            sllng[sllngTail].setNote(note);
        }
        updadeSllngTail();
    }

    public void printProduct() {
        if (prd != null) {
            for (Product p : prd) {
                if (p != null) {
                    p.printProduct();
                }
            }
        }
    }

    public void printCustomer() {
        if (cstmr != null) {
            for (Customer c : cstmr) {
                if (c != null) {
                    c.printCustomer();
                }
            }
        }
    }

    public void printSalling() {
        if (sllng != null) {
            for (Salling s : sllng) {
                if (s != null) {
                    s.printSalling();
                }
            }
        }
    }

    public Product getProduct(int index){
        if(index < prdTail){
            return prd[index];
        }else{
            System.out.println("You chose not true the product.....");
        }
        return null;
    }

    public Customer getCustomer(int index){
        if(index < cstmrTail){
            return cstmr[index];
        }else{
            System.out.println("You need to  choose a buyer ....");
        }
        return null;
    }

    public Salling getSalling(int index){
        if(index < sllngTail){
            return sllng[index];
        }else{
            System.out.println("You don't have sales....");
        }
        return null;
    }
}
