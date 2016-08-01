package lesson8.part_05.frame_04.demo;
import java.io.*;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.lang.Math.E;
import static javafx.scene.input.KeyCode.T;
public class SimpleList <T> implements List {

    private File file;
    private int size;
    private LinkedList<T> list = null;

    public SimpleList() {
        setSize(0);
        SimpleDateFormat formatter = new SimpleDateFormat("EEE_MMM_d_hh_mm_ss");
        Date currentTime_1 = new Date();
        setFile(new File(formatter.format(currentTime_1) + ".txt"));
        try {
            Files.createFile(getFile().toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SimpleList(String filePath) throws IOException {


        if(getFile() == null){
            setFile(new File(filePath));
            Files.createFile(getFile().toPath());
        }

        if (Files.exists(new File(filePath).toPath())) {
            this.setFile(new File(filePath));
            this.setSize(this.getSizeFromFile(this.getFile()));
        } else {

            System.out.println("File " + filePath + " wasn't found");
            throw new FileNotFoundException();
        }

    }


    public LinkedList<T> getList() {
        return list;
    }

    public void setList(LinkedList<T> list) {
        this.list = list;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


    @Override
    public int size() {
        return getSize();
    }

    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }

    @Override
    public boolean contains(Object o) {
        LinkedList<T> list = this.toLL();
        return list.contains(o);
    }

    @Override
    public Iterator iterator() {
        this.setList(this.toLL());
        return getList().iterator();
    }

    @Override
    public Object[] toArray() {
        LinkedList<T> list = this.toLL();
        return list.toArray();
    }

    @Override
    public boolean add(Object o) {
        LinkedList<T> list;

        if (this.getSize() == 0) {
            list = new LinkedList<>();
        } else {
//            System.out.println(this.getSize());
//            System.out.println("else");
            list = this.toLL();
        }
        list.add((T) o);
        this.updateFile(list);
        setSize(getSize() + 1);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        LinkedList<T> list = this.toLL();
        if (list.remove((T) o)) {
            this.updateFile(list);
            setSize(getSize() - 1);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean addAll(Collection c) {

        LinkedList<T> list = this.toLL();
        if (list.addAll(c)) {
            this.updateFile(list);
            setSize(getSize() + c.size());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean addAll(int index, Collection c) {

        LinkedList<T> list = this.toLL();
        if (list.addAll(index, c)) {
            this.updateFile(list);
            setSize(getSize() + c.size());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void clear() {
        this.getFile().delete();
        try {
            Files.createFile(this.getFile().toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setSize(0);
    }

    @Override
    public Object get(int index) {
        if (index >= this.getSize()) {
            System.out.println("Index out of range: entered index - " + index + ",  List range - from 0 to " + (this.getSize()-1));
            return null;
        } else {
            LinkedList<T> list = this.toLL();
            return list.get(index);
        }
    }

    @Override
    public Object set(int index, Object element) {

        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }


    public LinkedList<T> toLL() {
        if (this.isEmpty()) {
            return null;
        } else {
            LinkedList<T> list = new LinkedList<>();
            try (FileInputStream fis = new FileInputStream(this.getFile());
                 ObjectInputStream ois = new ObjectInputStream(fis)) {
                while (fis.available() > 0) {
                    list.add((T) ois.readObject());
                }

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            return list;
        }

    }

    public int getSizeFromFile(File file){
        LinkedList<T> list = new LinkedList<>();
        try (FileInputStream fis = new FileInputStream(this.getFile());
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            while (fis.available() > 0) {
                list.add((T) ois.readObject());
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list.size();
    }

    public void updateFile(LinkedList<T> list) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(this.getFile()))) {
            for (int i = 0; i < list.size(); i++) {
                oos.writeObject(list.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws IOException {
        String fileName = "list.txt";
        String path = "/src/lesson8/part_05/frame_04/demo/";
        SimpleList<String> l = new SimpleList<>(System.getProperty("user.dir") + (path + fileName).replace("/", File.separator));
        l.add("122");
        l.add("202");
        l.remove("202");
        Iterator i = l.iterator();
        while (i.hasNext()){
            System.out.println(i.next());
        }
        System.out.println(l.get(2));
    }
}