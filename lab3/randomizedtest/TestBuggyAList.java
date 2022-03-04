package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {

    @Test
    public void testThreeAddThreeRemove(){
        BuggyAList<Integer> buggyAList = new BuggyAList<>();
        AListNoResizing<Integer> aListNoResizing = new AListNoResizing<>();
        buggyAList.addLast(4);
        aListNoResizing.addLast(4);
        buggyAList.addLast(5);
        aListNoResizing.addLast(5);
        assertEquals(buggyAList.size(),aListNoResizing.size());
        assertEquals(buggyAList.removeLast(),aListNoResizing.removeLast());
    }

    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
                assertEquals(L.size(),B.size());
            } else if (operationNumber == 1) {
                // size
                int lsize = L.size();
                int bsize = B.size();
                assertEquals(lsize,bsize);

            }
            else if (operationNumber == 2){
                if(L.size()==0 || B.size() == 0){
                    continue;
                }
                int Llast = L.getLast();
                int Blast = B.getLast();
                assertEquals(Llast,Blast);
            }
            else if (operationNumber == 3){
                if(L.size()==0 || B.size() == 0 ){
                    continue;
                }
                int Llast = L.removeLast();
                int Blast = B.removeLast();
                assertEquals(Llast,Blast);
                assertEquals(L.size(),B.size());
            }
        }
    }
}
