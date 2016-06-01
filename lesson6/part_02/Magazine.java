package lesson6.part_02;

import java.util.ArrayList;
import java.util.List;

public class Magazine implements Subject {

    private String journalTitle;
    private List<Observer> observers;

    public Magazine() {
        observers = new ArrayList<>();
    }

    public void doTheJob() {
        double d = Math.random();
        if (d < 0.5 || d > 10.0) {
            System.out.println("Magazine - Job done!");
            notifyObservers();
        } else {
            System.out.println("Magazine - Job failed!");
        }
    }

    public String getJournalTitle() {
        return journalTitle;
    }

    public void setJournalTitle(String journalTitle) {
        this.journalTitle = journalTitle;
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
            o.update();
        }
    }
}
