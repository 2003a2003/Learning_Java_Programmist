package lesson7.part_01.frame_07;

public class ReckCobra extends Pistols {

    private String caliber;

    public ReckCobra() {
    }

    public String getCaliber() {
        return caliber;
    }

    public void setCaliber(String caliber) {
        this.caliber = caliber;
    }

    @Override
    public String toString() {
        return getModel();
    }
}
