package lesson4.part_02.frame_13;


import java.util.Iterator;

public class Demo {
    public static void main(String[] args) {
        SimpleLinkedList s = new SimpleLinkedList();

        System.out.println("Start program. Add elements.");

        s.addFirst("test01");
        s.addFirst("test02");
        s.addFirst("test03");
        s.printList();

        System.out.println("Remove elements.");

        s.remove("test01");
        s.printList();
        for (Iterator<Object> it = s.iterator(); it.hasNext(); ){
            it.next();
            it.remove();
            break;
        }
        s.printList();
    }
}
