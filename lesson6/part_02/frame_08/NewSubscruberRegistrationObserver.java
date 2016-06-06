package lesson6.part_02.frame_08;

import java.util.Observable;
import java.util.Observer;

public class NewSubscruberRegistrationObserver implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        if(arg instanceof Event && arg == Event.REG_SUBSKRUBER){
            System.out.println(this.toString() + " notified. Event New Subscriber." );
        }
    }
}
