package lesson1.part_2.frame_4;

/**
 * Created by otroshenko on 10.02.2016.
 */
public class printTankInfo {

    public static void main(String[] args){
        Tank tank = new Tank();

        fillTheTankParameters(tank);

        printTankInfo(tank);
    }

    static void printTankInfo(Tank tank){
        System.out.println("Our Tank has " + tank.color + " color.");
        System.out.println("Crew is " + tank.crow + " people");
        System.out.println("Max speed is " + tank.maxSpeed + " km/h");
    }

    static void fillTheTankParameters(Tank tank){
        tank.color = "dark green";
        tank.crow = 4;
        tank.maxSpeed = 90;
    }
}
