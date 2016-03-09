package lesson1.part_4.frame_5;

public class Demo {
    public static void main(String[] args) {
        //Create a Car
        Car c = new Car();

        c.setModel("SEAT ALTEA XL");
        c.setYearOfIssue(2008);
        c.setMotor(1.6);
        c.setCarBody("5 door, minivan");
        c.setMaxSpeed(182);
        c.setColor(Color.BLACK);
        //printCarInfo(c);
        c.printCarInfo();
        separator();

        System.out.println("You see your car. The doors in the car are locked: " + c.getDoorLock());
        c.clickButtonOpenDoor();
        separator();
        System.out.println("Motor this car is run: " + c.getMotorState());
        c.runMotor();
        separator();
        c.runTheCar();
        c.stopTheCar();
        separator();
        c.stopMotor();
        c.clickButtonCloseDoors();



    }

    public static void printCarInfo(Car car){
        separator();
        System.out.println("You Car:");
        System.out.println("Model: " + car.getModel() + ", Year: " + car.getYearOfIssue());
        System.out.println("Engine: " + car.getMotor());
        System.out.println("Car Body: " + car.getCarBody());
        System.out.println("Max speed: " + car.getMaxSpeed());
        System.out.println("Color: " + car.getColor());
        separator();
    }

    public static void separator(){
        System.out.println("--------------------------------------------------------------------");
    }
}
