package lesson6.part_02.frame_08;

public class NewSubscruberRegistrationObserver implements Observer {
    @Override
    public void update() {
        System.out.println("observer: " + this.toString());
    }
}
