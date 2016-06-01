package lesson6.part_01;

import com.midgardabc.day9.adapter.math.v1.Operations;
import com.midgardabc.day9.adapter.math.v1.calc.Calculator;

import java.util.Random;

public class Launcher {

	public static void main(String[] args) {
		Calculator calc = new Calculator();
		
		com.midgardabc.day9.adapter.math.v1.Operations o = new Operations();
		o.setCalc(calc);

		Random r = new Random();
		for (int i = 0; i < 5; i++) {
			System.out.println(o.createSummaryReport(r.nextInt(100)));
		}
	}
}
