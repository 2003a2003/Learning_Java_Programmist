package lesson4.part_02.frame_09;

public class Demo {
    public static void main(String[] args) {
        SimpleLinkedList s = new SimpleLinkedList();
        System.out.println("Size start: " + s.getSize());
        s.addFirst("Kasper");
        System.out.println("Size: " + s.getSize());
//        s.addLast("Pupsik");
//        System.out.println("Size: " + s.getSize());
//        s.addLast("test");
//        System.out.println("Size: " + s.getSize());
//        s.addAfter("KASPER2", "Pupsik");
//        System.out.println("Size: " + s.getSize());
//        s.addAfter("KASPER34", "test");
//        System.out.println("Size: " + s.getSize());
        s.addAfter("KASPER34", "Kasper");
        System.out.println("Size: " + s.getSize());
    }
}
