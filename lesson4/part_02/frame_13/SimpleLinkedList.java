package lesson4.part_02.frame_13;

import java.util.Iterator;

public class SimpleLinkedList implements Iterable<Object> {
    private Node root;
    private int size;

    public SimpleLinkedList() {
        size = 0;
    }

    public void addFirst(Object obj) {
        Node n = new Node();
        n.obj = obj;
        if (root != null) {
            n.node = root;
        }
        root = n;
        size++;
    }

    public void addLast(Object obj) {
        Node n = new Node();
        n.obj = obj;

        if (root == null) {
            root = n;
        } else {
            //           Node last = root;
            Node cp = root;
            while (cp.node != null) {
                //               last = cp;
                cp = cp.node;
            }
            cp.node = n;
        }
        size++;
    }

    public void addAfter(Object obj, Object prev) {

        if (prev == null) {
            throw new IllegalStateException("This object is NULL!!!");
        }

        Node n = new Node();
        n.obj = obj;
        Node cp = root;

        for (int i = 0; i < size; i++) {
            if (cp.obj == prev) {
                if (cp.node != null) {
                    n.node = cp.node;
                }
                cp.node = n;
                size++;
                return;
            }
            cp = cp.node;

        }
        throw new IllegalStateException("This list don't have a search object!!! - " + prev);
    }

    public int getSize() {
        return size;
    }

    private class Node {
        private Object obj;
        private Node node;
    }

    public void remove(Object obj) {

        Node cp = root;
        Node pred = root;

        for (int i = 0; i < size; i++) {
            if (cp.obj == obj) {
                pred.node = cp.node;
                size--;
                return;
            }
            pred = cp;
            cp = cp.node;
        }
        throw new IllegalStateException("Cann't search object");
    }

    @Override
    public Iterator<Object> iterator() {
        return new SLLIterator();
    }

    private class SLLIterator implements Iterator<Object> {

        private Node prev;
        private Node cp;

        public SLLIterator() {
        }

        @Override
        public void remove() {
            if (!hasNext() && prev == null) {
                //only one element
                cp = null;
                root = null;
            } else if (!hasNext() && prev != null) {
                //last element
                prev.node = null;
                cp = null;
            }else if(hasNext() && prev == null){
                //first element
                root = cp.node;
                cp = root;
            }else{
                //middle element
                prev.node = cp.node;
                cp = cp.node;
            }
            size--;
        }

        @Override
        public boolean hasNext() {
            return (cp == null && root != null) || (cp != null && cp.node != null);
        }

        @Override
        public Object next() {
            if (root != null && cp == null) {
                //first
                cp = root;
                return cp.obj;
            }
            if (hasNext()) {
                prev = cp;
                cp = cp.node;
                return cp.obj;
            }
            throw new IllegalStateException("List has no more elements.");
        }
    }

    public void printList() {
        if (size == 0) {
            System.out.println("List is empty...");
        }
        System.out.print("[ ");
        Node cp = root;

        while (cp.node != null) {
            System.out.print(cp.obj + ". ");
            cp = cp.node;
        }

        System.out.print(cp.obj);
        System.out.println(" ]");
    }
}
