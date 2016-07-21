package lesson8.part_05.frame_04;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class FileSimlpeList<T> implements SimpleList<T> {

    private File file;
    private String fileName = "list.txt";
    private String path = "/src/lesson8/part_05/frame_04/";
    private boolean emplyLine;
    private boolean fileExists;

    public FileSimlpeList() {
        checkExistsFile();
        createFile();
        emplyLine = false;
    }

    private boolean checkExistsFile() {
        boolean rez;
        if (file.exists()) {
            rez = true;
        } else {
            rez = false;
        }

        return rez;
    }

    //create file
    private void createFile() {
        file = new File(System.getProperty("user.dir") + (path + fileName).replace("/", File.separator));
        try {

            if (!checkExistsFile()) {
                file.createNewFile();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int checkEmplyLine() {
        if (file.exists() && file.length() > 0) {

        }

        return -1;
    }

//    http://strongexperts.narod.ru/ru/articles/archive/java2/2006/may2006-001/may2006-001.htm

    private void addToFile(T object) {


    }

    public ArrayList<T> readFile() {
        ArrayList<T> rez = new ArrayList<>();

        try (
                BufferedReader br = new BufferedReader(new FileReader(file), 512)
        ) {

            while (br.readLine() != null) {
                rez.add((T) br.readLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return rez;
    }

    public void writeFile(String data) {
        try (
                BufferedWriter bw = new BufferedWriter(new FileWriter(file, true), 512)
        ) {

            if(checkExistsFile()) {
                bw.newLine();
            }
            bw.append(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(T object) {

    }

    @Override
    public boolean contains(T object) {
        return false;
    }

    @Override
    public void remove(T object) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
