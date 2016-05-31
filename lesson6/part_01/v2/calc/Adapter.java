package lesson6.part_01.v2.calc;

import lesson6.part_01.Arifmetika;

public class Adapter extends Arifmetika implements Calculator {

    @Override
    public int summa(int a, int b) {
        return super.summa(new int[]{a,b} );
    }

    @Override
    public int multiply(int a, int b) {
        return super.multiply(a,b);
    }
}
