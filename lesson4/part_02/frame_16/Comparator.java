package lesson4.part_02.frame_16;

public class Comparator implements java.util.Comparator<Object>{
    @Override
    public int compare(Object obj1, Object obj2) {
        //Comment My Comparator
        //return obj2.toString().compareTo(obj1.toString());
        int res = obj1.toString().compareToIgnoreCase(obj2.toString());
        if(res < 0){
            return 1;
        }else if(res > 0){
            return -1;
        }
        return 0;
    }
}
