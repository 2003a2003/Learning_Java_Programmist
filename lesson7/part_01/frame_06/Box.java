package lesson7.part_01.frame_06;

import java.util.ArrayList;

public class Box<T extends Pistols> {

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