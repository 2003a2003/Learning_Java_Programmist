package lesson6.part_02.frame_08.OLD_metods;

import lesson6.part_02.frame_08.OLD_metods.Observer;

public interface Subject {

    public void addObserver(Observer o);

    public void removeObserver(Observer o);

    public void notifyObservers();
}
