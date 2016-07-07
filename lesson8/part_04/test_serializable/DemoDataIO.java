package lesson8.part_04.test_serializable;

import java.io.*;

public class DemoDataIO {

    public static void main(String[] args) throws Exception {
        writeToFile("output.dat");
        readFromFile("output.dat");
    }

    private static void readFromFile(String file) throws Exception {
        try (
                DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(file)))
        ) {

            System.out.println(dis.readInt());
            System.out.println(dis.readFloat());
            System.out.println(dis.readChar());
        }
    }

    private static void writeToFile(String file) throws Exception {
        try (
                DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)))
        ) {
            dos.writeInt(10);
            dos.writeFloat(25.5f);
            dos.writeChar('b');
        }
    }
}
