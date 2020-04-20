public class LinkedListDeque<T> {
    private Node sentinel; //circular
    private int size;

    private class Node {
        public Node prev;
        public T item;
        public Node next;

        public Node (Node p, T value, Node n) {
            prev = p;
            item = value;
            next = n;
        }
    }

    /**
    public LinkedListDeque (T value) {
        //sentinel = new Node(null, (T)63, null);//use 'null' if (T) does not work
        sentinel = new Node(null, null, null);
        Node L = new Node(sentinel, value, sentinel);
        //L.prev = sentinel;
        //L.next = sentinel;
        sentinel.prev = L;
        sentinel.next = L;
        size = 1;
        //sentinel.prev = L.next;
        //sentinel.next = L.prev;
    }
     */


    public LinkedListDeque () {
        //sentinel = new Node(null, (T)63, null);//use 'null' if (T) does not work
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }


    public void addFirst (T value) {
        Node oldFirstNode = sentinel.next;
        Node newFirstNode = new Node(null, value, null);

        newFirstNode.prev = sentinel;
        newFirstNode.next = oldFirstNode;
        oldFirstNode.prev = newFirstNode;
        sentinel.next = newFirstNode;
        size += 1;
    }


    public void addLast (T value) {
        Node oldLastNode = sentinel.prev;
        Node newLastNode = new Node(null, value, null);

        newLastNode.prev = oldLastNode;
        newLastNode.next = sentinel;
        oldLastNode.next = newLastNode;
        sentinel.prev = newLastNode;
        size += 1;
    }


    public boolean isEmpty () {
        return size == 0 ;
    }


    public int size () {
        return size;
    }


    public void printDeque () {
        Node temp = sentinel.next;
        for (int i = 0; i < size; i++) {
            System.out.println(temp.item + " ");
            temp = temp.next;
        }
    }


    public T removeFirst () {
        if (size == 0) return null;

        Node oldfirstNode = sentinel.next;
        Node newfirstNode = sentinel.next.next;
        newfirstNode.prev = sentinel;
        sentinel.next = newfirstNode;

        size -= 1;
        //if (size == 0) return null;
        //else return oldfirstNode.item;
        return oldfirstNode.item;
    }


    public T removeLast () {
        if (size == 0) return null;

        Node oldLastNode = sentinel.prev;
        Node newLastNode = sentinel.prev.prev;
        newLastNode.next = sentinel;
        sentinel.prev = newLastNode;

        size -= 1;
        //if (size == 0) return null;
        //else return oldLastNode.item;
        return oldLastNode.item;
    }

    public T get (int index) {
        if (index < 0 || index > size-1) return null;

        Node temp = sentinel.next;
        while (index-- > 0) {
            temp = temp.next;
        }

        return temp.item;
    }


    public T getRecursive (int index) {
        if (index < 0 || index > size-1) return null;
        return getRecursive(index, sentinel.next);
    }


    private T getRecursive (int index, Node A) {
        if (index == 0) return A.item;
        return getRecursive(index-1, A.next);
    }
}