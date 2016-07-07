package lesson8.part_04.test_serializable;

import java.io.*;
import java.util.List;

public class DemoObjectIO {

    public static void main(String[] args) throws Exception {
        writeToFile("output.dat");
        readFromFile("output.dat");
    }

    private static void readFromFile(String file) throws Exception {
        try (
                ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))
        ) {
            Person person = (Person) ois.readObject();
            System.out.println(person.name + " " + person.surname);

            person = (Person) ois.readObject();
            System.out.println(person.name + " " + person.surname);

            person = (Person) ois.readObject();
            System.out.println(person.name + " " + person.surname);
        }
    }

    private static void writeToFile(String file) throws Exception {
        try (
                ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))
        ) {
            out.writeObject(new Person("Ivan", "First"));
            out.writeObject(new Person("Petr", "Secont"));
            out.writeObject(new Person("Alex", "The Best"));
        }
    }

    static class Person implements Serializable {

        private static final long serialVersionUID = 554546446464L;

        private String name;
        private transient String surname;

        private  transient List<Integer> data;

        public Person(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }
    }
}
