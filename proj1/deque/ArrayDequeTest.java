package deque;

import org.junit.Test;

import static org.junit.Assert.*;

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

    /*@Test
    public void randomizedTest() {
        ArrayDeque<Integer> correct = new ArrayDeque<>();
        LinkedListDeque<Integer> broken = new LinkedListDeque<>();

        int N = 1000;
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
            } *//*else if (operationNumber == 2) {
                if (broken.size() != 0 && correct.size() != 0) {
                    int cget = correct.removeFirst();
                    int bget = broken.removeFirst();
                    System.out.println("cremoveFirst(" + cget + ")" + " bremoveFirst(" + bget + ")");
                    assertEquals(cget, bget);
                }
            }*//* else if (operationNumber == 3 || operationNumber == 2) {
                if (broken.size() != 0 && correct.size() != 0) {
                    int cremove = correct.removeLast();
                    int bremove = broken.removeLast();
                    System.out.println("cremoveLast(" + cremove + ")" + " bremoveLast(" + bremove + ")");
                    assertEquals(cremove, bremove);
                }
            }
        }
    }*/

    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {
        ArrayDeque<String> lld1 = new ArrayDeque<String>();

        assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
        lld1.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, lld1.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

        lld1.addLast("middle");
        assertEquals(2, lld1.size());

        lld1.addLast("back");
        assertEquals(3, lld1.size());

        System.out.println("Printing out deque: ");
//        lld1.printDeque();
    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {
        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        // should be empty
        assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

        lld1.addFirst(10);
        // should not be empty
        assertFalse("lld1 should contain 1 item", lld1.isEmpty());

        lld1.removeFirst();
        // should be empty
        assertTrue("lld1 should be empty after removal", lld1.isEmpty());
    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {

        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        lld1.addFirst(3);

        lld1.removeLast();
        lld1.removeFirst();
        lld1.removeLast();
        lld1.removeFirst();

        int size = lld1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);
    }

    @Test
    /* Check if you can create ArrayDeques with different parameterized types*/
    public void multipleParamTest() {

        ArrayDeque<String> lld1 = new ArrayDeque<String>();
        ArrayDeque<Double> lld2 = new ArrayDeque<Double>();
        ArrayDeque<Boolean> lld3 = new ArrayDeque<Boolean>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();
    }

    @Test
    /* check if null is return when removing from an empty ArrayDeque. */
    public void emptyNullReturnTest() {

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());

    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {
        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        for (int i = 0; i < 1000000; i++) {
            lld1.addLast(i);
        }

        /*for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }*/

//        for (double i = 999999; i > 500000; i--) {
//            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
//        }

    }

    @Test
    public void getTest() {
        ArrayDeque<Integer> ged1 = new ArrayDeque<Integer>();
        for (int i = 0; i < 1000000; i++) {
            ged1.addLast(i);
        }
        for (int i = 999999; i >= 0; i--) {
            assertEquals("sameValue", i, (int) ged1.get(i));

        }
    }

    /*@Test
    public void DequeTest() {
        ArrayDeque<String> deque = new ArrayDeque<>(4, 5);
        deque.addLast("a");
        deque.addLast("b");
        deque.addFirst("c");
        deque.addLast("d");
        deque.addLast("e");
        deque.addFirst("f");
    }*/
    @Test
    public void addlAndrmfTest() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < 10000; i++) {
            deque.addLast(i);
        }
        for (int i = 0; i < 10000; i++) {
            assertEquals("sameValue", i, (int) deque.removeFirst());

        }
        /*deque.addFirst(0);
        deque.addFirst(2);
        deque.get(0);
        StdOut.print(deque.removeLast());*/
    }

    @Test
    public void addfAndrmlTest() {
        ArrayDeque<Integer> ArrayDeque = new ArrayDeque<>();
        for (int i = 0; i < 20; i++) {
            ArrayDeque.addFirst(i);
        }
        for (int i = 0; i < 20; i++) {
            assertEquals("sameValue", i, (int) ArrayDeque.removeLast());

        }
    }

}
