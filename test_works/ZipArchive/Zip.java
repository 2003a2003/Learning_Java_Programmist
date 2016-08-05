package test_works.ZipArchive;

import java.io.*;
import java.util.zip.*;

public class Zip {
    private final int BUFFER = 2048;
    private File outFile;
    private File fileZip;
    private File fileDest;

    public void toZip() {

        String destFile = fileDest.getAbsolutePath();
        String partToZip = fileZip.getAbsolutePath();

        try {
            BufferedInputStream origin = null;
            FileOutputStream dest = new FileOutputStream(destFile);
            CheckedOutputStream checksum = new CheckedOutputStream(dest, new Adler32());
            ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(checksum));

            byte data[] = new byte[BUFFER];

            File f = new File(fileZip.getAbsolutePath() + ".");
            String files[] = f.list();

            for (int i = 0; i < files.length; i++) {
                System.out.println("Adding: " + partToZip + "\\" + files[i]);
                FileInputStream fi = new FileInputStream(partToZip + "\\" + files[i]);
                origin = new BufferedInputStream(fi, BUFFER);
                ZipEntry entry = new ZipEntry(files[i]);
                out.putNextEntry(entry);
                int count;
                while ((count = origin.read(data, 0, BUFFER)) != -1) {
                    out.write(data, 0, count);
                }
                origin.close();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void toUnZip() {
        String partDest = fileDest.getParent() + "\\";
        try {
            BufferedOutputStream dest = null;
            FileInputStream fis = new FileInputStream(fileDest);
            CheckedInputStream checksum = new CheckedInputStream(fis, new Adler32());
            ZipInputStream zis = new ZipInputStream(new BufferedInputStream(checksum));
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                System.out.println("Extracting: " + entry);
                int count;
                byte data[] = new byte[BUFFER];
                FileOutputStream fos = new FileOutputStream(partDest + entry.getName());
                dest = new BufferedOutputStream(fos, BUFFER);
                while ((count = zis.read(data, 0, BUFFER)) != -1) {
                    dest.write(data, 0, count);
                }
                dest.flush();
                dest.close();
            }
            zis.close();
            System.out.println("Checksum: " + checksum.getChecksum().getValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getBUFFER() {
        return BUFFER;
    }

    public File getOutFile() {
        return outFile;
    }

    public void setOutFile(File outFile) {
        this.outFile = outFile;
    }

    public File getFileZip() {
        return fileZip;
    }

    public void setFileZip(File fileZip) {
        this.fileZip = fileZip;
    }

    public File getFileDest() {
        return fileDest;
    }

    public void setFileDest(File fileDest) {
        this.fileDest = fileDest;
    }
}
