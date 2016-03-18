package lesson2.part_6.frame_4;

import java.util.LinkedHashSet;

public class Shop {

    private Transaction[][][] transactions;
    private Laptops[] laptops;
    private Laptops[] lptpsSortByCategory;
    private String[] strSortCat;
    private Customer[] customers;

    private int number;
    private int price;

    private int customersTail;
    private int transactionTail;
    private int laptopTail;

    private int sizeFirstCreateBase;
    private int sizeDayInMonth;

    private int tailCustomers;
    private int tailLaptop;

    private int tailTransactions;
    private final int MONTH = 12;
    private int day = 31;

    public Shop() {
        sizeFirstCreateBase = 10;
        customers = new Customer[sizeFirstCreateBase];
        updateTeilCustomers();
        addListCustomers();

        laptops = new Laptops[sizeFirstCreateBase];
        updateTeilLaptops();
        addListLaptop();

        transactions = new Transaction[MONTH][day][30];
        //addListTransaction();
        lptpsSortByCategory = new Laptops[laptops.length];
        strSortCat = sortLptosByCategory();
    }


    //-------------------------------------Block Customers start -----------------------------------------------------
    public void addNewCustomer(String name, String phone, String adress) {
        int id = findCustomer(phone);

        if (id == -1) {
            if (tailCustomers < customers.length) {
                addCustomer(name, phone, adress);
            } else {
                createNewDataBase();
                addCustomer(name, phone, adress);
            }
            updateTeilCustomers();
        } else {
            System.out.println("You have phone: " + phone + " in your base......");
        }
    }

    private int findCustomer(String phone) {
        for (int i = 0; i < tailCustomers; i++) {
            if (customers[i].getPhoneNumber().trim().equals(phone)) {
                return i;
            }
        }
        return -1;
    }

    private void addCustomer(String name, String phone, String delivAdress) {
        customers[tailCustomers] = new Customer();
        customers[tailCustomers].setName(name);
        customers[tailCustomers].setPhoneNumber(phone);
        customers[tailCustomers].setDeliveryAddress(delivAdress);
    }

    private void createNewDataBase() {
        Customer[] temp = customers;
        customers = createNewBaseCustomer();
        copyDataBase(temp);
    }

    private Customer[] createNewBaseCustomer() {
        return new Customer[(customers.length + 10)];
    }

    private void copyDataBase(Object[] temp) {
        if (temp instanceof Customer[]) {
            System.arraycopy(temp, 0, customers, 0, temp.length);
        } else if (temp instanceof Laptops[]) {
            System.arraycopy(temp, 0, laptops, 0, temp.length);
        }
    }

    private void updateTeilCustomers() {
        int tail = 0;
        if (customers != null) {
            for (Customer c : customers) {
                if (c != null) {
                    tail++;
                }
            }
        }
        setTailCustomers(tail);
    }

    private void addListCustomers() {
        addNewCustomer("Alex", "35989898", "Kiev ");
        addNewCustomer("Aleksey", "2222222", "Ivanovo");
        addNewCustomer("Fedor", "333333", "Pertopavlovsk");
        addNewCustomer("Petrov", "4444444", "Kutuzovsk");
        addNewCustomer("Malcev", "55555558", "Kiev");
        addNewCustomer("Andiano", "666666", "Ivanovo");
    }

    public void chengeCustomer(String name, String phone, String adress) {
        int id = findCustomer(phone);
        if (id != -1) {
            System.out.print("Customer " + customers[id].getName() + " was chenge : ");

            if (name != null && name.length() > 0) {
                customers[id].setName(name);
            }

            if (adress != null && adress.length() > 0) {
                customers[id].setDeliveryAddress(adress);
            }
            System.out.println(customers[id].getName());

        } else {
            System.out.println("You can add new Customer.....");
        }
    }

    public void deleteCustomer(String phone) {
        int id = findCustomer(phone);
        if (id != -1) {
            customers[id] = null;
        } else {
            System.out.println("You don't Customer whith phone: " + phone);
        }
    }

    public void printCustomer() {
        int index = 1;
        if (customers != null) {
            for (Customer c : customers) {
                if (c != null) {
                    c.printCustomer(index);
                    index++;
                }
            }
        }
    }

    //-------------------------------------Block Latop start --------------------------------------------------------

    private void updateTeilLaptops() {
        int tail = 0;
        if (laptops != null) {
            for (Laptops l : laptops) {
                if (l != null) {
                    tail++;
                }
            }
        }
        setTailLaptop(tail);
    }

    public void addNewLeptop(Brand brand, String model, String description, Categories categories, Color color,
                             int price, int balance) {
        int id = findLaptop(model);

        if (id == -1) {
            if (tailLaptop < laptops.length) {
                addLaptop(brand, model, description, categories, color, price, balance);
            } else {
                createNewDataBaseLaptop();
                addLaptop(brand, model, description, categories, color, price, balance);
            }
            updateTeilLaptops();
        } else {
            System.out.println("You have model " + model + " on you storage!!!!!");
        }
    }

    public void addNewLeptop(Laptops laptops) {
        int id = findLaptop(laptops.getModel());
        if (id == -1) {
            if (tailLaptop < this.laptops.length) {
                addLaptop(laptops);
            } else {
                createNewDataBaseLaptop();
                addLaptop(laptops);
            }
            updateTeilLaptops();
        } else {
            System.out.println("You have model " + laptops.getModel() + " on you storage!!!!!");
        }
    }

    private void createNewDataBaseLaptop() {
        Laptops[] temp = laptops;
        laptops = createNewBaseLaptop();
        copyDataBase(temp);
    }

    private Laptops[] createNewBaseLaptop() {
        return new Laptops[(laptops.length + 10)];
    }

    private void addLaptop(Brand brand, String model, String description, Categories categories, Color color,
                           int price, int balance) {

        laptops[tailLaptop] = new Laptops();
        laptops[tailLaptop].setBrand(brand);
        laptops[tailLaptop].setModel(model);
        laptops[tailLaptop].setDescription(description);
        laptops[tailLaptop].setCategories(categories);
        laptops[tailLaptop].setColor(color);
        laptops[tailLaptop].setPrice(price);
        laptops[tailLaptop].updateBalance(balance);
    }

    private void addLaptop(Laptops laptops) {
        if (laptops instanceof Asus) {
            this.laptops[tailLaptop] = new Asus();
        } else if (laptops instanceof Dell) {
            this.laptops[tailLaptop] = new Dell();
        } else if (laptops instanceof Acer) {
            this.laptops[tailLaptop] = new Acer();
        } else if (laptops instanceof Fujitsu) {
            this.laptops[tailLaptop] = new Fujitsu();
        }

        this.laptops[tailLaptop] = laptops;
    }

    public void printLaptops() {
        int index = 1;
        if (laptops != null) {
            for (Laptops l : laptops) {
                if (l != null) {
                    l.printLaptops(index);
                    index++;
                }
            }
        }
    }

    private int findLaptop(String model) {
        for (int i = 0; i < tailLaptop; i++) {
            if (laptops[i].getModel().trim().equals(model)) {
                return i;
            }
        }
        return -1;
    }

    public void chengeLaptop(Brand brand, String model, String description, Categories categories, Color color,
                             int price, int balance) {
        int id = findLaptop(model);

        if (id != -1) {
            System.out.print("Laptop model: " + laptops[id].getModel() + "was chenge....");

            if (brand != null) {
                laptops[id].setBrand(brand);
            }

            if (description != null && description.length() > 0) {
                laptops[id].setDescription(description);
            }

            if (categories != null) {
                laptops[id].setCategories(categories);
            }

            if (color != null) {
                laptops[id].setColor(color);
            }
            if (price != 0) {
                laptops[id].setPrice(price);
            }

            if (balance != 0) {
                laptops[id].updateBalance(balance);
            }
        } else {
            System.out.println("You can add new Customer.....");
        }
    }

    private boolean shengeNotNullStringDate(String date) {
        if (date != null && date.length() > 0) {
            return false;
        }
        return true;
    }

    private void addListLaptop() {

        addNewLeptop(new Asus("AR86-M", "Экран 15.6,/Celeron N2840/RAM 4ГБ/HDD 500ГБ/DOS/1.86 кг/",
                Categories.NOGAME, Color.RED, 7900, 10));

        addNewLeptop(new Asus("EeeBook E502MA", "Экран 15.6/Celeron N2840/RAM 4ГБ/HDD 500ГБ/DOS/1.86 кг/",
                Categories.OFFICE, Color.BLUE, 7999, 9));

        addNewLeptop(new Asus("X555SJ", "Экран 15.6/Pentium N3700/RAM 4ГБ/HDD 1ТБ/GT 920M, 1ГБ/DOS/2.3 кг/",
                Categories.GAME, Color.BLACK, 10500, 4));

        addNewLeptop(new Asus("X540LJ", "Экран 15.6/i3-4005U/RAM 4ГБ/HDD 1ТБ/920M,2ГБ/DOS/1.9 кг/",
                Categories.GAME, Color.DARK_BROWN, 12500, 6));

        addNewLeptop(new Acer("Predator 15 G9-591-73DF", "Экран 15.6/i7-6700HQ/RAM 8ГБ/SSD 128ГБ+HDD 1ТБ/GTX 970M,3ГБ/Windows 10 " +
                "Home Single Language 64bit/3.4 кг/", Categories.GAME, Color.BLACK, 49999, 3));

        addNewLeptop(new Acer("Aspire E5-573-38KH", "Экран 15.6/i3-5005U/RAM 4ГБ/HDD 500ГБ/Linux/2.4 кг/",
                Categories.OFFICE, Color.BLACK_GRAY, 10999, 9));

        addNewLeptop(new Dell("Inspiron 3542", "Экран 15.6/Celeron 2957U/RAM 2ГБ/HDD 500ГБ/Linux/2.4 кг/",
                Categories.OFFICE, Color.BLACK, 6899, 8));

        addNewLeptop(new Dell("Inspiron 5558", "Экран 15.6/i5-5200U/RAM 4ГБ/HDD 1ТБ/GeForce 920M, 4ГБ/Linux/2.3 кг/",
                Categories.GAME, Color.BLACK, 16468, 3));

        addNewLeptop(new Fujitsu("Lifebook U904", "Экран 14/i5-4300U/RAM 10ГБ/SSD 256ГБ/Windows 8.1 Pro 64-bit/1.33 кг/",
                Categories.ULTRA_BOOK, Color.RED, 59514, 2));

        addNewLeptop(new Fujitsu("Lifebook A514", "Экран 15.6/i3-4005U/RAM 4ГБ/HDD 500ГБ/без ОС/2.4 кг/",
                Categories.OFFICE, Color.BLACK, 12968, 3));

        addNewLeptop(new Fujitsu("Lifebook A512", "Экран 15.6/Pentium 2020M/RAM 4ГБ/HDD 500ГБ/без ОС/2.5 кг/",
                Categories.OFFICE, Color.BLACK, 16468, 3));
    }

    public String getSearchDate(){
        String[] temp = removeDuplicate();
        String strToSearchArray = "";

        for (String s : temp) {
            if (s != null) {
                strToSearchArray += s.toString().charAt(0);
            }
        }
        return strToSearchArray;
    }

    private String[] sortLptosByCategory() {

        String[] temp = removeDuplicate();
        String strToSearchArray = getSearchDate();

        String[] sortByCat = new String[strToSearchArray.length()];
        String strSort = "| ";

        for (int i = 0; i < strToSearchArray.length(); i++) {
            if (temp[i] != null) {
                for (int j = 0; j < tailLaptop; j++) {
                    if (laptops[j] != null) {
                        if (laptops[j].getCategories().toString().equals(temp[i].toString())) {
                            strSort += laptops[j].getModel().toString() + " | ";
                        }
                    }
                }
            }
            sortByCat[i] = strSort;
            strSort = "| ";
        }
        return sortByCat;
    }

    private String[] removeDuplicate() {

        LinkedHashSet<String> HashSet = new <String>LinkedHashSet();
        for (Laptops l : laptops) {
            if (l != null) {
                HashSet.add(l.getCategories().toString());
            }
        }

        String[] temp = new String[HashSet.size()];
        temp = HashSet.toArray(temp);

        return temp;
    }

    public void updateLaptopBalance(String model, int number) {
        int id = findLaptop(model);
        if (id != -1) {
            laptops[id].updateBalance(number);
        } else {
            System.out.println("You do not have such a model: " + model);
        }
    }

    //-------------------------------------Block Transactions start -------------------------------------------------
    private void addTransactions(int month, int day, Customer customer, Laptops laptops, int number) {

        updateTransactionInMount(month, day);

        if (month > 0 && month <= 12) {
            if (day > 0 && day <= 31) {
                if (customer != null && laptops != null) {
                    if (laptops.getBalance() >= number) {
                        transactions[month][day][tailTransactions] = new Transaction();
                        transactions[month][day][tailTransactions].setCustomer(customer);
                        transactions[month][day][tailTransactions].setLaptops(laptops);
                        transactions[month][day][tailTransactions].setNumber(number);
                        updateLaptopBalance(laptops.getModel(), -number);
                        tailTransactions++;
                    } else {
                        System.out.println("You don't have koll laptops in your shop!!!!!!!!!!!");
                    }
                }
            }
        }
    }

    public void addListTransaction() {
        addTransactions(1, 1, customers[0], laptops[0], 3);
        addTransactions(1, 1, customers[1], laptops[0], 3);
        addTransactions(1, 1, customers[2], laptops[0], 3);
        addTransactions(1, 2, customers[4], laptops[0], 1);
        addTransactions(1, 2, customers[0], laptops[1], 1);
        addTransactions(1, 2, customers[1], laptops[1], 1);
        addTransactions(1, 2, customers[4], laptops[1], 3);
        addTransactions(1, 3, customers[5], laptops[3], 3);
        addTransactions(1, 3, customers[4], laptops[2], 1);
        addTransactions(1, 4, customers[3], laptops[4], 1);
        addTransactions(1, 4, customers[2], laptops[5], 3);
        addTransactions(1, 4, customers[1], laptops[5], 3);
        addTransactions(1, 5, customers[0], laptops[6], 3);
        addTransactions(1, 5, customers[1], laptops[7], 1);
        addTransactions(1, 6, customers[2], laptops[8], 1);
        addTransactions(1, 7, customers[3], laptops[9], 1);
        addTransactions(1, 8, customers[4], laptops[10], 2);
        addTransactions(1, 9, customers[5], laptops[1], 3);
        addTransactions(1, 10, customers[5], laptops[2], 1);
        addTransactions(1, 11, customers[5], laptops[2], 1);
        addTransactions(1, 12, customers[4], laptops[2], 1);
        addTransactions(1, 13, customers[3], laptops[7], 1);
        addTransactions(1, 14, customers[3], laptops[9], 1);
    }

    public void printTransactions() {
        for (int i = 0; i < MONTH; i++) {
            int index = 0;
            for (int j = 0; j < day; j++) {
                for (Transaction t : transactions[i][j])
                    if (t != null) {
                        index++;
                        t.printTransaction(i, j, index);
                    }
            }
        }
    }

    private void updateTransactionInMount(int month, int day) {
        int tail = 0;
        for (Transaction t : transactions[month][day])
            if (t != null) {
                tail++;
            }
        setTailTransactions(tail);
    }

    public void setTailTransactions(int tailTransactions) {
        this.tailTransactions = tailTransactions;
    }

    //-------------------------------------Block print repoet ------------------------------------------------------

    public void reportPrintPrice() {
        Services.printPriceAndBalance(laptops, "price");
    }

    public void reportPrintBalance() {
        Services.printPriceAndBalance(laptops, "balance");
    }

    public void reportNumberPurchasesLastSevenDay(int day) {
        Services.printmberPurchasesLastSevenDay(transactions, 1, day);
    }

    public void reportTransactionListToday(int month, int day) {
        Services.printTransactionToDay(transactions, month, day);
    }

    public void reportPrintByCategory(Categories categories) {
        Services.printByCategory(strSortCat, categories, getSearchDate());
    }

    //GET - SET
    public Transaction[][][] getTransactions() {
        return transactions;
    }

    private void setTransactions(Transaction[][][] transactions) {
        this.transactions = transactions;
    }

    public Laptops[] getLaptops() {
        return laptops;
    }

    private void setLaptops(Laptops[] laptops) {
        this.laptops = laptops;
    }

    public Customer[] getCustomers() {
        return customers;
    }

    private void setCustomers(Customer[] customers) {
        this.customers = customers;
    }

    public int getNumber() {
        return number;
    }

    private void setNumber(int number) {
        this.number = number;
    }

    public int getPrice() {
        return price;
    }

    private void setPrice(int price) {
        this.price = price;
    }

    private int getCustomersTail() {
        return customersTail;
    }

    private void setCustomersTail(int customersTail) {
        this.customersTail = customersTail;
    }

    private int getTransactionTail() {
        return transactionTail;
    }

    private void setTransactionTail(int transactionTail) {
        this.transactionTail = transactionTail;
    }

    private int getLaptopTail() {
        return laptopTail;
    }

    private void setLaptopTail(int laptopTail) {
        this.laptopTail = laptopTail;
    }

    private int getSizeDayInMonth() {
        return sizeDayInMonth;
    }

    private void setSizeDayInMonth(int sizeDayInMonth) {
        this.sizeDayInMonth = sizeDayInMonth;
    }

    public int getTailCustomers() {
        return tailCustomers;
    }

    private void setTailCustomers(int tailCustomers) {
        this.tailCustomers = tailCustomers;
    }

    public int getTailLaptop() {
        return tailLaptop;
    }

    private void setTailLaptop(int tailLaptop) {
        this.tailLaptop = tailLaptop;
    }

    public int getMONTH() {
        return MONTH;
    }

    public Laptops[] getLptpsSortByCategory() {
        return lptpsSortByCategory;
    }

    private void setLptpsSortByCategory(Laptops[] lptpsSortByCategory) {
        this.lptpsSortByCategory = lptpsSortByCategory;
    }

    public String[] getStrSortCat() {
        return strSortCat;
    }

    private void setStrSortCat(String[] strSortCat) {
        this.strSortCat = strSortCat;
    }

}
