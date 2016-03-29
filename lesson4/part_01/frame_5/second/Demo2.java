package lesson4.part_01.frame_5.second;

public class Demo2 {
    public static void main(String[] args) {
        Classroom c1 = new Classroom();

        c1.getStudentCount();
        printSeparator();
        c1.cameTheCrowdOfStudents();
        c1.getStudentCount();
        c1.printStudentInfo();

        c1.enter(new Student("Kotovskiy", "Aleksey"));
        c1.printStudentInfo();
        c1.getStudentCount();
        printSeparator();

        c1.isPresent("Petrov", "Ivan");
        Student petrov = new Student();
        petrov.setName("Petrov");
        petrov.setSecondName("Michail");

        c1.isPresent(petrov);
        c1.isPresent(new Student("Ivanchenko", "Aleksey"));
        printSeparator();

//        c.leave();
//        c.printStudentInfo();


    }

    public static void printSeparator(){
        System.out.println("**********************************************************");
    }
}
