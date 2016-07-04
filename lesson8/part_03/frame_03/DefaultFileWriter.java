package lesson8.part_03.frame_03;

import java.io.FileOutputStream;
import java.io.IOException;

public class DefaultFileWriter implements FileReader{

    public void write(String data, String fileName) {
        try (
                FileOutputStream fos = new FileOutputStream(fileName)
        ) {
            fos.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
