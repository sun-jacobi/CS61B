package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T> {
    private class Node {
        private Node prev;
        private T item;
        private Node next;
        Node(Node p, T i, Node n) {
            prev = p;
            item = i;
            next = n;
        }
    }
    private int size;
    private Node sentinel; /* both the front and back pointers */

    /** Return the size of LinkedList */
    public int size() {
        return size;
    }

    /** Create an empty LinkedListDeque  */
    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        size = 0;
    }

    /** Add an item to the front of the deque **/
    public void addFirst(T item) {
        Node p = new Node(sentinel, item, sentinel.next);
        if (size == 0) {
            sentinel.prev = p;
        } else {
            sentinel.next.prev = p;
        }
        sentinel.next = p;
        size++;
    }

    /** Add an item to the back of the deque */
    public void addLast(T item) {
        Node p = new Node(sentinel.prev, item, sentinel);
        if (size == 0) {
            sentinel.next = p;
        } else {
            sentinel.prev.next = p;
        }
        sentinel.prev = p;
        size++;
    }


    /* Prints the items in the deque from first to last, separated by a space.
    Once all the items have been printed, print out a new line
     */
    public void printDeque() {
        Node p = sentinel.next;
        for (int i = 0; i < size; i++) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.print("\n");

    }

    /* Removes and returns the item at the front of the deque.
    If no such item exists, returns null
     */
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T first = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        if (size > 1) {
            sentinel.next.prev = sentinel;
        }
        size--;
        return first;
    }


    /* Removes and returns the item at the back of the deque.
     If no such item exists, returns null.
     */
    public T removeLast() {
        if (size == 0) {
            return null;
        }

        T last = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        if (size > 1) {
            sentinel.prev.next = sentinel;
        }
        size--;
        return last;
    }

    /* Gets the item at the given index, where 0 is the front, 1 is the next item,
    and so forth. If no such item exists, returns null.
     */

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        Node p = sentinel.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.item;

    }

    /* Same as get, but uses recursion */
    public T getRecursive(int index) {
        Node p = sentinel;
        return recMethod(index, p);
    }

    private T recMethod(int index, Node p) {
        if (index == -1 || p.next == null) {
            return p.item;
        } else {
            return recMethod(index - 1, p.next);
        }
    }

    private class DequeIterator implements Iterator<T> {
        private Node pos;
        DequeIterator() {
            pos = sentinel.next;
        }
        public boolean hasNext() {
            if (size == 0) {
                return false;
            }
            return pos != sentinel;
        }
        public T next() {
            T returnItem = pos.item;
            pos = pos.next;
            return returnItem;
        }
    }
    public Iterator<T> iterator() {
        return new DequeIterator();
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Deque)) {
            return false;
        }
        Deque<T> obj;
        if (o instanceof  LinkedListDeque){
            obj = (LinkedListDeque<T>) o;
        } else {
            obj = (ArrayDeque<T>) o ;
        }
        if (obj.size() != this.size()) {
            return false;
        }
        Iterator<T> it = obj.iterator();
        for (T x : this) {
            if (x != it.next()) {
                return false;
            }
        }
        return true;
    }



}
