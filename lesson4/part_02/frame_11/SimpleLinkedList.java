package lesson4.part_02.frame_11;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

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
            throw new IllegalStateException("This list don't have a search object!!!");
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

    @Override
    public Iterator<Object> iterator() {
        return new SLLIterator();
    }

    private class SLLIterator implements Iterator<Object> {

        protected Node cp;

        @Override
        public boolean hasNext() {
            if (cp != null && cp.node != null) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {

            if (root != null && cp == null) {
                cp = root;
                return cp.obj;
            }

            if(hasNext()){
                cp = cp.node;
                return cp.obj;
            }

            return cp.obj;
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
