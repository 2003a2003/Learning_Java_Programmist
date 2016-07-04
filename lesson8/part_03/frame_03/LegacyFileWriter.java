package lesson8.part_03.frame_03;

import java.io.FileOutputStream;
import java.io.IOException;

public class LegacyFileWriter implements FileReader {

    public void write(String data, String fileName) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(fileName);
            fos.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    //ignore
                }
            }
        }
    }
}
