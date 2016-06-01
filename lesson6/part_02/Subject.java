package lesson6.part_02;

public interface Subject {

    public void addObserver(Observer o);

    public void removeObserver(Observer o);

    public void notifyObservers();
}
