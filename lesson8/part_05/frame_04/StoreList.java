package lesson8.part_05.frame_04;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class StoreList implements SimpleList {

    private String fileName = "list.txt";
    private String path = "/src/lesson8/part_05/frame_04/";
    private ArrayList<String> memoryStorege;
    private File file;
    private int nextElement;
    private long emptyPoz;

    public StoreList() {
        memoryStorege = new ArrayList();
        file = new File(System.getProperty("user.dir") + (path + fileName).replace("/", File.separator));
        restoreStorage();
    }

    private void restoreStorage(){
        if(file.exists()){
           memoryStorege = readFromFile();
           nextElement = memoryStorege.size();
        }else {
            createFile();
        }
    }

    private void addDateToFile(Object data) {
        memoryStorege.add((String) data);

        if (checkEmpty()) {
            writeDateToEmptyPlaceInFole(data);
        } else {
            writeDateToEndFile(data);
        }
    }

    private void writeDateToEndFile(Object data) {
        try (
                BufferedWriter bw = new BufferedWriter(new FileWriter(file, true), 512)
        ) {
            bw.append(nextElement + "_" + data.toString());
            bw.newLine();
            nextElement++;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeDateToEmptyPlaceInFole(Object data) {
        try {
            RandomAccessFile f = new RandomAccessFile(file, "rw");
            long oldSizeFile = f.length();
            long newSizeFile = oldSizeFile + data.toString().length();
            f.setLength(newSizeFile);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private boolean checkEmpty() {
        ArrayList<String> temp = readFromFile();
        boolean res = false;
        int index = 0;
        int posInFile = 0;
        for (Object data : temp) {
            posInFile += data.toString().length();
            if (data.equals("")) {
                res = true;
                emptyPoz = posInFile;
                break;
            }
        }
        return res;
    }

    private ArrayList readFromFile() {
        ArrayList<String> res = new ArrayList<>();

        try (
                BufferedReader br = new BufferedReader(new FileReader(file), 512)
        ) {
            String str;
            while ((str = br.readLine()) != null) {
                if(!str.trim().equals("")) {
                    res.add(str.split("_")[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    private ArrayList readDateFromFile() {
        ArrayList<String> res = new ArrayList<>();

        try (
                BufferedReader br = new BufferedReader(new FileReader(file), 512)
        ) {
            String str;
            while ((str = br.readLine()) != null) {
                res.add(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public void add(Object object) {
        addDateToFile(object);
    }

    @Override
    public boolean contains(Object object) {
        for (Object data: memoryStorege){
            if(data.equals(object)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void remove(Object object) {
        removeDate(object);
    }



    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    private int getObjectPosition(Object object){
        for (int i = 0 ; i < memoryStorege.size(); i++){
            if(memoryStorege.get(i).equals(object)){
                return i;
            }
        }
        return -1;
    }

    private void removeDate(Object object) {
        int index = getObjectPosition(object);

        if(index != -1){
           // memoryStorege.remove(index);
            removeObjectInFile(index);
        }
    }

    private void removeObjectInFile(int index) {
        long indexInFile = 0;
        long size = 0;

        ArrayList<String> temp = readDateFromFile();

        for (int i = 0; i < index; i++ ){
            indexInFile += temp.get(i).length();
            size = temp.get(i).length();
        }

        System.out.println("Index in file: " + indexInFile);

        RandomAccessFile f = null;

        String str = "";
        for (int i = 0; i < size; i++){
            str = str + " ";
        }
        str = str + "\n";

        try {
            f = new RandomAccessFile(file.getAbsolutePath(), "rw");
            f.seek(indexInFile);
            f.write(str.getBytes());

//            int b = f.read();
//            while (b !=-1){
//                str = str + (char)b;
//                b = f.read();
//            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                f.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Print Result: " + str);

    }

    public void print(){
        ArrayList<String> l = readFromFile();
        int index = 1;
        System.out.println("Print storage:");
        for (Object data: memoryStorege){
            System.out.println(index + ", " + data);
            index++;
        }

        l = readDateFromFile();
        System.out.println("Print file:");
        index = 1;
        for (Object data: l){
            System.out.println(index + ", " + data);
            index++;
        }
    }

    private void createFile(){
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
