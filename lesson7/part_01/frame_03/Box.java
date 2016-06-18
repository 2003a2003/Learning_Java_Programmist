package lesson7.part_01.frame_03;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {

    private ArrayList<T> obj;

    public Box() {
        obj = new ArrayList<>();
    }

    public void addObject(T t) {
        obj.add(t);
    }

    public T getObj(int index){
        return obj.get(index);
    }

    public void removeObjByIndex(int index){
        obj.remove(index);
    }

    public void removeObjFirst(T t){
        obj.remove(t);
    }

    public void getAllBox(){
        int index = 0;
        for (T t : obj){
            System.out.println(index + ". " + t.toString());
            index++;
        }
    }


}
