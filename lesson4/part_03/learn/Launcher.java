package lesson4.part_03.learn;

public class Launcher {
    public static void main(String[] args) {
        Person per = new Person();
        per.setName("Alex");
        per.setAge(25);
        per.setSalary(15500);

        Address adr1 = new Address();
        adr1.setCity("Kiev");
        adr1.setStreet("Pushkina");
        adr1.setHouse(5);

        per.setAddress(adr1);

        Person per2 = new Person();
        per2.setName("Alex");
        per2.setAge(25);
        per2.setSalary(15500);
//        per2.setAddress(adr1);

        Person per3 = new Person();
        //per3.setName("Boris");
        per3.setAge(30);
        per3.setSalary(3800);

        System.out.println(per.getName() + " " + per.hashCode());
        System.out.println(per2.getName() + " " + per2.hashCode());
        System.out.println(per3.getName() + " " + per3.hashCode());

        System.out.println();
        System.out.println();

        System.out.println("equals: " + per.equals(per2));
        System.out.println("equals: " + per.equals(per3));

    }
}
