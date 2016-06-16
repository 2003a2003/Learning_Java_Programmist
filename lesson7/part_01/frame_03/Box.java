package lesson7.part_01.frame_03;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {

    private T obj;
    private ArrayList<T> listObj;

    public Box() {
        listObj = new ArrayList<>();
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
        listObj.add(obj);
    }

    public List<T> getListObj() {
        return listObj;
    }

    public void printAllBox(){
        for (T o : listObj){
            System.out.println(o);
        }
    }
}
