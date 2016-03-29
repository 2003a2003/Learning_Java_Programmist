package lesson4.part_01.frame_5.second;

public class Demo2 {
    public static void main(String[] args) {
        Classroom c = new Classroom();
        Student pushkinaMariya = new Student("Pushkina", "Mariya");
        Student petrov = new Student();
        petrov.setName("Petrov");
        petrov.setSecondName("Michail");

        c.getStudentCount();
        printSeparator();

        c.cameTheCrowdOfStudents();
        c.getStudentCount();
        c.printStudentInfo();
        printSeparator();

        c.enter(new Student("Kotovskiy", "Aleksey"));
        c.enter(pushkinaMariya);
        c.enter("Iglov", "Valentin");
        printSeparator();

        c.printStudentInfo();
        c.getStudentCount();

        printSeparator();
        c.isPresent("Petrov", "Ivan");
        c.isPresent(petrov);
        c.isPresent(new Student("Ivanchenko", "Aleksey"));
        printSeparator();

        c.leave(petrov);
        c.leave("Kotovskiy","Aleksey");
        c.leave(pushkinaMariya);
        printSeparator();

        c.printStudentInfo();
        c.getStudentCount();
    }

    public static void printSeparator(){
        System.out.println("**********************************************************");
    }
}
