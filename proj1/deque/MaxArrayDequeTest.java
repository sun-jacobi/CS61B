package deque;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Comparator;

public class MaxArrayDequeTest {

    private static class lenComparator implements Comparator<String> {
        public int compare(String a, String b){
            return a.length()-b.length();
        }

    }
    @Test
    public void StrTest(){
        lenComparator c = new lenComparator();
        MaxArrayDeque<String> ad = new MaxArrayDeque(c);
        ad.addLast("Tired");
        ad.addLast("newbie");
        ad.addLast("shit");
        assertEquals("newbie",ad.max());
    }



}

