package lesson6.part_02.frame_08;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Magazine extends Observable {

    private String journalTitle;

    private List<Observer> observers;
    private ArrayList<Subscriber> subscribers;

    private boolean newRelize = false;
    private boolean newSubscruber = false;

    private int relize = 0;

    public Magazine() {
        observers = new ArrayList<>();
        subscribers = new ArrayList<>();
    }

    public String getJournalTitle() {
        return journalTitle;
    }

    public void setJournalTitle(String journalTitle) {
        this.journalTitle = journalTitle;
    }

    public void addNewSubscruber(Subscriber subscriber) {
        if (subscribers.size() == 0) {
            subscribers.add(subscriber);
            System.out.print("Magazine: " + journalTitle + " - new Subscriber: " + subscriber.getName() + " ");
            newSubscruber = true;
            setChanged();
            notifyObservers(Event.REG_SUBSKRUBER);
        } else if (!subscribers.contains(subscriber)) {
            subscribers.add(subscriber);
            System.out.print("Magazine: " + journalTitle + " - new Subscriber: " + subscriber.getName() + " ");
            newSubscruber = true;
            setChanged();
            notifyObservers(Event.REG_SUBSKRUBER);
        }
    }

    public void removeSubscruber(Subscriber subscriber){
        subscribers.remove(subscriber);
    }

    public void releaseNewNumbers() {

        if(relize < 13) {
            relize++;
        }else {
            relize = 0;
        }

        System.out.println("Magazine: " + journalTitle + " new number: " + relize + ", have been notified: " + subscribers.size() +
                " - subscribers, ");
        newRelize = true;
        setChanged();
        notifyObservers(Event.NEW_RELIZE);
    }
}
