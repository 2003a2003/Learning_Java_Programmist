package lesson4.part_02.frame_09;

public class Demo {
    public static void main(String[] args) {
        SimpleLinkedList s = new SimpleLinkedList();

        System.out.println("Start program");

        s.addFirst("test01");
        System.out.print("Size: " + s.getSize());
        s.printList();

        s.addLast("test02");
        System.out.print("Size: " + s.getSize());
        s.printList();

        s.addLast("test03");
        System.out.print("Size: " + s.getSize());
        s.printList();

        s.addAfter("test02+1", "test02");
        System.out.print("Size: " + s.getSize());
        s.printList();

        s.addAfter("test03+1", "test03");
        System.out.print("Size: " + s.getSize());
        s.printList();

        s.addAfter("test01+1", "test01");
        System.out.print("Size: " + s.getSize());
        s.printList();

        System.out.println("Test one element.....");

        s = new SimpleLinkedList();
        s.addFirst("test01");
        System.out.print("Size: " + s.getSize());
        s.printList();

        s.addAfter("test01+1", "test01");
        System.out.print("Size: " + s.getSize());
        s.printList();

        System.out.println("Test IllegalStateException");
        s = new SimpleLinkedList();
        s.addAfter("01test01", "test01");
    }
}
