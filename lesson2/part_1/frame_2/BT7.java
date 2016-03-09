package lesson2.part_1.frame_2;

public class BT7 extends Tank {

    public BT7() {
        this("BT7", 3,72,Color.BLACK);
    }

    public BT7(String model, int crew, int maxSpeed, Color color){
        setModel(model);
        setCrew(crew);
        setMaxSpeed(maxSpeed);
        this.setColor(color);
    }
}
