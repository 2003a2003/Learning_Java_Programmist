package lesson3.part_1;

public class MyTestException {

    public static void main(String[] args) {

            int a = 3;

            try {
                if (a == 1) {
                    procedure();
                }else if (a == 2) {
                    MyException("demo - 2");
                }else if (a == 3){
                    MyPersonalException  b = new MyPersonalException("demo - 3");
                }

            } catch (IllegalAccessException e) {
                System.out.println("Poimali: " + e);
            } catch (ArithmeticException e) {
                System.out.println("Poimali: " + e);
            }finally {
                System.out.println("Program was close all open file.....");
            }
        }


    static void procedure() throws IllegalAccessException{

        System.out.println("Inside modole 1");
        throw new IllegalAccessException("demo - 1");

    }

    static void MyException(String txt) throws ArithmeticException {
        System.out.println("Inside modole 2");
        throw new ArithmeticException(txt);
    }

}
