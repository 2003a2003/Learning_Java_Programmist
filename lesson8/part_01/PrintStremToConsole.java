package lesson8.part_01;

import java.io.ByteArrayInputStream;

public class PrintStremToConsole {
    public static void main(String[] args) {
        byte[] bytes = {10, 50, 80, -128, 0};
        ByteArrayInputStream in1 = new ByteArrayInputStream(bytes);
        printSreamData(in1);

        bytes = new byte[]{10, 50, 80, -128, 0};
        ByteArrayInputStream in2 = new ByteArrayInputStream(bytes);
        printSreamDataTwo(in2);

    }

    public static void printSreamData(ByteArrayInputStream bais) {
        int j = 0;
        int i;
        while ((i = bais.read()) != -1) {
            System.out.println("byte " + (++j) + " = " + (byte) i);
        }
        System.out.println();
    }

    public static void printSreamDataTwo(ByteArrayInputStream in) {
        int i;
        System.out.print("[ ");
        while ((i = in.read()) != -1) {
            System.out.print((byte) i);
            System.out.print(" ");
        }
        System.out.println(" ]");
    }
}
