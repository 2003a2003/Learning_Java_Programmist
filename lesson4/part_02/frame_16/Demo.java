package lesson4.part_02.frame_16;

import java.util.ArrayList;
import java.util.Collections;

public class Demo {
    public static void main(String[] args) {
        ArrayList<String> str = new ArrayList<>();
        str.add(new String("Alex"));
        str.add("Boris");
        str.add("Ciner");
        str.add("Dodge");
        str.add("Evgeniy");
        str.add("Famely");
        str.add("Glory");
        str.add("Leon");
        str.add("Hand");
        str.add("Not");

        Collections.sort(str);
        printList(str);

        Collections.sort(str,new Comparator());
        printList(str);
    }

    public static void printList(ArrayList<String> str){
        System.out.print("{ ");
        int index = 0;
        for (String s : str){
            System.out.print(s);
            index++;
            if(index < str.size()){
                System.out.print(", ");
            }
        }
        System.out.println(" }");
    }
}
