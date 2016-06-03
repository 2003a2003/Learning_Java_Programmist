package lesson6.part_02.frame_08;

import java.util.Observable;


public class Supervisor implements java.util.Observer {

    @Override
    public void update(Observable o, Object arg) {
//        if (arg instanceof ActionEvent) {
//            System.out.println(this.toString() + " notified. Event " + ((ActionEvent) arg).getName());
//        } else {
//            System.out.println(this.toString() + " notified.");
//        }
    }
}