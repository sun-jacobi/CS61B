package deque;

import java.util.Iterator;

public class ArrayDeque <T> implements Iterable<T>, Deque<T>{
    private T[] items;
    private int size;
    private int first;
    private int last;

    public ArrayDeque(){
        size = 0;
        items = (T[]) new Object[8];
        first = 0;
        last = 1;

    }
    private void resize(int capacity){
        int l = items.length;
        T[] a = (T[]) new Object[capacity];
        int left = last;
        int right = l - first - 1;
        int newFirst = capacity-right-1;
        System.arraycopy(items,0,a,0,left);
        System.arraycopy(items,first+1,a,newFirst+1,right);
        items = a;
        first = newFirst;
    }


    public int size(){
        return size;
    }
    public void printDeque(){
        int index = first+1;
        for(int i = 0; i < size ; i++){
            System.out.print(items[index] + " ");
            index = (index+1)%items.length;
        }
        System.out.print("\n");
    }

    public void addFirst(T item){
        if (size == items.length){
            resize((size*2));
        }
        items[first] = item;
        first = ((first-1)%(items.length));
        if (first < 0){
            first = first + items.length;
        }
        size++;
    }
    public void addLast(T item){
        if (size == items.length){
            resize((size*2));
        }
        items[last] = item;
        last = (last+1)%(items.length);
        size++;
    }

    public T get(int index){
        return items[(first+index+1)%(items.length)];
    }
    public T removeFirst(){
        if (size == 0){
            return null;
        }
        if (size == items.length/4){
            resize(items.length/2);
        }
        int nextFirst = (first+1)%(items.length);
        T ret = items[nextFirst];
        items[nextFirst] = null;
        first = nextFirst;
        size--;
        return ret;
    }
    public T removeLast(){
        if (size == 0){
            return null;
        }
        if (size == items.length/4){
            resize(items.length/2);
        }
        int nextlast =  (last-1)%(items.length);
        if (nextlast < 0){
            nextlast = items.length + nextlast;
        }
        T ret = items[nextlast];
        items[nextlast] = null;
        last = nextlast;
        size--;
        return ret;
    }
    public Iterator<T> iterator(){
        return new ArrayDeque.DequeIterator();
    }
    private class DequeIterator implements Iterator<T>{
        private int pos;
        public DequeIterator(){
            pos = first;
        }
        public boolean hasNext() {
            if(pos < first){
                return (pos+items.length-first < size);
            }else{
                return (pos-first < size);
            }
        }
        public T next(){
            pos = (pos+1)%items.length;
            return items[pos];
        }
    }
    public boolean equals(Object o){
        if(!(o instanceof ArrayDeque)){
            return false;
        }
        ArrayDeque<T> obj = (ArrayDeque<T>) o;
        if(o == null){
            return false;
        }
        if(obj.size()!= this.size()){
            return false;
        }
        int p = (first+1)%(items.length);
        for(T x: obj){
            if(!items[p].equals(x)){
                return false;
            }
            p = (p+1)%(items.length);
        }
        return true;
    }



}
