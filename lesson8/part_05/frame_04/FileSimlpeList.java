package lesson8.part_05.frame_04;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class FileSimlpeList<T> implements SimpleList<T> {

    private File file;
    private String fileName = "list.txt";
    private String path = "/src/lesson8/part_05/frame_04/";
    private boolean emplyLine;
    private int pozToAddOnEmplyPlace;

    public FileSimlpeList() {
        file = new File(System.getProperty("user.dir") + (path + fileName).replace("/", File.separator));
        //createFile();
        emplyLine = false;
    }

    //create file
    private void createFile() {
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int checkEmplyLine() {
        ArrayList<T> temp = readFile();
        int index = 0;
        for (Object o : temp) {
            if(o.equals("")){
                pozToAddOnEmplyPlace = index;
                return pozToAddOnEmplyPlace;
            }
            index++;
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
            String str;
            while ((str = br.readLine()) != null) {
                rez.add((T) str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return rez;
    }

    public void writeToFile(String data) {
        ArrayList<T> temp = readFile();

        try (
                BufferedWriter bw = new BufferedWriter(new FileWriter(file, true), 512)
        ) {
            boolean hasEmpty = false;
            for (Object o: temp) {
                if(o.equals("")){
                    hasEmpty = true;

                }
            }



            bw.append(data);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeDateFromName() {

    }

    public void removeDateForName() {

    }

    public void print() {
        int index = 1;
        ArrayList<T> print = readFile();
        for (Object o : print) {
            System.out.println(index++ + ") " + o);

        }
    }

    public boolean chackExistFile(){
        boolean res;
        if(file.exists()){
            chackEmplyPlase();
            res = true;
        }else {
            res = false;
            emplyLine = false;
        }
        return res;
    }

    public int chackEmplyPlase(){




        return -1;
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
