package lesson6.part_02.frame_08;

import java.util.Observable;

public class Publisher extends Observable{

    private Event event;
    private Edition edition;



    public Publisher(Event event, Edition edition) {
        this.event = event;
        this.edition = edition;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Edition getEdition() {
        return edition;
    }

    public void setEdition(Edition edition) {
        this.edition = edition;
    }

    private void doPublishe(){

    }

    private void doRegistred(){

    }


    public void addNewEvent(Event event, Subscriber subscriber){
        if(event == Event.REG_SUBSKRUBER){
            System.out.println("Regist new Subscruber!" + subscriber.getName());
            setChanged();
            notifyObservers(event);
        }else if(event == Event.NEW_RELIZE){
            System.out.println("Released a new release:"  );
            setChanged();
            notifyObservers(event);
        }



    }
}
