package lesson1.part_4.frame_5;

public class Car {

    private String model;
    private int yearOfIssue;
    private double motor;
    private String carBody;
    private Color color;
    private int maxSpeed;
    private boolean doorLock = true;
    private boolean motorState = false;
    private boolean stateCar = true;

    public Car() {
        this("No Information", 0, 0.0, "No Information", null, 0);
    }

    private Car(String model, int yearOfIssue, double motor, String carBody, Color color, int maxSpeed) {
        this.model = model;
        this.yearOfIssue = yearOfIssue;
        this.motor = motor;
        this.carBody = carBody;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    //GET
    public String getModel() {
        return model;
    }

    public int getYearOfIssue() {
        return yearOfIssue;
    }

    public double getMotor() {
        return motor;
    }

    public String getCarBody() {
        return carBody;
    }

    public Color getColor() {
        return color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public boolean getDoorLock() {
        return doorLock;
    }

    public boolean getMotorState() {
        return motorState;
    }

    public boolean getStateCar() {
        return stateCar;
    }

    //SET
    public void setModel(String model) {
        this.model = model;
    }

    public void setYearOfIssue(int yearOfIssue) {
        this.yearOfIssue = yearOfIssue;
    }

    public void setMotor(double motor) {
        this.motor = motor;
    }

    public void setCarBody(String carBody) {
        this.carBody = carBody;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    //UPDATE STATE AND METODS
    private void updateDoorLock(boolean key) {
        if (key == true) {
            doorLock = false;
            System.out.println("All doors was unlocked ..." + "Doors are locked: " + getDoorLock() );
       } else {
            doorLock = true;
            System.out.println("All doors was locked..." + "Doors are locked: " + getDoorLock());
        }
    }

    public void clickButtonOpenDoor() {
        System.out.print("You click button open doors. ");
        updateDoorLock(true);
    }

    public void clickButtonCloseDoors() {
            System.out.print("You click button close doors. ");
            updateDoorLock(false);
    }

    public void printCarInfo() {
        System.out.println("Model: " + getModel() + ", Year: " + getYearOfIssue());
        System.out.println("Engine: " + getMotor());
        System.out.println("Car Body: " + getCarBody());
        System.out.println("Max speed: " + getMaxSpeed());
        System.out.println("Color: " + getColor());
    }

    private void updateMotorState(boolean parametr) {
        motorState = parametr;
    }

    public void runMotor(){
        System.out.println("You push run Motor.");
        updateMotorState(true);
        System.out.println("Motor run is: " + getMotorState());
    }

    public void stopMotor(){
        System.out.println("You push stop Motor.");
        updateMotorState(false);
        System.out.println("Motor run is: " + getMotorState());
    }

    private void updateStateCar(boolean state){
        stateCar = state;
        if(state == true){
            System.out.println("Car is stop: " + getStateCar());
        } else {
            System.out.println("Car is run: " + !getStateCar());
        }
    }

    public void runTheCar(){
        System.out.println("You start. ");
        updateStateCar(false);
    }

    public void stopTheCar(){
        System.out.println("You stop. ");
        updateStateCar(true);
    }
}