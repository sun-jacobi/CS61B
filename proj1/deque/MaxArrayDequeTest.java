package deque;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Comparator;

public class MaxArrayDequeTest {

    private static class LenComparator implements Comparator<String> {
        public int compare(String a, String b) {
            return a.length() - b.length();
        }

    }
    private static class firstComparator implements Comparator<String> {
        public int compare(String a, String b) {
            return a.charAt(0) - b.charAt(0);
        }

    }
    @Test
    public void strTest() {
        LenComparator c = new LenComparator();
        firstComparator c2 = new firstComparator();
        MaxArrayDeque<String> ad = new MaxArrayDeque(c);
        ad.addLast("shit");
        ad.addLast("tired");
        ad.addLast("newbie");
        assertEquals("newbie", ad.max());
        assertEquals("tired", ad.max(c2));
    }

    @Test
    public void getTest3(){
        ArrayDeque<Integer> ArrayDeque = new MaxArrayDeque<>();
        ArrayDeque.addLast(0);
        ArrayDeque.addLast(2);
        ArrayDeque.addFirst(3);
        ArrayDeque.addLast(4);
        ArrayDeque.addLast(5);
        ArrayDeque.addLast(6);
        ArrayDeque.removeFirst();
        ArrayDeque.addFirst(8);
        ArrayDeque.addLast(9);
        ArrayDeque.removeLast();
        ArrayDeque.addLast(11);
        ArrayDeque.removeFirst();
        ArrayDeque.addLast(14);
        ArrayDeque.addFirst(16);
        ArrayDeque.addLast(17);
        ArrayDeque.addLast(18);
        int a16 = ArrayDeque.removeFirst();
        assertEquals(16,a16);
    }
}

