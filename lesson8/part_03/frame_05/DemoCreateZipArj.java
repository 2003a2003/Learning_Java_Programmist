package lesson8.part_03.frame_05;

import java.io.*;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class DemoCreateZipArj {

    public static void main(String[] args) throws IOException {

        String path = System.getProperty("user.dir") + "/src/lesson8/part_03/frame_03/read".replace("/", File.separator);
        String nameDirOrFileAddToZip = path + "";

        File file = new File(nameDirOrFileAddToZip);

        if (!file.exists()) {
            System.out.println("\nNot found: " + file);
            System.exit(0);
        }

        String[] sDirList;
        if(file.isDirectory()) {
            sDirList = file.list();
        }else {
            sDirList = new String[]{file.getName()};
        }

        ZipOutputStream zos = createZipOutputStream("!temp.zip");

        int i;
        try {
            for (i = 0; i < sDirList.length; i++) {
                File f1 = new File(nameDirOrFileAddToZip + File.separator + sDirList[i]);
                if (f1.isFile()) {
                    addFileToZip(zos, nameDirOrFileAddToZip + File.separator, sDirList[i]);
                }
            }
            zos.close();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    public static ZipOutputStream createZipOutputStream(String szPath) {
        File tempfile = null;
        ZipOutputStream zos = null;

        try {
            tempfile = new File(szPath);
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        try {
            zos = new ZipOutputStream(new FileOutputStream(tempfile));
            zos.setLevel(Deflater.DEFAULT_COMPRESSION);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return zos;
    }

    static void addFileToZip(ZipOutputStream zos, String szPath, String szName) throws Exception {
        System.out.print(szPath + szName);
        ZipEntry ze;
        ze = new ZipEntry(szName);
        zos.putNextEntry(ze);

        FileInputStream fis = new FileInputStream(szPath + szName);

        byte[] buf = new byte[8000];
        int nLength;
        while (true) {
            nLength = fis.read(buf);
            if (nLength < 0)
                break;
            zos.write(buf, 0, nLength);
        }
        fis.close();
        zos.closeEntry();

        long nSize = ze.getSize();
        long nCompressedSize = ze.getCompressedSize();
        long nPercent = 100 - ((nCompressedSize * 100) / nSize);
         System.out.println(" " + nSize + " (" + nCompressedSize + ") " + nPercent + "%");

    }
}