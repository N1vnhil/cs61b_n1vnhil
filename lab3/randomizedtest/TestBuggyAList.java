package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import timingtest.AList;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    @Test
    public void testThreeAddThreeRemove() {
        AList<Integer> als = new AList<>();
        BuggyAList<Integer> bls = new BuggyAList<>();

        als.addLast(4);
        bls.addLast(4);
        als.addLast(5);
        bls.addLast(5);
        als.addLast(6);
        bls.addLast(6);

        assertEquals(als.removeLast(), bls.removeLast());
        assertEquals(als.removeLast(), bls.removeLast());
        assertEquals(als.removeLast(), bls.removeLast());

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
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                assertEquals(L.size(), B.size());
            } else if (operationNumber == 2){
                if(L.size()==0||B.size()==0){
                    continue;
                }
                assertEquals(L.removeLast(), B.removeLast());
            } else if (operationNumber == 3){
                if(L.size()==0||B.size()==0){
                    continue;
                }
                assertEquals(L.getLast(), B.getLast());
            }
        }
    }
  // YOUR TESTS HERE
}
