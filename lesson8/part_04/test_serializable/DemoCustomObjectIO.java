package lesson8.part_04.test_serializable;

import java.io.*;

public class DemoCustomObjectIO {

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

    static class Person implements Externalizable {

        private String name;
        private int age;


        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeInt(age);
            out.writeInt(name.getBytes().length);
            out.write(name.getBytes());
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

        }
    }

}
