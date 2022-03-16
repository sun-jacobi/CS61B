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




}

