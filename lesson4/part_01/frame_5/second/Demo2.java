package lesson4.part_01.frame_5.second;

public class Demo2 {
    public static void main(String[] args) {
        Classroom c1 = new Classroom();
        c1.getStudentCount();
        c1.openClassRoom();

        printSeparator();

        c1.cameTheCrowdOfStudents();
        c1.getStudentCount();
        c1.printStudentInfo();

        c1.enter(new Student("Kotovskiy", "Aleksey"));
        c1.printStudentInfo();
        c1.getStudentCount();
//        printSeparator();
//        c.isPresent("Petrov", "Ivan");
//        c.isPresent("Kotovskiy", "Aleksey");
//        c.addStudentInTheClassroom("Kumar", "Sergey");
//        printSeparator();
//        c.printStudentInfo();
//        printSeparator();
//        c.leave();
//        c.getStudentCount();
//        printSeparator();
//        c.enter();
//        c.removeStudent("Kumar", "Sergey");
//        c.getStudentCount();
//        c.printStudentInfo();


    }

    public static void printSeparator(){
        System.out.println("**********************************************************");
    }
}
