package lesson9.part_01;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Running " + Thread.currentThread().getName() + " " + this.getClass().getSimpleName());
    }
}
