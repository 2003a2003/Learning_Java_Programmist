package lesson8.part_03.frame_05;

import java.io.*;
import java.util.zip.*;

public class DemoZipUnZip {

    private static int buffer = 2048;

    public static void main(String[] args) {

        String inputName = "f:\\Java\\Learning_Java_Programmist\\src\\lesson8\\part_03\\frame_04\\";
        String oututName = "f:\\Java\\Learning_Java_Programmist\\src\\lesson8\\part_03\\frame_05\\zipUnZip\\my_first_archive.zip";
        System.out.println("Add to zip archive start: " + "\n" + inputName);
        zip(inputName, oututName);

        inputName = "f:\\Java\\Learning_Java_Programmist\\src\\lesson8\\part_03\\frame_05\\zipUnZip\\my_first_archive.zip";
        oututName = "f:\\Java\\Learning_Java_Programmist\\src\\lesson8\\part_03\\frame_05\\zipUnZip\\";
        System.out.println("\nExtract files start.");
        unZip(inputName, oututName);
    }

    public static void zip(String inputName, String outputName) {
        try {
            ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(outputName), buffer));

            byte[] data = new byte[buffer];

            File f = new File(inputName + ".");
            String files[] = f.list();

            for (int i = 0; i < files.length; i++) {

                System.out.println("File adding: " + files[i]);
                BufferedInputStream origin = new BufferedInputStream(new FileInputStream(inputName + "\\" + files[i]), buffer);

                ZipEntry entry = new ZipEntry(files[i]);
                out.putNextEntry(entry);

                int count;
                while ((count = origin.read(data, 0, buffer)) != -1) {
                    out.write(data, 0, count);
                }

                origin.close();
            }

            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(" - Zip archive was create. - ");
    }

    public static void unZip(String inputName, String outputName) {
        try {

            ZipInputStream zis =
                    new ZipInputStream(new BufferedInputStream(new FileInputStream(inputName), buffer));

            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null){
                System.out.println("Extracting: " + entry);
                BufferedOutputStream bos =
                        new BufferedOutputStream(new FileOutputStream(outputName + entry.getName()), buffer);

                byte[] data = new byte[buffer];
                int count;
                while ((count = zis.read(data,0,buffer)) != -1){
                    bos.write(data, 0 , count);
                }
                bos.flush();
                bos.close();
            }
            zis.close();
            System.out.println(" - Extract Zip archive was  done. - ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
