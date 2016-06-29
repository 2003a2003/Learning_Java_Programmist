package lesson7.part_04.frame_02;

public class DemoLaucher {
    public static void main(String[] args) {
        Customer customer = new Customer();
        UserAdmin admin = new UserAdmin();

        PrintClassInfo.printClassinfo(customer);
        PrintClassInfo.printClassMetod(customer);
        PrintClassInfo.printClassFields(customer);

        System.out.println("**********************************");
        PrintClassInfo.printClassinfo(admin);
        PrintClassInfo.printClassMetod(admin);
        PrintClassInfo.printClassFields(admin);
    }
}
