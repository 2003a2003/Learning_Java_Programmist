package lesson6.part_02.frame_08;

import com.midgardabc.day9.second_observer.jdkone.ActionEvent;

import java.util.*;


public class Supervisor implements java.util.Observer {

    @Override
    public void update(Observable o, Object arg) {

        if (arg instanceof ActionEvent) {
            System.out.println(this.toString() + " notified. Event " + ((ActionEvent) arg).getName());
        } else {
            System.out.println(this.toString() + " notified.");
        }

    }
}
