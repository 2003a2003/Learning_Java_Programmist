package lesson4.part_01.frame_5.second;

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

    public void leave() {

    }

    public void getStudentCount() {
        System.out.println("Students in the room: " + students.size());
    }

    public void isPresent(String name, String secondName) {
        int index = searchStudentInTheClassRoom(name, secondName);
        if(index >= 0 ){
            System.out.println("This student " + students.get(index).toString() + "in the classroom.");
        }else {
            System.out.println("Thet student " + name + " " + secondName + " is not in the classroom.");
        }
    }

    public void printStudentInfo() {
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i).getName() + " " +
                    students.get(i).getSecondName());
        }
    }

    private List<Student> getStudents() {
        return students;
    }

    public void addStudentInTheClassroom(String name, String secondName) {

    }

    private void printYouAreNoInClassroom() {
        System.out.println("You are not in the classroom.");
    }

    public void removeStudent(String name, String secondName) {

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
}
