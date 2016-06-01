package lesson6.part_01.v1;

import lesson6.part_01.v1.calc.Calculator;

import java.util.Random;

public class Launcher {

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        Operations o = new Operations();
        o.setCalc(calc);

        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            System.out.println(o.createSummaryReport(r.nextInt(100)));
        }
    }
}
