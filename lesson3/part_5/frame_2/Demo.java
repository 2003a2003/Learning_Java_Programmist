package lesson3.part_5.frame_2;

public class Demo {
    public static void main(String[] args) {
        System.out.println("Start test");
        test();
        System.out.println("Stop test");
    }

    public static void test(){
        try {
            return;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("I want to be executed!");
        }
    }
}
