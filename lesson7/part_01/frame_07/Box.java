package lesson7.part_01.frame_07;

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
        if(index < 0 || index > obj.size()){
            System.out.println("Not true Index!!!!");
            return null;
        }else {
            return obj.get(index);
        }
    }

    public void removeObjByIndex(int index){
        if(index < 0 || index > obj.size()){
            System.out.println("Not true Index!!!!");
        }else {
            obj.remove(index);
        }
    }

    public void removeObjFirst(T t){
        if (obj.contains(t)){
            obj.remove(t);
        }else {
            System.out.println(" This lisnt don't have this object: " + t.toString());
        }
    }

    public ArrayList<T> getAllBox(){
        return obj;
    }

    public void printAllBox(){
        int index = 0;
        for (T t : obj){
            System.out.println(index + ". " + t.toString());
            index++;
        }
    }

}