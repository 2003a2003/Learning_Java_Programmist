package lesson6.part_02.frame_08;

public interface Subject {

    public void addObserver(Observer o);

    public void removeObserver(Observer o);

    public void notifyObservers();
}
