package lesson8.part_05.frame_04;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class FileSimlpeList<T> implements SimpleList<T>{

    private File file;
    private String fileName = "list.txt";
    private String path = "/src/lesson8/part_05/frame_03/";
    private boolean emplyLine;

    public FileSimlpeList() {
        createFile();
        emplyLine = false;
    }




    //create file
    private void createFile(){
        file = new File(System.getProperty("user.dir") + (path + fileName).replace("/", File.separator));
        try {
            if(!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int checkEmplyLine(){
        if(file.exists() && file.length() > 0){

        }

        return -1;
    }

//    http://strongexperts.narod.ru/ru/articles/archive/java2/2006/may2006-001/may2006-001.htm

    private void addToFile(T object){



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
