package lesson8.part_05.frame_04.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class WorkWithFile {
    private RandomAccessFile file;
    private String fileName = "list.txt";
    private String path = "/src/lesson8/part_05/frame_04/";
    private long positionToSave;

    public WorkWithFile() {
        fileName = System.getProperty("user.dir") + (path + fileName).replace("/", File.separator);
        positionToSave = 0;
    }

    public long goTo(int num) throws IOException {
        file = new RandomAccessFile(fileName, "r");
        file.seek(num);
        positionToSave = file.getFilePointer();
        file.close();

        return positionToSave;
    }

    public void emplyPlase(RandomAccessFile f) throws IOException {
        int b = f.read();
        int index =0;
        while (b != -1) {
            char s = (char) b;
            if (s == '\n') {
                index++;
                if(index > 1) {
                    positionToSave = f.getFilePointer();
                    System.out.println(positionToSave);
                    return;
                }
                //file.close();

            }
            b = f.read();
        }
        //file.close();

    }

    public String read() throws IOException {
        file = new RandomAccessFile(fileName, "r");
        String res = "";
        int b = file.read();
        while (b != -1) {
            res = res + (char) b;
            b = file.read();
        }
        file.close();

        return res;
    }

    public String readFrom(int numberSymbol) throws IOException {
        file = new RandomAccessFile(fileName, "r");
        String res = "";
        file.seek(numberSymbol);
        int b = file.read();
        while (b != -1) {
            res += (char) b;
            b = file.read();
        }
        file.close();

        return res;
    }

    public void write(String str) throws IOException {
        file = new RandomAccessFile(fileName, "rw");
        String data = str + "\n";
        emplyPlase(file);
        file.seek(positionToSave);
        file.write(data.getBytes());
        positionToSave = file.getFilePointer();
        file.close();
    }

    public long getPositionToSave() {
        return positionToSave;
    }

    public void setPositionToSave(long positionToSave) {
        this.positionToSave = positionToSave;
    }
}