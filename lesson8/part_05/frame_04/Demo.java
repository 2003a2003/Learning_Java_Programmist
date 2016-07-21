package lesson8.part_05.frame_04;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        FileSimlpeList<String> list = new FileSimlpeList();

        //add in file first information
        list.writeFile("Alex01");
        list.writeFile("Alex02");
        list.writeFile("Alex03");
        list.writeFile("Alex04");
        list.writeFile("Alex05");

        System.out.println(Arrays.toString(list.readFile().toArray()));
//        //add last
//        System.out.println("Add date to file:");
//        list.add("Alex1");
//        list.add("Alex2");
//        list.add("Alex3");
//        list.add("Alex4");
//        list.add("Alex5");
//        list.printList();
//
//        //Create new array
//        System.out.println("Create new array + add last");
//        list.add("Alex6");
//        list.printList();
//
//        //Add first
//        System.out.println("Add first");
//        list.addFirst("First add");
//        list.printList();
//
//       //Add by position
//        System.out.println("Add by position...");
//        list.addByPosition(6, "Petr");
//        list.printList();
//
//        //Not true pozition
//        list.addByPosition(9, "Slava");
//
//        //Peint by pozition
//        System.out.println("Print by pozition");
//        list.printByPositionInList(8);
//
//        //remove object
//        System.out.println("Remove object");
//        list.remove("Alex6");
//        list.printList();
//
//        //remove by position
//        System.out.println("Remove by pozition");
//        list.remove(new String("Alex6"));
//        list.printList();
//
//        list.addFirst(10);
//        list.printList();
//
//        list.remove(10);
//        list.printList();
//        System.out.println();
//        System.out.println("++++++++++++");
//
//        for(Object l : list){
//            System.out.println(l);
//        }

    }
}
