package lesson8.part_05.frame_04;

import java.io.*;
import java.util.ArrayList;

public class Replace {

    private String fileName = "list.txt";
    private String path = "/src/lesson8/part_05/frame_04/demo/";
    private ArrayList<String> memoryStorege;
    private File file;
    private boolean hasEmpty = false;

    public Replace() {
        file = new File(System.getProperty("user.dir") + (path + fileName).replace("/", File.separator));
        memoryStorege = new ArrayList<>();
        reloadMemory();
    }

    private void stateEmptyLine() {
        try (
                BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()), 512)
        ) {
            String line = null;
            while ((line = br.readLine()) != null) {
                if (line.trim().equals("")) {
                    hasEmpty = true;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(String data) {
        writeToFile(data);
        writeToMemory(data);
    }

    private void writeToFile(String data) {
        if (hasEmpty) {
            writeToEmpty(data);
        } else {
            writeToEndFile(data);
        }
    }

    private void writeToEmpty(String data) {
        long nextPozition = 0;
        long lastPozition = 0;
        StringBuilder sb = new StringBuilder();

        try (
                RandomAccessFile f = new RandomAccessFile(file.getAbsolutePath(), "rw");
        ) {
            String str = "";
            while ((str = f.readLine()) != null) {
                nextPozition = f.getFilePointer();

                if (str.trim().equals("") && hasEmpty) {
                    long poz = nextPozition - lastPozition;
                    f.seek(poz);
                    if (str.length() < data.length()) {
                        f.setLength(f.length() + data.length() - str.length());
                    }
                    sb.append(data);
                    hasEmpty = false;
                } else {
                    sb.append(str);
                    sb.append("\n");
                }

                lastPozition = nextPozition;
            }
            f.getChannel().position(0);
            f.write(sb.toString().getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeToEndFile(String data) {

        try (
                FileWriter fw = new FileWriter(file.getAbsolutePath(), true);
                BufferedWriter bw = new BufferedWriter(fw)
        ) {
            if (fileSize() > 0) {
                bw.newLine();
            }
            bw.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
                if (!line.trim().equals("")) {
                    rez.add(line);
                } else {
                    hasEmpty = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rez;
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
        if (fileExist(file)) {
            printColection();
            printFile();
        } else {
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
        if (memoryStorege.contains(data)) {
            memoryStorege.remove(getIndexObjectInMemory(data));
        }
    }

    private void removeInFile(String data) {
        long nextPozition = 0;
        long lastPozition = 0;

        try (
                RandomAccessFile f = new RandomAccessFile(file.getAbsolutePath(), "rw");
        ) {
            String str = "";
            while ((str = f.readLine()) != null) {
                nextPozition = f.getFilePointer();

                if (str.trim().equals(data)) {
                    long poz = nextPozition - lastPozition;
                    f.seek(poz);
                    String dataNex = "";
                    for (int i = 0; i < data.length(); i++) {
                        dataNex = dataNex + " ";
                    }
                    str = str.replaceAll(data, dataNex);
                    f.write(str.getBytes());
                    break;
                }
                lastPozition = nextPozition;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        stateEmptyLine();
    }

    private int getIndexObjectInMemory(String data) {
        return memoryStorege.indexOf(data);
    }

    public boolean isHasEmpty() {
        return hasEmpty;
    }
}
