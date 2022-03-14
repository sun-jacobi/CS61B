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
    @Test
    public void removeTest(){
        ArrayDeque<Integer> alist = new ArrayDeque<>();
        for(int i = 0 ; i < 8 ;i++){
            alist.addLast(i);
        }
        int a0 = alist.removeFirst();
        assertEquals(0,a0);
        int a7 = alist.removeLast();
        assertEquals(7,a7);
        int a1 = alist.removeFirst();
        assertEquals(1,a1);
        int a6 = alist.removeLast();
        assertEquals(6,a6);
        int a2 = alist.removeFirst();
        assertEquals(2,a2);
        int a5 = alist.removeLast();
        assertEquals(5,a5);
    }

    @Test

    public void singleTest(){
        ArrayDeque<Integer> alist = new ArrayDeque<>();
        alist.addFirst(1);
        int a1 = alist.get(0);
        assertEquals(1,a1);
    }

    @Test
    public void resizeTest(){
        ArrayDeque<Integer> alist1 = new ArrayDeque<>();
        ArrayDeque<Integer> alist2 = new ArrayDeque<>();
        for(int i = 0; i < 128 ; i++){
            alist1.addFirst(i);
            alist2.addLast(i);
        }
        alist1.printDeque();
        alist2.printDeque();
        for(int i = 0; i < 128 ; i++){
            alist1.removeFirst();
            alist2.removeLast();
        }
        assertEquals(0,alist1.size());
        assertEquals(0,alist2.size());

    }

    @Test
    public void bigTest(){
        ArrayDeque<Integer> alist = new ArrayDeque<>();
        for(int i = 0 ; i < 8 ;i++){
            alist.addFirst(2*i);
            alist.addLast(2*i+1);
        }
        int a14 = alist.removeFirst();
        int a15 = alist.removeLast();
        assertEquals(14,a14);
        assertEquals(15,a15);
        for(int i = 0 ;i < 500 ; i++){
            alist.addLast(i);
        }
        int a12 = alist.removeFirst();
        assertEquals(12,a12);
    }

    @Test
    public void iteratorTest(){
        ArrayDeque<Integer> alist1 = new ArrayDeque<>();
        ArrayDeque<Integer> alist2 = new ArrayDeque<>();
        for(int i = 0; i < 16 ; i++){
            alist1.addLast(i);
            alist2.addFirst(i);
        }
        int num1 = 0;
        for(int x : alist1){
            System.out.print(x);
            assertEquals(num1,x);
            num1++;
        }
        int num2 = 0;
        for(int x : alist2){
            System.out.print(x);
            assertEquals(15 - num2,x);
            num2++;
        }
    }

    @Test
    public void iterator3Test(){
        ArrayDeque<String> alist = new ArrayDeque<>();
        alist.addLast("shit");
        alist.addLast("shit");
        alist.addLast("shit");
        for(String x : alist){
            assertEquals("shit",x);
        }
    }


    @Test
    public void equalTest(){
        ArrayDeque<Integer> alist1 = new ArrayDeque<>();
        ArrayDeque<Integer> alist2 = new ArrayDeque<>();
        for(int i = 0 ; i < 16; i++){
            alist1.addFirst(i);
            alist2.addFirst(i);
        }
        assertTrue(alist1.equals(alist2));
    }
    @Test
    public void twoDequeTest(){
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        LinkedListDeque<Integer> lld = new LinkedListDeque<>();
        ad.addLast(1);
        lld.addLast(1);
        assertTrue(ad.equals(lld));

    }
    @Test
    public void getTest2(){
        ArrayDeque<Integer> ArrayDeque = new ArrayDeque<>();
        ArrayDeque.addLast(0);
        int a0 = ArrayDeque.removeFirst();
        assertEquals(0,a0);
        ArrayDeque.addLast(2);
        ArrayDeque.addLast(3);
        ArrayDeque.addFirst(4);
        ArrayDeque.addLast(5);
        int a5 = ArrayDeque.removeLast();
        assertEquals(5,a5);
        ArrayDeque.addLast(7);
        int a7 = ArrayDeque.get(3);
        assertEquals(7,a7);
        ArrayDeque.addLast(10);
        ArrayDeque.removeFirst();
        ArrayDeque.addFirst(13);
        ArrayDeque.addFirst(14);
        ArrayDeque.addLast(16);
        ArrayDeque.addLast(17);
        ArrayDeque.addFirst(18);
        ArrayDeque.addLast(19);
        ArrayDeque.addLast(20);
        int a17 = ArrayDeque.get(8);
        assertEquals(17,a17);
    }

}
