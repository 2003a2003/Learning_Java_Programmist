package lesson1.part_1;

/**
 * Created by otroshenko on 09.02.2016.
 */
public class GreetingService {

    public static void main(String[] args) {
        if(args.length > 0){
            System.out.println("Error. You need to add some parameter after end of the line");
            System.out.println("Example: \"java GreetingSrvice Alex\"");
        }else{
            System.out.println("Hello " + args[0]);
            System.out.println();
            System.out.println("You are well done.");
        }
    }
}