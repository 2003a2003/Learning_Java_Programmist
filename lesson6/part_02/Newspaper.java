package lesson6.part_02;

import java.util.ArrayList;

public class Newspaper implements Subject {

    private String newspaperTitle;

    private ArrayList<Observer> observers;
    private ArrayList<Subscriber> subscribers;

    private boolean newRelize = false;
    private boolean newSubscruber = false;

    private int relize = 0;

    public Newspaper() {
        observers = new ArrayList<>();
        subscribers = new ArrayList<>();
    }

    public String getNewspaperTitle() {
        return newspaperTitle;
    }

    public void setNewspaperTitle(String newspaperTitle) {
        this.newspaperTitle = newspaperTitle;
    }

    public void addNewSubscruber(Subscriber subscriber) {
        if (subscribers.size() == 0) {
            subscribers.add(subscriber);
            System.out.print("NewPaper: " + newspaperTitle + " - new Subscriber: " + subscriber.getName() + " ");
            newSubscruber = true;
            notifyObservers();
        } else if (!subscribers.contains(subscriber)) {
            subscribers.add(subscriber);
            System.out.print("NewPaper: " + newspaperTitle + " - new Subscriber: " + subscriber.getName() + " ");
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

        System.out.print("NewPaper: " + newspaperTitle + "  - new number: " + relize + ", have been notified: " + subscribers.size() +
                " - subscribers, ");
        newRelize = true;
        notifyObservers();
    }


    @Override
    public void addObserver(lesson6.part_02.Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(lesson6.part_02.Observer o) {
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