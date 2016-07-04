package lesson8.part_03.frame_03;

import java.io.File;

public class DemoLauncher {

    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + "/src/lesson8/part_03/frame_03/files/";
        String file = "test.txt";
        String fileName = path + file;
        fileName.replace("/", File.separator);
        File file_01 = new File(fileName);
        changeEncoding(file_01);

    }

    //    public static void changeEncoding(File file, String currentEncoding, String neededEncoding){
    public static void changeEncoding(File file) {
        System.out.println(file.getPath());

    }
}
