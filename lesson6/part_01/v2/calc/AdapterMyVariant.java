package lesson6.part_01.v2.calc;

import lesson6.part_01.Arifmetika;

public class AdapterMyVariant implements Calculator{

    @Override
    public int summa(int a, int b) {
        return Arifmetika.summa(new int[]{a, b});
    }

    @Override
    public int multiply(int a, int b) {
        int result = a;
        for (int i = 0; i < b; i++){
            result = Arifmetika.summa(new int[]{result, a});
        }
        return result;
    }
}
