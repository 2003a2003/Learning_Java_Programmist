package lesson8.part_05.frame_04;

import java.io.IOException;
import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) throws IOException {
        FileSimlpeList<String> list = new FileSimlpeList();
        WorkWithFile f = new WorkWithFile();
        //add in file first information
//        list.writeToFile("Alex01");
//        list.writeToFile("Alex02");
        //list.writeToFile("Alex08");
//        list.writeToFile("Alex04");
//        list.writeToFile("Alex05");

//        System.out.println("Emply: " + list.checkEmplyLine());
        System.out.println(f.read());
        f.write("Alex11");
        System.out.println(f.read());

//        f.write("Alex02");
//        f.write("Alex03");
//        System.out.println(f.read());
//
//        System.out.println(f.getPositionToSave());
//        System.out.println(f.readFrom((int) f.goTo(7)) + f.getPositionToSave());


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

    private void printDate(ArrayList list){
        for (Object str: list){
            System.out.println(str);
        }

    }
}
