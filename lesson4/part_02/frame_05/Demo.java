package lesson4.part_02.frame_05;

public class Demo {
    public static void main(String[] args) {
        SimpleLinkedList<String> s = new SimpleLinkedList<String>();
        System.out.println("Size: " + s.getSize());
        s.addFirst("Kasper");
        System.out.println("Size: " + s.getSize());
    }
}
