package lesson8.part_05.frame_04;

public class Launcher {
    public static void main(String[] args) {
        StoreList storeList = new StoreList();
        storeList.add("Alex01");
        storeList.add("Alex02");
        storeList.add("Alex03");
        storeList.add("Alex04");
        storeList.add("Alex05");

        storeList.print();
        storeList.remove("Alex02");
        storeList.print();
    }
}
