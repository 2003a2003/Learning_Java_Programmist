package lesson6.part_02;

import java.util.ArrayList;
import java.util.List;

public class Subscriber implements Subject {

    private String name;
    private String addresToDelivery;
    private List<lesson6.part_02.Observer> observers;


    //konstructor
    public Subscriber() {
        observers = new ArrayList<>();
    }

    public void doTheJob() {
        double d = Math.random();
        if (d < 0.5 || d > 10.0) {
            System.out.println("Subscriber - Job done!");
            notifyObservers();
        } else {
            System.out.println("Subscriber - Job failed!");
        }
    }


    //get - set metods

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddresToDelivery() {
        return addresToDelivery;
    }

    public void setAddresToDelivery(String addresToDelivery) {
        this.addresToDelivery = addresToDelivery;
    }


    //Override metods:
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
        for (Observer o : observers){
            o.update();
        }
    }
}
