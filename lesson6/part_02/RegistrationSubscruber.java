package lesson6.part_02;

public class RegistrationSubscruber  implements Observer{
    @Override
    public void update() {
        System.out.println("We have a new Subscriber" + this.toString());
    }
}
