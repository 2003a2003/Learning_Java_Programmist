package lesson4.part_03.frame_06;

public class Person {
    private String name;
    private int age;
    long salary;

    public Person() {
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

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public int hashCode() {
        final int perem = 50;
        int rez = 5;

        if (name == null) {
            rez = perem * rez + ((Integer) age).hashCode();
            rez = perem * rez + ((Long) salary).hashCode();
        } else {
            rez = perem * rez + name.hashCode();
            rez = perem * rez + ((Integer) age).hashCode();
            rez = perem * rez + ((Long) salary).hashCode();
        }

        return rez;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Person)) {
            return false;
        }
        Person pers = (Person) obj;
        return (name != null && name.equals(pers.getName()) && (age == pers.getAge() && salary == pers.getSalary()));
    }
}
