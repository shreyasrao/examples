package pset1;
import static org.junit.Assert.*;
import org.junit.Test;
import pset1.SLList.Node;

public class SLListRepOkTester {
    @Test public void t0() {
        SLList l = new SLList();
        assertTrue(l.repOk());
    }
    
    @Test public void t1() {
        SLList l = new SLList();
        Node n = new Node();
        
        // your code goes here
        n.elem = 1;
        l.header = new Node();
        l.header.next = n;
        assertTrue(l.repOk());
    }
    
    // your code goes here
    
    @Test public void t2() {
        SLList l = new SLList();
        Node n = new Node();
        n.elem = 0;
        Node m = new Node();
        m.elem = 1;
        
        l.header = new Node();
        l.header.next = m;
        m.next = n;
        
        assertFalse(l.repOk());
    }
    
    @Test public void t3() {
        SLList l = new SLList();
        Node n = new Node();
        n.elem = 0;
        n.next = n;
        
        l.header = new Node();
        l.header.next = n;

        
        assertFalse(l.repOk());
    }
    
    @Test public void t4() {
        SLList l = new SLList();
        Node n = new Node();
        n.elem = 0;
        Node m = new Node();
        m.elem = 0;
        
        l.header = new Node();
        l.header.next = m;
        m.next = n;
        n.next = m;
        
        assertFalse(l.repOk());
    }
}