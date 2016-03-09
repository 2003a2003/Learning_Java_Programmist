package lesson1.part_2.frame_9;
/**
 * Created by otroshenko on 11.02.2016.
 */
public class Tank {
    String color;
    int crew;
    int maxSpeed;

    Tank(String color, int crew, int maxSpeed){
        this.color = color;
        this.crew = crew;
        this.maxSpeed = maxSpeed;
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
        this.maxSpeed = maxSpeed;
    }
}
