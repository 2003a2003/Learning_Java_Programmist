package lesson4.part_01.frame_5;

public class Demo {
    public static void main(String[] args) {
        Classroom c = new Classroom();
        c.getStudentCount();
        printSeparator();
        c.enter();
        c.getStudentCount();
        c.printStudentInfo();
        printSeparator();
        c.isPresent("Petrov", "Ivan");
        c.isPresent("Kotovskiy", "Aleksey");
        c.addStudentInTheClassroom("Kumar", "Sergey");
        printSeparator();
        c.printStudentInfo();
        printSeparator();
        c.leave();
        c.getStudentCount();
        printSeparator();
        c.enter();
        c.removeStudent("Kumar", "Sergey");
        c.getStudentCount();
        c.printStudentInfo();


    }

    public static void printSeparator(){
        System.out.println("**********************************************************");
    }
}
