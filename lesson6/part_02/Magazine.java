package lesson6.part_02;

import java.util.ArrayList;
import java.util.List;

public class Magazine implements Subject {

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
            notifyObservers();
        } else if (!subscribers.contains(subscriber)) {
            subscribers.add(subscriber);
            System.out.print("Magazine: " + journalTitle + " - new Subscriber: " + subscriber.getName() + " ");
            newSubscruber = true;
            notifyObservers();
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
        notifyObservers();
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            if (o instanceof NewSubscruberRegistrationObserver && newSubscruber) {
                o.update();
                newSubscruber = false;
            } else if (o instanceof NewReleaseNumbersObserver && newRelize) {
                o.update();
                newRelize = false;
            }
        }
    }
}
