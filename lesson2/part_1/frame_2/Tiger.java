package lesson2.part_1.frame_2;

public class Tiger extends Tank{

    private int armor;

    public Tiger(){

        setModel("Tiger");
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

    @Override
    public void prinTankInfo(){
        System.out.println("Model of Tank: " + getModel() + ", Crew: " + getCrew() +
                ", Max speed: " + getMaxSpeed() + ", Color: " + getColor() + ", Armor: " + getArmor());
    }
}
