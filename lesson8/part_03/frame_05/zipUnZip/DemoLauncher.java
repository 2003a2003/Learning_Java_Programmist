package lesson8.part_03.frame_04;

import java.io.*;

public class DemoLauncher {

    public static void main(String[] args) {
        System.out.println("Print to console.");
        PrintStream console = System.out;

        String fileName = "print_to_file_out.txt";
        String path = "/src/lesson8/part_03/frame_04/";

        File file = new File(System.getProperty("user.dir") + (path + fileName).replace("/", File.separator));

        try (
                FileOutputStream fos = new FileOutputStream(file);
                PrintStream psconsole = new PrintStream(fos)
        ) {

            System.setOut(psconsole);
            System.out.println("This goes to " + fileName);
            System.out.println("Some text to console");

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.setOut(console);
        System.out.println("Also print to console.");
    }
}
