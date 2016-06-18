package lesson7.part_01.frame_06;

public class Makarov extends Pistols {

    private int magazine;

    public Makarov() {
    }

    public int getMagazine() {
        return magazine;
    }

    public void setMagazine(int magazine) {
        this.magazine = magazine;
    }

    @Override
    public String toString() {
        return getModel();
    }
}
