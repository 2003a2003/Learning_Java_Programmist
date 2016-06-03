package lesson6.part_02.frame_08;

import java.util.Observable;
import java.util.Observer;

public class NewReleaseNumbersObserver implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        if(arg instanceof Event && arg == Event.NEW_RELIZE){
            System.out.println(this.toString() + " notified. Event " );
        }else {
            System.out.println("*****");
        }


    }
}
