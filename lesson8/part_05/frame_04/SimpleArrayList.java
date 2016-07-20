package lesson8.part_05.frame_04;

import java.util.Iterator;

public class SimpleArrayList implements Iterable<Object>{
    private Object[] obj;
    private int size;

    public SimpleArrayList() {
        obj = new Object[5];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    //Add
    public void add(Object object) {
        if (checkSpace()) {
            createNeArraObj();
        }
        obj[size] = object;
        size++;
    }

    public void addFirst(Object object) {
        if (checkSpace()) {
            createNeArraObj();
        }
        System.arraycopy(obj, 0, obj, 1, size + 1);
        obj[0] = object;
        size++;
    }

    public void addByPosition(int pos, Object object) {

        if (checkPosition(pos)) {
            printNotCorrectPosition(pos);
            return;
        }

        if (checkSpace()) {
            createNeArraObj();
        }

        System.arraycopy(obj, pos - 1, obj, pos, size - pos + 1);
        obj[pos - 1] = object;
        size++;
    }

    //Utils
    private boolean checkPosition(int pos) {
        return (pos <= 0) || (pos > size);
    }

    private boolean checkSpace() {
        return !(size + 1 >= obj.length);
    }

    private void createNeArraObj() {
        Object[] tmp = obj;
        obj = new Object[((obj.length - 1) * 3) / 2 + 1];
        System.arraycopy(tmp, 0, obj, 0, size);
    }

    private int getIndex(Object object) {
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (obj[i].equals(object)) {
                index = i;
                return index;
            }
        }
        return -1;
    }

    //Remove
    public void remove(Object object) {
        int index = getIndex(object);
        if (index < 0) {
            printNoObject(object);
            return;
        }
        System.out.println("Remove: " + obj[index].toString());
        System.arraycopy(obj, index + 1, obj, index, size - index - 1);
        size--;
        System.out.println("-------------------------------");
    }

    public void removeByPosition(int pos) {
        if (checkPosition(pos)) {
            printNotCorrectPosition(pos);
            return;
        }
        System.arraycopy(obj, pos, obj, pos - 1, size - (pos - 1) - 1);
        size--;
        System.out.println("-------------------------------");
    }

    //Print
    public void printList() {
        if (size == 0) {
            System.out.println("List is empty...");
        }
        int index = 1;
        for (int i = 0; i < size; i++) {
            System.out.println(index + ". " + obj[i]);
            index++;
        }
        System.out.println("-------------------------------");
    }

    public void printByPositionInList(int pos) {
        if (size == 0) {
            System.out.println("List is empty...");
        }

        if (checkPosition(pos)) {
            printNotCorrectPosition(pos);
        }
        System.out.println(pos + ". " + obj[pos - 1]);
        System.out.println("-------------------------------");
    }

    private void printNotCorrectPosition(int pos) {
        System.out.println("Not correct position: " + pos);
        System.out.println("You can select the position between:  1 and " + size);
        System.out.println("-------------------------------");
    }

    private void printNoObject(Object object) {
        System.out.println("This object: " + object + " no in that list.");
        System.out.println("-------------------------------");
    }


    @Override
    public Iterator<Object> iterator() {
        return new SALIterator();
    }

    private class SALIterator implements Iterator<Object> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return (index < size);
        }

        @Override
        public Object next() {
            if(size != 0 && index < size ){
                return obj[index++];
            }
            throw new IllegalStateException("List has no elements.");
        }
    }
}
