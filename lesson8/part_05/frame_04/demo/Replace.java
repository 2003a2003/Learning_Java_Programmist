package lesson8.part_05.frame_04.demo;

import java.io.*;
import java.util.ArrayList;

public class Replace {

    private String fileName = "list.txt";
    private String path = "/src/lesson8/part_05/frame_04/demo/";
    private ArrayList<String> memoryStorege;
    private File file;
    private int index;

    public Replace() {
        file = new File(System.getProperty("user.dir") + (path + fileName).replace("/", File.separator));
        memoryStorege = new ArrayList<>();
        reloadMemory();
        restoreIndex();
    }

    public void write(String data) {
        writeToFile(data);
        writeToMemory(data);
    }

    private void writeToFile(String data) {
        try (
                FileWriter fw = new FileWriter(file.getAbsolutePath(), true);
                BufferedWriter bw = new BufferedWriter(fw)
        ) {
            if (fileSize() > 0) {
                bw.newLine();
            }
            bw.write(index + "_" + data.length() + ":" + data);
            index += data.length();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeToFileRendome(String data){



    }

    private void writeToMemory(String data) {
        memoryStorege.add(data);
    }

    private void reloadMemory() {
        if (fileExist(file) && fileSize() > 0) {
            memoryStorege = readFileToRestoreMemory();
        }
    }

    public String readFile() {

        StringBuilder sb = new StringBuilder();

        try (
                BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()), 512)
        ) {
            String line = null;
            while ((line = br.readLine()) != null) {
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                sb.append(line);
//                sb.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public ArrayList readFileToRestoreMemory() {

        ArrayList<String> rez = new ArrayList<>();

        try (
                BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()), 512)
        ) {
            String line = null;
            while ((line = br.readLine()) != null) {
                rez.add(line.split(":")[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rez;
    }

    public void replace(String data, String who) {
        String line = "";
        try (
                BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsolutePath()), 512);
                BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()), 512)
        ) {
            while ((line = br.readLine()) != null) {
                if (line.equals(data)) {
                    bw.write(who);
                }
                bw.write(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean fileExist(File f) {
        if (f.exists()) {
            return true;
        }
        return false;
    }

    private long fileSize() {
        long res = -1;
        if (fileExist(file)) {
            res = file.length();
        }
        return res;
    }

    public void print() {
        if(fileExist(file)) {
            printColection();
            printFile();
        }else {
            System.out.println("Colection not exist......");
        }
    }

    private void printFile() {
        System.out.println("Print File:");
        System.out.println(readFile());
        System.out.println("***************");
    }

    private void printColection() {
        System.out.println("Print Memory:");
        int index = 1;
        for (Object o : memoryStorege) {
            System.out.println(index + ". " + o.toString());
            index++;
        }
        System.out.println("***************");
    }

    public void remove(String data) {
        removeInMemory(data);
        removeInFile(data);
    }

    private void removeInMemory(String data) {
        //memoryStorege.remove(getIndexObjectInMemory(data));
        System.out.println(getIndexObjectInFile(data));

    }

    private void removeInFile(String data) {
        int sizeData = data.length();



    }

    private int getIndexObjectInMemory(String data) {
        return memoryStorege.indexOf(data);
    }

    private long getIndexObjectInFile(String data) {
        long indexInFile = 0;
        for (int i = 0; i < getIndexObjectInMemory(data); i++) {
            indexInFile += memoryStorege.get(i).length();
        }

        if(indexInFile > 0){
            return indexInFile;
        }else {
            return -1;
        }
    }

    private void restoreIndex(){
        if(fileExist(file) && fileSize() > 0){
            index = memoryStorege.size();
        }
    }
}
