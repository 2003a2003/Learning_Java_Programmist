package lesson7.part_04.frame_02;

public class PrintClassInfo {

    public static void printClassinfo(Object o){
        System.out.println("Print Classinfo:");
        System.out.println("Class simple name: " + o.getClass().getSimpleName());
        System.out.println("Class paretn simple name: " + o.getClass().getSuperclass().getSimpleName());
    }

    public static void printClassMetod(Object o){
        System.out.println("Print Class Constructors:");
        for (Object metod : o.getClass().getConstructors()){
            System.out.println(metod);
        }

        System.out.println("Print Class Metods:");
        for (Object metod : o.getClass().getMethods()){
            System.out.println(metod);
        }
    }

    public static void printClassFields(Object o){
        System.out.println("Print Class Declared Fields:");
        for (Object declareField : o.getClass().getDeclaredFields()){
            System.out.println(declareField);
        }
    }
}