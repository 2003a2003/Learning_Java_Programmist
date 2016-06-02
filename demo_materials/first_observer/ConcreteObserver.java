package demo_materials.first_observer;

public class ConcreteObserver implements Observer {
	
	@Override
	public void update() {
		System.out.println(this.toString() + " notified.");
	}
	
}
