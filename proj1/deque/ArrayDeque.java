package deque;

public class ArrayDeque <T> {
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
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return (size==0);
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
        items[first] = item;
        first = ((first-1)%(items.length));
        if (first < 0){
            first = first + items.length;
        }
        size++;
    }
    public void addLast(T item){
        items[last] = item;
        last = (last+1)%(items.length);
        size++;
    }

    public T get(int index){
        return items[(first+index+1)%(items.length)];
    }
    public T removeFirst(){
        T ret = items[last];
        items[last] = null;
        last = (last-1)%(items.length);
        if (last < 0){
            last = last + items.length;
        }
        size--;
        return ret;
    }
    public T removeLast(){
        T ret = items[first];
        items[first] = null;
        first = (first+1)%(items.length);
        size--;
        return ret;
    }

}
