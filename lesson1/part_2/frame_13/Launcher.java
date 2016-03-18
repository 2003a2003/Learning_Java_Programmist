package lesson1.part_2.frame_13;

/**
 * Created by otroshenko on 11.02.2016.
 */
public class Launcher {

    public static void main(String[] args) {
        Tank[] tank = new Tank[5];
        fillTankInfo(tank);
        printTankInfo(tank);
    }

    private static void fillTankInfo(Tank[] tank) {

        //fill with konstructor
        tank[0] = new Tank("T-84 BM Oplot", "gray", 3, 70);
        tank[1] = new Tank("Leopard 2A7", "brown", 4, 72);

        //fill with set
        tank[2] = new Tank();
        tank[2].setModel("Merkava Mk-6");
        tank[2].setColor("dark brown");
        tank[2].setCrew(3);
        tank[2].setMaxSpeed(90);
    }

    private static void printTankInfo(Tank[] tank) {
        for (Tank tt : tank) {
            if (tt != null) {
                System.out.print("Model: " + tt.getModel() + ", color: " + tt.getColor() + ", ");
                System.out.print("crew: " + tt.getCrew() + ", maxSpeed: " + tt.getMaxSpeed());
                System.out.println();
            }
        }
    }
}