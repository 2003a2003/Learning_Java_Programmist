package lesson7.part_01.frame_03;

public class DemoBox {
    static int id = 0;

    public static void main(String[] args) {

        Box<Pistols> allGun = new Box<>();

        Box<Makarov> gumMakarov = new Box<>();
        Box<ReckCobra> gunReckCobra = new Box<>();

        Makarov mak01 = new Makarov();
        setMakarov(mak01);

        ReckCobra rk01 = new ReckCobra();
        setReckCobra(rk01);

        allGun.setObj(mak01);
        allGun.setObj(rk01);
        allGun.setObj(mak01);

        allGun.printAllBox();

    }

    private static void setReckCobra(ReckCobra rk01) {
        rk01.setId(id);
        rk01.setModel("Reck Cobra");
        rk01.setPrice(300);
        rk01.setCaliber("9 mm");
    }

    public static void setMakarov(Makarov makarov){
        makarov.setId(id);
        makarov.setModel("Makarov");
        makarov.setPrice(500);
        makarov.setMagazine(6);
        id++;
    }
}
