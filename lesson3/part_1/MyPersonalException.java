package lesson3.part_1;

public class MyPersonalException extends RuntimeException {
    public MyPersonalException(String txt){
        if(txt.length() < 15) {
            throw new MyPersonalException("txt.length() < 15");
        }
    }
}
