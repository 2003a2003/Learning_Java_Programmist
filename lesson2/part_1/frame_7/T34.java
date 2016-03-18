package lesson2.part_1.frame_7;

public class T34 extends Tank {

    public T34(){
        setModel(toString());
        setCrew(4);
        setMaxSpeed(50);
        setColor(Color.AMARANTH);
    }

    @Override
    public void move(){
        System.out.println("Tank " + toString() + " is move.....\n");
    }

    @Override
    public String toString() {
        return "T34";
    }
}
