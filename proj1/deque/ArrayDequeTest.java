package deque;

import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {

    @Test
    public void smallArrayDequeTest(){
        ArrayDeque<Integer> alist1 = new ArrayDeque<>();
        ArrayDeque<Integer> alist2 = new ArrayDeque<>();
        for(int i = 0 ; i < 8 ;i++){
            alist1.addLast(i);
            alist2.addFirst(i);
        }
        assertEquals(8,alist1.size());
        assertEquals(8,alist2.size());
        alist1.printDeque();
        alist2.printDeque();
    }

    @Test
    public void getTest(){
        ArrayDeque<Integer> alist1 = new ArrayDeque<>();
        ArrayDeque<Integer> alist2 = new ArrayDeque<>();
        for(int i = 0 ; i < 8 ;i++){
            alist1.addLast(i);
            alist2.addFirst(i);
        }
        for(int i = 0; i < 8 ;i++){
            int item1 = alist1.get(i);
            int item2 = alist2.get(i);
            assertEquals(i,item1);
            assertEquals(7-i,item2);
        }
    }
}
