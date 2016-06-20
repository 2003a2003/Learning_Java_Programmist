package lesson7.part_01.frame_07;

public class DemoBox {
    static int id = 0;

    public static void main(String[] args) {

        Box<Pistols> allGun = new Box<>();

        Box<Makarov> gunMakarov = new Box<>();
        Box<ReckCobra> gunReckCobra = new Box<>();

        Makarov mak01 = new Makarov();
        setMakarov(mak01);

        ReckCobra rk01 = new ReckCobra();
        setReckCobra(rk01);

        Makarov mak02 = new Makarov();
        setMakarov(mak02);

        allGun.addObject(mak01);
        allGun.addObject(rk01);
        allGun.addObject(mak01);
        allGun.addObject(mak01);
        allGun.addObject(mak01);


        Integer i = new Integer(1);

        gunMakarov.addObject(mak01);
        //error
//        gunMakarov.addObject(rk01);

        gunReckCobra.addObject(rk01);
        //error
        //gunReckCobra.addObject(mak01);

        allGun.getAllBox();
        allGun.removeObjByIndex(1);
        allGun.removeObjFirst(mak01);

        allGun.removeObjFirst(mak02);

        System.out.println("**************************");
        allGun.getAllBox();

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
