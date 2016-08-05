package lesson8.part_05.frame_04;

public class Demo {
    public static void main(String[] args) {
        Replace r = new Replace();
        System.out.println("Add firs information:");
//        r.write("Test1");
//        r.write("Test2");
//        r.write("Test3");
//        r.write("Test4");
//        r.write("Test5");

        System.out.println(r.isHasEmpty());

        r.print();
        String data = "Alex";
        System.out.println("Remove data: " + data);
        r.remove(data);
        r.print();

        System.out.println(r.isHasEmpty());
        System.out.println("Add some information: ");
        r.write("Alex222222");
        r.print();

    }
}
