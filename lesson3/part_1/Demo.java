package lesson3.part_1;

public class Demo {

    public static void main(String[] args){

        int a = 4;
        try {
            if (a == 1) {
                procedure1();
            } else if (a == 2) {
                procedure2(0);
            } else if (a == 3) {
                procedure3();
            } else if (a == 4) {
                procedure4("2015-11-11");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Poimali - 1 IllegalArgumentException: " + e);
        } catch (ArithmeticException e) {
            System.out.println("Poimali - 2 ArithmeticException: " + e);
        } catch (IllegalAccessException e) {
            System.out.println("Poimali - 3 IllegalAccessException: " + e);
        } catch (MyPersonalException e) {
            System.out.println("Poimali - 4 MyPersonalException: " + e);
        } catch (Exception e) {
            System.out.println("Poimali - 4 Exception: " + e);
        } finally {
            System.out.println("Program was close all open file.....");
        }
    }

    static void procedure1() throws InterruptedException {
        Thread.sleep(3000);
    }

    static void procedure2(int i) throws ArithmeticException {
        System.out.println(10 / i);
    }

    static void procedure3() throws IllegalAccessException {
        throw new IllegalAccessException("Run Excepshen....");
    }

    static void procedure4(String date) {
        throw new MyPersonalException(date);
    }
}
