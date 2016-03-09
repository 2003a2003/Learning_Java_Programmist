package lesson2.part_1.frame_7;

public class Tiger extends Tank {

    private int armor;

    public Tiger(){

        setModel(toString());
        setCrew(5);
        setMaxSpeed(36);
        setColor(Color.GRAY);
        setArmor(1);
    }

    public int getArmor() {
        return armor;
    }

    private void setArmor(int armor) {
        this.armor = armor;
    }

    //@Override
    public void prinTankInfo(){
        System.out.println("Model of Tank: " + toString() + ", Crew: " + getCrew() +
                ", Max speed: " + getMaxSpeed() + ", Color: " + getColor() + ", Armor: " + getArmor());
    }

    @Override
    public void move(){
        System.out.println("Tank " + toString() + " is move.....\n");
    }

    @Override
    public String toString() {
        return "Tiger";
    }
}
