package lesson9.part_01;

public class LauncherDemo {
    public static void main(String[] args) {
        System.out.println("Running " + Thread.currentThread().getName());

        new MyThread().run();

        new MyThread().start();

        new Thread(new MyRunnable()).start();
    }
}

