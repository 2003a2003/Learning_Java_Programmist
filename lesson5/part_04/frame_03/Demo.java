package lesson5.part_04.frame_03;

public class Demo {
    public static void main(String[] args) {
        //Start shop
        Shop shop = new Shop();

//        shop.printCustomer();
//        printSeparator();

//        shop.printLaptops();
//        printSeparator();

//        shop.addListTransaction();
//        shop.printTransactions();
//        printSeparator();

//        shop.printLaptops();
//        printSeparator();

//        shop.reportPrintPrice();
//        printSeparator();
//        shop.reportPrintBalance();
//        printSeparator();
//        shop.reportNumberPurchasesLastSevenDay(10);
//        shop.reportTransactionListToday(1,3);
//        shop.reportPrintByCategory(Categories.OFFICE);
//        shop.reportPrintByCategory(Categories.NOGAME);
//        shop.reportPrintByCategory(Categories.ULTRA_BOOK);
//        shop.reportPrintByCategory(Categories.GAME);

        ShopUI ui = new ShopUI(shop);


    }

    public static void printSeparator(){
        System.out.println("*************************************************************************");
    }
}