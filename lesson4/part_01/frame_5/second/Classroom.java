package lesson4.part_01.frame_5.second;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

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
        students.add(new Student(name,secondName));
    }

    public void leave(Student stud) {
        int index = searchStudentInTheClassRoom(stud);

        if(index >= 0) {
            students.remove(index);
            System.out.println("The student: " + stud.toString() + " left the classroom.");
        }else{
            System.out.println("Wrong!!!!");
        }
    }

    public void leave(String name, String secondName) {
        int index = searchStudentInTheClassRoom(name, secondName);

        if(index >= 0) {
            System.out.println("The student: " + students.get(index).toString() + " left the classroom.");
            students.remove(index);
        }else{
            System.out.println("Wrong!!!!");
        }
    }

    public void getStudentCount() {
        System.out.println("Students in the room: " + students.size());
    }

    public void isPresent(String name, String secondName) {
        int index = searchStudentInTheClassRoom(name, secondName);
        if (index >= 0) {
            System.out.println("This student " + students.get(index).toString() + " in the classroom.");
        } else {
            System.out.println("Thet student " + name + " " + secondName + " is not in the classroom.");
        }
    }

    public void isPresent(Student stud) {
        for (Student s : students) {
            if (s.toString().equals(stud.toString())) {
                System.out.println("This student " + stud.toString() + " in the classroom.");
                return;
            }
        }
        System.out.println("Thet student " + stud.toString() + " is not in the classroom.");
    }

    public void printStudentInfo() {
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i).toString());
        }
    }

    public List<Student> getStudents() {
        return students;
    }

    private int searchStudentInTheClassRoom(String name, String secondName) {
        int index = 0;
        for (Student s : students) {
            if (s.getName().trim().equals(name.trim()) && s.getSecondName().trim().equals(secondName.trim())) {
                return index;
            }
            index++;
        }
        return -1;
    }

    private int searchStudentInTheClassRoom(Student o) {
        int index = 0;
        for (Student s: students){
            if(s.toString().equals(o.toString())){
                return index;
            }
            index++;
        }
        return -1;
    }
}
