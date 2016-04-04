package lesson4.part_02.frame_16;

public class Comparator implements java.util.Comparator<Object>{
    @Override
    public int compare(Object obj1, Object obj2) {
        return obj2.toString().compareTo(obj1.toString());
    }
}
