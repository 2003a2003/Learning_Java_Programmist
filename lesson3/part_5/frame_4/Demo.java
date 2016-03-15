package lesson3.part_5.frame_4;

public class Demo {
    public static void main(String[] args) throws Exception {
        test();
        System.out.println("done");
    }

    public static void test(){

        try {
            System.out.println("block try");
            throw new Exception();
        }catch (Exception e){
            System.out.println("block catch: " + e);
            throw new IllegalStateException(e);
        }finally {
            System.out.println("I want to be printed!");
        }
    }
}
