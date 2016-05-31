package lesson6.part_01.v1.calc;

import lesson6.part_01.Arifmetika;

public class Adarter extends Calculator{

    private Arifmetika arf;

    public Adarter() {
        arf = new Arifmetika();
    }

    @Override
    public int summa(int a, int b) {
        return arf.summa(new int[]{a,78});
    }

    @Override
    public int multiply(int a, int b) {
        return arf.multiply(a,b);
    }
}
