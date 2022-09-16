package DataStructures;

public class LinkedList {

    private int size;
    private Node head;

    public LinkedList() {
        head = new Node(null);
        clear();
    }

    public boolean add(Object val) {
        insertBefore(val, head);
        return true;
    }

    public boolean remove(Object val) {
        for (Node p = head.next; p != head; p = p.next) {
            if (p.value.equals(val)) {
                removeAt(p);
                return true;
            }
        }
        return false;
    }

    public Object get(int pos) {
        if (pos < 0 || pos > size)
            throw new IndexOutOfBoundsException();
        return getAt(pos).value;
    }

    public void clear() {
        head.next = head;
        head.prev = head;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void insertBefore(Object val, Node p) {
        Node node = new Node(val);
        node.next = p;
        node.prev = p.prev;
        p.prev.next = node;
        p.prev = node;
        size++;
    }

    private void removeAt(Node p) {
        p.prev.next = p.next;
        p.next.prev = p.prev;
        size--;
    }

    private Node getAt(int pos) {
        Node p = head.next;
        for (; pos > 0; pos--)
            p = p.next;
        return p;
    }

    private class Node {
        Object value;
        Node next, prev;

        Node(Object value) {
            this.value = value;
        }
    }

}
