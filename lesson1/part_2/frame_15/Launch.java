package lesson1.part_2.frame_15;

public class Launch {
    public static void main(String[] args){

        People  p1 = new People();
        Money   m1 = new Money();
        Work    w1 = new Work();

        p1.setSecondName("Pushkin");
        p1.setSomeMoney(m1);

        m1.setKollMoney(3000);
        m1.setAnyWork(w1);

        w1.setRabota("Admin");
        w1.setAnyPeople(p1);

        System.out.println(p1.getSecondName() + " " + "wont have " + p1.getSomeMoney().getKollMoney() + " $ salary");
        System.out.println(m1.getKollMoney() + " $ we pay for the position: " + m1.getAnyWork().getRabota());
        System.out.println("For the position: " + w1.getRabota() + " fit: " + w1.getAnyPeople().getSecondName());
        System.out.println();
    }
}