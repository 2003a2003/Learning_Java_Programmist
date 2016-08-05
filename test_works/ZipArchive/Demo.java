package test_works.ZipArchive;

import java.io.File;

public class Demo {
    public static void main(String[] args) {
        Zip zip = new Zip();

        String partZip = "f:\\Java\\Learning_Java_Programmist\\src\\lesson8\\part_03\\frame_03\\";
        String partDestZipUnZip = "f:\\Java\\Learning_Java_Programmist\\src\\lesson8\\part_03\\frame_05\\zipUnZip\\";

        String zipFile = "";
        String outFile = "frame_04.zip";

        zip.setFileZip(new File(partZip + zipFile));
        zip.setFileDest(new File(partDestZipUnZip + outFile));
        System.out.println("Add to Zip:");
        zip.toZip();
        //zip.setFileDest(new File(partDestZipUnZip));
        System.out.println("extract:");
        zip.toUnZip();
    }
}
