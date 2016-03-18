package lesson2.part_1.frame_2;

public class Tank {
    private String model;
    private Color color;
    private int crew;
    private int maxSpeed;

    public Tank(){
        this(null,0,0,null);
    }

    public Tank(String model, int crew, int maxSpeed, Color color){
        this.model = model;
        this.crew = crew;
        this.maxSpeed = maxSpeed;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getCrew() {
        return crew;
    }

    public void setCrew(int crew) {
        this.crew = crew;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void prinTankInfo(){
        System.out.println("Model of Tank: " + getModel() + ", Crew: " + getCrew() +
                ", Max speed: " + getMaxSpeed() + ", Color: " + getColor());
    }

    public void fire(){
        System.out.println("Tank " + getModel() + " fire -------------------->");
    }
}
