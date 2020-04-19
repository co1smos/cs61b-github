public class ArrayDeque<T> {
    public T[] item;
    public int size;
    public int nextFirst;
    public int nextLast;


    public ArrayDeque () {
        item = (T []) new Object[8];
        size = 0;
        nextLast = 0;
        nextFirst = 8;
    }


    public ArrayDeque (T value) {
        item = (T []) new Object[8];
        size = 0;
        nextLast = 0;
        nextFirst = 8;
        addLast(value);
    }


    public void addFirst (T value) {
        item[nextFirst] = value;
        size++;
        if (size == items.length) resize(item.length*2);
        //nextFirst--;
        nextFirst = (nextFirst-1)%item.length;
    }


    public void addLast (T value) {
        item[nextLast] = value;
        size++;
        if (size == items.length) resize(item.length*2);
        //nextLast++;
        nextLast = (nextLast+1)%item.length;
    }


    public boolean isEmpty () {
        return !size;
    }


    public int size () {
        return size;
    }


    public void printDeque () {
        int idx = nextFirst + 1;
        int length = item.length;
        for (int i = size; i > 0; i--) {
            System.out.println(item[idx%length] + " ");
            idx++;
        }
    }


    public T removeFirst () {
        if (size == 0) return null;

        nextFirst = (nextFirst+1)%item.length;
        T ReturnValue = item[nextFirst];
        item[nextFirst] = 0;
        size--;

        if (size < item.length/4 && item.length >= 16) resize(item.length/2);

        return ReturnValue;
    }


    public T removeLast () {
        if (size == 0) return null;

        nextLast = (nextLast-1)%item.length;
        T ReturnValue = item[nextLast];
        item[nextLast] = 0;
        size--;

        if (size < item.length/4 && item.length >= 16) resize(item.length/2);
        return ReturnValue;
    }


    public T get (int index) {
        if (index >= size || index < 0) return null;
        return item[(nextFirst+1+index)%item.length];
    }


    private static void resize (int newsize) {
        T [] a = (T []) new Object[newsize];
        System.arraycopy(item, 0, a, 0, nextLast);

        if (nextFirst > nextLast) {
            int CopyLengthLast = nextLast;
            int CopyLengthFirst = item.length - nextFirst - 1;
            if (CopyLengthLast) {
                System.arraycopy(item, 0, a, 0, CopyLengthLast);
            }
            if (CopyLengthFirst) {
                System.arraycopy(item, item.length - CopyLengthFirst, a, a.length - CopyLengthFirst, CopyLengthLast);
            }
            nextFirst = a.length - CopyLengthFirst - 1;
        }

        if (nextFirst < nextLast) {
            int CopyLength = nextLast - nextFirst - 1;
            if (CopyLength) {
                System.arraycopy(item, nextFirst+1, a, 0, CopyLengthLast);
            }
            nextFirst = a.length - 1;
            nextLast = CopyLength;
        }

    }
}