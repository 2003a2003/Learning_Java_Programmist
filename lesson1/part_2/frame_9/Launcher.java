package lesson1.part_2.frame_9;
/**
 * Created by otroshenko on 11.02.2016.
 */
public class Launcher {
    public static void main(String[] args){
        Tank tank = new Tank("dark grey", 5, 150);
        System.out.println("Tank [color: " + tank.color + ", crew: " + tank.crew + ", maxSpeed: " + tank.maxSpeed + "]");
    }
}
