package lesson4.part_02.frame_09;

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

        Node n = new Node();
        n.obj = obj;

        Node cp = root;

        for (int i = 0; i < size; i++) {

            if (cp.obj.equals(prev)) {
                n.node = cp.node;
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
