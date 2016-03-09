package lesson2.part_1.frame_7;

public class Demo {
    public static void main(String[] args) {

        BT7 bt7 = new BT7("BB76", 3, 74, Color.CORAL_RED);
        T34 t34 = new T34();
        Tiger tiger = new Tiger();

        bt7.prinTankInfo(bt7);
        bt7.fire(true);
        bt7.move();

        t34.prinTankInfo(bt7);
        t34.fire(false);
        t34.move();

        tiger.prinTankInfo();
        tiger.fire(true);
        tiger.move();

        //System.out.println(bt7.toString() + bt7.fire());
    }
}
