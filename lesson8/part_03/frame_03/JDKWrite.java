package lesson8.part_03.frame_03;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class JDKWrite implements FileReader{

    public void write(String data, String fileName) {
        try (
                FileOutputStream fos = new FileOutputStream(fileName);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fos, StandardCharsets.UTF_8)
        ) {
            outputStreamWriter.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
