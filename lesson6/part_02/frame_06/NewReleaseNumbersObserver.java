package lesson6.part_02.frame_06;

public class NewReleaseNumbersObserver implements Observer {

    @Override
    public void update() {
        System.out.println("observer: " + this.toString());
    }
}
