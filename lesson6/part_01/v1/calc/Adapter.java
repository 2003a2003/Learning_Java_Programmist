package lesson6.part_01.v1.calc;

import lesson6.part_01.Arifmetika;

public class Adapter extends Calculator{

    private Arifmetika arf;

    public Adapter() {
        arf = new Arifmetika();
    }

    @Override
    public int summa(int a, int b) {
        return arf.summa(new int[]{a,b});
    }

    @Override
    public int multiply(int a, int b) {
        return arf.multiply(a,b);
    }
}
