package lesson4.part_02.frame_07;

public class Demo {
    public static void main(String[] args) {
        SimpleLinkedList<String> s = new SimpleLinkedList<String>();
        System.out.println("Size: " + s.getSize());
        s.addFirst("Kasper");
        System.out.println("Size: " + s.getSize());
        s.addLast("Pupsik");
        System.out.println("Size: " + s.getSize());
        System.out.println("First elememt: " + s);
        System.out.println("Second element: " + s.toString());
    }
}
