package lesson4.part_02.frame_13;


import java.util.Iterator;

public class Demo {
    public static void main(String[] args) {
        SimpleLinkedList s = new SimpleLinkedList();

        System.out.println("Start program.");

        s.addFirst("test01");
        s.addFirst("test02");
        s.addFirst("test03");

        for (Iterator<Object> it = s.iterator(); it.hasNext(); ){
            Object o = it.next();
            System.out.println(o);
        }
        System.out.println("End program.");

        s.remove("test01");
        for (Iterator<Object> it = s.iterator(); it.hasNext(); ){
            Object o = it.next();
            System.out.println(o);
        }
    }
}
