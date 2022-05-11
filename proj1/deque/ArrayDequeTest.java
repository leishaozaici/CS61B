package deque;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArrayDequeTest {

    @Test
    public void testThreeAddThreeRemove() {
        ArrayDeque<Integer> correct = new ArrayDeque<>();
        LinkedListDeque<Integer> broken = new LinkedListDeque<>();

        correct.addLast(5);
        correct.addLast(10);
        correct.addLast(15);

        broken.addLast(5);
        broken.addLast(10);
        broken.addLast(15);

        assertEquals(correct.size(), broken.size());

        assertEquals(correct.removeLast(), broken.removeLast());
        assertEquals(correct.removeLast(), broken.removeLast());
        assertEquals(correct.removeLast(), broken.removeLast());
    }

    @Test
    public void randomizedTest() {
        ArrayDeque<Integer> correct = new ArrayDeque<>();
        LinkedListDeque<Integer> broken = new LinkedListDeque<>();

        int N = 10000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                correct.addLast(randVal);
                broken.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int csize = correct.size();
                int bsize = broken.size();
                System.out.println("csize: " + csize + " bsize: " + bsize);
                assertEquals(csize, bsize);
            } /*else if (operationNumber == 2) {
                if (broken.size() != 0 && correct.size() != 0) {
                    int cget = correct.removeFirst();
                    int bget = broken.removeFirst();
                    System.out.println("cremoveFirst(" + cget + ")" + " bremoveFirst(" + bget + ")");
                    assertEquals(cget, bget);
                }
            }*/ else if (operationNumber == 3 || operationNumber == 2) {
                if (broken.size() != 0 && correct.size() != 0) {
                    int cremove = correct.removeLast();
                    int bremove = broken.removeLast();
                    System.out.println("cremoveLast(" + cremove + ")" + " bremoveLast(" + bremove + ")");
                    assertEquals(cremove, bremove);
                }
            }
        }
    }
}
