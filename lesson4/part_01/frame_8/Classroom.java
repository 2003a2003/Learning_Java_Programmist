package lesson4.part_01.frame_8;

import java.util.ArrayList;
import java.util.List;

public class Classroom {

    private List<Student> students;

    public Classroom() {
        students = new ArrayList<>();
    }

    private void addListStudentInTheRoom() {
        students.add(new Student("Petrov", "Michail"));
        students.add(new Student("Petrov", "Ivan"));
        students.add(new Student("Ivanov", "Petr"));
        students.add(new Student("Bulkin", "Sergey"));
        students.add(new Student("Batonich", "Martin"));
    }

    public void cameTheCrowdOfStudents() {
        addListStudentInTheRoom();
    }

    public void enter(Student stud) {
        System.out.println("Student " + stud.toString() + " entered");
        students.add(stud);
    }

    public void enter(String name, String secondName) {
        System.out.println("Student " + name + " " + secondName + " entered");
        students.add(new Student(name, secondName));
    }

    public void leave(Student stud) {
        System.out.println("The student: " + stud.toString() + " left the classroom.");
        students.remove(stud);
    }

    public void leave(String name, String secondName) {

        Student s = new Student();
        s.setName(name);
        s.setSecondName(secondName);

        leave(s);
    }

    public void getStudentCount() {
        System.out.println("Students in the room: " + students.size());
    }

    public void isPresent(String name, String secondName) {
        Student s = new Student();
        s.setName(name);
        s.setSecondName(secondName);

        isPresent(s);
    }

    public void isPresent(Student stud) {
        if (students.contains(stud)) {
            System.out.println("This student " + stud.toString() + " in the classroom.");
            return;
        }
        System.out.println("Thet student " + stud.toString() + " is not in the classroom.");
    }

    public void printStudentInfo() {
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i).toString());
        }
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

    private int searchStudentInTheClassRoom(String name, String secondName) {

        Student s = new Student();
        s.setName(name);
        s.setSecondName(secondName);

        return searchStudentInTheClassRoom(s);
    }

    private int searchStudentInTheClassRoom(Student o) {
        return students.indexOf(o);
    }
}
