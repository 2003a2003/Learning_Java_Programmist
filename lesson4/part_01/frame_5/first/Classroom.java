package lesson4.part_01.frame_5.first;

import java.util.ArrayList;
import java.util.List;

public class Classroom {

    private List<Student> students;
    private boolean entered;

    public Classroom() {
        students = new ArrayList<>();
        entered = false;
    }

    private void addListStudent() {
        students.add(new Student("Petrov", "Ivan"));
        students.add(new Student("Ivanov", "Petr"));
        students.add(new Student("Bulkin", "Sergey"));
        students.add(new Student("Batonich", "Martin"));
    }

    public void enter() {
        if (!entered) {
            if (students.size() == 0) {
                addListStudent();
            }
            System.out.println("You entered in the classroom.");
            entered = true;
        } else {
            printYouAreNoInClassroom();
        }
    }

    public void leave() {
        if (entered) {
            //students.removeAll(students);
            System.out.println("You left the classroom.");
            entered = false;
        } else {
            printYouAreNoInClassroom();
        }
    }

    public void getStudentCount() {
        if (entered) {
            try {
                System.out.println("Vsego Studentov: " + students.size());
            } catch (NullPointerException e) {
                printYouAreNoInClassroom();
            }
        } else {
            printYouAreNoInClassroom();
        }
    }

    public void isPresent(String name, String secondName) {
        int index = searchStudentInTheClassRoom(name.trim(), secondName.trim());
        if (index >= 0) {
            System.out.println("The student: " + students.get(index).getName() + " " +
                    students.get(index).getSecondName() + " is in the classroom.");
            return;
        }

        System.out.println("The student: " + name + " " + secondName + " is not present in the classroom");
    }

    public void printStudentInfo() {
        if (entered) {
            for(int i=0; i < students.size(); i++){
                System.out.println((i + 1) + ". " + students.get(i).getName() + " " +
                        students.get(i).getSecondName());
            }
        } else {
            printYouAreNoInClassroom();
        }
    }

    private List<Student> getStudents() {
        return students;
    }

    public void addStudentInTheClassroom(String name, String secondName) {
        if (entered) {
            if (searchStudentInTheClassRoom(name, secondName) < 0) {
                students.add(new Student(name, secondName));
                System.out.println("You add new student: " + name + " " + secondName + " in the classroom.");
            } else {
                System.out.println("This student is already in the list");
            }
        } else {
            printYouAreNoInClassroom();
        }
    }

    private void printYouAreNoInClassroom() {
        System.out.println("You are not in the classroom.");
    }

    public void removeStudent(String name, String secondName) {
        if (entered) {
            int index = searchStudentInTheClassRoom(name, secondName);
            if (index < 0) {
                System.out.println("This student is not in the list");
            } else {
                students.remove(index);
                System.out.println("You removed student: " + name + " " + secondName + " in this classroom.");
            }
        }
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
