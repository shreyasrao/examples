package pset1;

import static org.junit.Assert.*;
import org.junit.Test;

public class SLListAddTester {
    @Test public void test0() {
        SLList l = new SLList();
        assertTrue(l.repOk());
        l.add(0);
        // write a sequence of assertTrue method invocations that
        // perform checks on the values for all the declared fields
        // of list and node objects reachable from l
        assertTrue(l.header != null);
        // your code goes here
        assertTrue(l.header.next.elem == 0);
        assertTrue(l.header.next.next == null);
}
    @Test public void test1() {
        SLList l = new SLList();
        assertTrue(l.repOk());
        l.add(0);
        assertTrue(l.repOk());
        l.add(1);
        assertTrue(l.repOk());
        // write a sequence of assertTrue method invocations that
        // perform checks on the values for all the declared fields
        // of list and node objects reachable from l
        assertTrue(l.header != null);
        // your code goes here
        assertTrue(l.header.next.elem == 0);
        assertTrue(l.header.next.next != null);
        assertTrue(l.header.next.next.elem == 1);
        assertTrue(l.header.next.next.next == null);
    }
}