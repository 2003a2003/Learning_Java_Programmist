package lesson8.part_05.frame_04;

import java.util.Iterator;

public interface SimpleList<T> {

    public void add(T object);

    public boolean contains(T object);

    public void remove(T object);

    public int size();

    public Iterator<T> iterator();
}
