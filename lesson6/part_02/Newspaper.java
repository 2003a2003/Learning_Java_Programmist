package lesson6.part_02;

import java.util.ArrayList;

public class Newspaper implements Subject {

    private String newspaperTitle;
    private ArrayList<Observer> observers;

    public Newspaper() {
        observers = new ArrayList<>();
    }

    public void doTheJob() {
        double d = Math.random();
        if (d < 0.5 || d > 10.0) {
            System.out.println("Newspaper - Job done!");
            notifyObservers();
        } else {
            System.out.println("Newspaper - Job failed!");
        }
    }

    public String getNewspaperTitle() {
        return newspaperTitle;
    }

    public void setNewspaperTitle(String newspaperTitle) {
        this.newspaperTitle = newspaperTitle;
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
        for (lesson6.part_02.Observer o : observers) {
            o.update();
        }
    }
}
