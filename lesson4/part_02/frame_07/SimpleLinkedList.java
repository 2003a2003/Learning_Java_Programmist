package lesson4.part_02.frame_07;

public class SimpleLinkedList<S> {
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
        Node second = new Node();
        second.obj = obj;
        if (root != null) {
            Node first = root;
            while (first.node != null) {
                first = first.node;
            }
            first.node = second;
            second.obj = obj;
        } else {
            root.obj = obj;
        }
        size++;
    }

    public void addAfter(Object obj, Object prev) {

    }

    public int getSize() {
        return size;
    }

    private class Node {
        Object obj;
        Node node;
    }

    public Node getRoot() {
        return root;
    }

    private void setRoot(Node root) {
        this.root = root;
    }

    public void updateSize(int size) {
        this.size += size;
    }
}
