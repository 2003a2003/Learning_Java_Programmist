package lesson4.part_02.frame_11;


import java.util.Iterator;

public class Demo {
    public static void main(String[] args) {
        SimpleLinkedList s = new SimpleLinkedList();

        System.out.println("Start program.");

        s.addFirst("test01");
        s.addLast("test02");
        s.addLast("test03");
        s.addAfter("test02+1", "test02");
        s.addAfter("test03+1", "test03");
        s.addAfter("test01+1", "test01");
//        for (Object o: s){
//            System.out.println(o);
//        }

        for (Iterator<Object> it = s.iterator(); it.hasNext(); ){
            Object o = it.next();
            System.out.println(o);
        }
        System.out.println("End program.");
    }
}
