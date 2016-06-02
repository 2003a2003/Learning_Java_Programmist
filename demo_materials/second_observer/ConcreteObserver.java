package demo_materials.second_observer;

public class ConcreteObserver implements demo_materials.first_observer.Observer {
	
	@Override
	public void update() {
		System.out.println(this.toString() + " notified.");
	}
	
}
