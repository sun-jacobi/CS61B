package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T>{
    private Comparator<T> comparator;
    public MaxArrayDeque(Comparator<T> c){
        comparator = c;
    }
    public T max(){
        return max(comparator);
    }
    public T max(Comparator<T> c){
        if(this.size()==0){
            return null;
        }
        T ret = this.get(0);
        for(T x :this){
            if (comparator.compare(x,ret)>=0){
                ret = x;
            }
        }
        return ret;
    }

}
