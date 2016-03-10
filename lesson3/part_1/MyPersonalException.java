package lesson3.part_1;

public class MyPersonalException extends RuntimeException {

    public MyPersonalException(String txt){
        System.out.println("Inside modul - 3: " + (10/0));
        throw new ArithmeticException(txt);
    }

    public void secondException() throws IllegalAccessException{


    }
}
