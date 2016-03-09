package lesson2.part_1.frame_2;

public class Demo {
    public static void main(String[] args) {

        BT7 bt7 = new BT7("BB76", 3, 80, Color.CORAL_RED);
        bt7.setMaxSpeed(71);

        T34 t34 = new T34();
        Tiger tiger = new Tiger();

        bt7.prinTankInfo();
        bt7.fire();

        t34.prinTankInfo();
        t34.fire();

        tiger.prinTankInfo();
        tiger.fire();
    }
}
