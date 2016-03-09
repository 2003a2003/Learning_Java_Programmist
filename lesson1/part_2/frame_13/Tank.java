package lesson1.part_2.frame_13;

/**
 * Created by otroshenko on 11.02.2016.
 */

public class Tank {

    private String model;
    private String color;
    private int crew;
    private int maxSpeed;

    public Tank() {
        this(null, null, 0, 0);
    }

    public Tank(String model, String color, int crew, int maxSpeed) {
        this.model = model;
        this.color = color;
        this.crew = crew;
        setMaxSpeed(maxSpeed);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
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
        if (maxSpeed > 200) {
            this.maxSpeed = 200;
        } else {
            this.maxSpeed = maxSpeed;
        }
    }
}