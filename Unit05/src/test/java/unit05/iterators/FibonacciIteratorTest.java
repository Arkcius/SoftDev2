package unit05.iterators;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
public class FibonacciIteratorTest {
    



    @Test
    public void testingIter() {
        // setup
        IterableFibonacci fib = new IterableFibonacci(2, 5);
        fib.add();
        ArrayList<Long> fibe = new ArrayList<>();
        fibe.add((long) 2);
        fibe.add((long) 5);
        fibe.add((long) 7);

        // invoke
        FibonacciIterator iter = new FibonacciIterator(fibe);

        // analyze
        assertTrue(iter.hasNext());
        assertEquals(fib.get(0), iter.next());
        assertTrue(iter.hasNext());
        assertEquals(fib.get(1), iter.next());
        assertTrue(iter.hasNext());
        assertEquals(fib.get(2), iter.next());
        assertFalse(iter.hasNext());
    }
}
