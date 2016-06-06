package demo_materials.second_observer.jdkone;

public class ActionEvent {
	
	private String name;

	public ActionEvent(String name) {
		if (name == null) {
			name = this.toString();
		}
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}