package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private T[] items;
    private int size;
    private int first;
    private int last;

    public ArrayDeque() {
        size = 0;
        items = (T[]) new Object[8];
        first = 0;
        last = 1;

    }
    private void resize(int capacity) {
        int l = items.length;
        T[] a = (T[]) new Object[capacity];
        int left;
        if (last >= capacity) {
            left =  last - capacity;
            last = left + 1;
        } else if (last ==  0) {
            left = l;
            last = items.length;
        } else {
            left = last;
        }
        int right;
        int newFirst;
        if (first >= capacity || capacity >= l) {
            right = l - first - 1;
            newFirst = capacity - right - 1;
        } else {
            right = capacity - first - 1;
            newFirst = first;
        }

        System.arraycopy(items, 0, a, 0, left);
        System.arraycopy(items, first + 1, a, newFirst + 1, right);
        items = a;
        first = newFirst;


    }


    public int size() {
        return size;
    }
    public void printDeque() {
        int index = first + 1;
        for (int i = 0; i < size; i++) {
            System.out.print(items[index] + " ");
            index = (index + 1) % items.length;
        }
        System.out.print("\n");
    }

    public void addFirst(T item) {
        if (size == items.length) {
            resize((size * 2));
        }
        items[first] = item;
        first = ((first - 1) % (items.length));
        if (first < 0) {
            first = first + items.length;
        }
        size++;
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize((size * 2));
        }
        items[last] = item;
        last = (last + 1) % (items.length);
        size++;
    }

    public T get(int index) {
        return items[(first + index + 1) % (items.length)];
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        if (size == items.length / 4 && items.length >= 16) {
            resize(items.length / 2);
        }

        int nextFirst = (first + 1) % (items.length);
        T ret = items[nextFirst];
        items[nextFirst] = null;
        if (size == 1) {
            first = 0;
            last = 1;
        } else {
            first = nextFirst;
        }
        size--;
        return ret;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        if (size == items.length / 4 && items.length >= 16) {
            resize(items.length / 2);
        }
        int nextlast =  (last - 1) % (items.length);
        if (nextlast < 0) {
            nextlast = items.length + nextlast;
        }
        T ret = items[nextlast];
        items[nextlast] = null;
        if (size == 1) {
            first = 0;
            last = 1;
        } else {
            last = nextlast;
        }
        size--;
        return ret;
    }

    public Iterator<T> iterator() {
        return new ArrayDeque.DequeIterator();
    }

    private class DequeIterator implements Iterator<T> {
        private int pos;
        DequeIterator() {
            pos = 0;
        }
        public boolean hasNext() {
            if (size == 0) {
                return false;
            }
            return pos < size;

        }
        public T next() {
            pos++;
            return items[(first + pos) % items.length];
        }

    }
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Deque)) {
            return false;
        }
        Deque<T> obj;
        if (o instanceof  LinkedListDeque) {
            obj = (LinkedListDeque<T>) o;
        } else {
            obj = (ArrayDeque<T>) o;
        }
        if (obj.size() != this.size()) {
            return false;
        }
        int index = 0;
        for (T x : this) {
            if (!obj.get(index).equals(x)) {
                return false;
            }
            index++;
        }
        return true;
    }
}
