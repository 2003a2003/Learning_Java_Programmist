package lesson2.part_6.frame_4;

public class Services {

    public static void printPriceAndBalance(Laptops[] laptops, String report) {
        int index = 1;
        printHeaderReport(report);
        for (Laptops l : laptops) {
            if (l != null) {
                System.out.print(index + ". Brand: " + l.getBrand() + " | Model: " + l.getModel());
                if (report.trim().equals("price")) {
                    System.out.println(" | price: " + l.getPrice());
                } else if (report.trim().equals("balance")) {
                    System.out.println(" | balance: " + l.getBalance());
                }
                index++;
            }
        }
    }

    private static void printHeaderReport(String report) {
        if (report.trim().equals("price")) {
            System.out.println("-------- Price list  -----------");
        } else if (report.trim().equals("balance")) {
            System.out.println("-------- Balance list-----------");
        } else if (report.trim().equals("lastSevenDay")) {
            System.out.println("Purchases last 7 day.");
        } else if (report.trim().equals("TransactionToDay")) {
            System.out.println("-------- Tranzaction today -----------");
        }
    }

    public static void printmberPurchasesLastSevenDay(Transaction[][][] transactions, int month, int day) {
        printHeaderReport("lastSevenDay");
        System.out.println("------------------------>");

        for (int i = day; (i > day - 7) && i > 0; i--) {

            if (i == day) {
                System.out.print("[ ");
            }

            int count = 0;

            for (int j = 0; j < transactions[month][i].length; j++) {
                if (transactions[month][i][j] != null && i > 0) {
                    count++;
                }
            }

            System.out.print(count);

            if (i > day - 6 && i > 1) {
                System.out.print(" , ");
            }
        }
        System.out.println(" ]");
    }

    public static void printTransactionToDay(Transaction[][][] transactions, int month, int day) {
        printHeaderReport("TransactionToDay");
        int index = 1;
        int price = 0;
        int koll = 0;
        System.out.println();
        System.out.println("-------------------------------------------------");
        System.out.printf("%-3s%-11s%-20s%-6s%-11s%n", "| №", "| Counter", "| Laptop ", "| Koll", "| Price");
        System.out.println("-------------------------------------------------");
        for (Transaction t : transactions[month][day]) {
            if (t != null) {
                System.out.printf("%-4s%-11s%-20s%-6s%-11s%n", "| " + index, "| " + t.getCustomer().getName(),
                        "| " + t.getLaptops().getModel(), "| " + t.getNumber(), "| " + t.getPrice());
                index++;
                koll += t.getNumber();
                price += t.getPrice();
            }
        }
        System.out.println("-------------------------------------------------");
        System.out.printf("%-28s%-7s%-6s%-11s%n", " ", "|Total:", "| " + koll, "| " + price);
        System.out.printf("%-28s%-24s%n", " ", "---------------------");
    }

    public static void printByCategory(String[] str, Categories categories, String index) {

        char ch = categories.toString().charAt(0);
        int ind = index.indexOf(ch);

        if (str[ind] != null) {
            System.out.println("                        *Sort by " + categories + "* ");
            System.out.println("------------------------------------------------------------------");
            System.out.println(str[ind]);
            System.out.println("------------------------------------------------------------------");
        }
    }
}
