package demo_materials.second_observer;

import demo_materials.first_observer.Observer;

public interface Subject {

	public void addObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObservers();
}
