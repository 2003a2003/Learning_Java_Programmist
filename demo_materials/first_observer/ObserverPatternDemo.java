package demo_materials.first_observer;

public class ObserverPatternDemo {

	public static void main(String[] args) {
		System.out.println("Observer Pattern Demo | Day 9 midgardabc.com");
		System.out.println();
		
		ConcreteSubject s = new ConcreteSubject();
		
		demo_materials.first_observer.Observer o1 = new demo_materials.first_observer.ConcreteObserver();
		demo_materials.first_observer.Observer o2 = new demo_materials.first_observer.ConcreteObserver();

		s.addObserver(o1);
		s.addObserver(o2);

		for (int i = 0; i < 10; i++) {
			s.doTheJob();
			System.out.println();
		}
		
		s.removeObserver(o2);

		for (int i = 0; i < 10; i++) {
			s.doTheJob();
		}
	}

}
