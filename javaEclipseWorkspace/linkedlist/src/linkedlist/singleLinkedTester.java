package linkedlist;
import static org.junit.Assert.*;

import org.junit.Test;

import linkedlist.singleLinked.Node;

public class singleLinkedTester{
	
	@Test
	public void reverse0() {
		Node e = new Node(2);
		Node d = new Node(7,e);
		Node c = new Node(5,d);
		Node b = new Node(3,c);
		Node a = new Node(11,b);
//		System.out.println(a);
//		singleLinked.reverse(a, 1, 5);
	}
	
	@Test
	public void reverse1() {
		Node e = new Node(2);
		Node d = new Node(7,e);
		Node c = new Node(5,d);
		Node b = new Node(3,c);
		Node a = new Node(11,b);
//		System.out.println(a);
		Node rL = singleLinked.reverse(a, 2, 4);
//		System.out.println("Reversed List: "+rL);
		assertEquals(rL.toString(),"11, 7, 5, 3, 2, ");
	}
	
	@Test
	public void reverse2() {
		Node e = new Node(2);
		Node d = new Node(7,e);
		Node c = new Node(5,d);
		Node b = new Node(3,c);
		Node a = new Node(11,b);
		Node rL = singleLinked.reverse(a, 2, 3);
		assertEquals("11, 5, 3, 7, 2, ", rL.toString());
	}
	
	@Test
	public void reverse3() {
		Node e = new Node(2);
		Node d = new Node(7,e);
		Node c = new Node(5,d);
		Node b = new Node(3,c);
		Node a = new Node(11,b);
		Node rL = singleLinked.reverse(a, 2, 6);
		assertEquals("11, 2, 7, 5, 3, ", rL.toString());
	}
	
	@Test
	public void reverse4() {
		Node e = new Node(2);
		Node d = new Node(7,e);
		Node c = new Node(5,d);
		Node b = new Node(3,c);
		Node a = new Node(11,b);
		Node rL = singleLinked.reverse(a, 1, 5);
		assertEquals("2, 7, 5, 3, 11, ", rL.toString());
	}
	
	@Test
	public void delete0() {
		Node e = new Node(2);
		Node d = new Node(7,e);
		Node c = new Node(5,d);
		Node b = new Node(3,c);
		Node a = new Node(11,b);
		Node rL = singleLinked.removeKthLastElement(a, 0);
		assertEquals("11, 3, 5, 7, 2, ", rL.toString());
	}
	
	@Test
	public void delete1() {
		Node e = new Node(2);
		Node d = new Node(7,e);
		Node c = new Node(5,d);
		Node b = new Node(3,c);
		Node a = new Node(11,b);
		Node rL = singleLinked.removeKthLastElement(a, 1);
		assertEquals("11, 3, 5, 7, ", rL.toString());
	}
	
	@Test
	public void deleteFirst() {
		Node e = new Node(2);
		Node d = new Node(7,e);
		Node c = new Node(5,d);
		Node b = new Node(3,c);
		Node a = new Node(11,b);
		Node rL = singleLinked.removeKthLastElement(a, 5);
		assertEquals("3, 5, 7, 2, ", rL.toString());
	}
	
	@Test
	public void delete3() {
		Node e = new Node(2);
		Node d = new Node(7,e);
		Node c = new Node(5,d);
		Node b = new Node(3,c);
		Node a = new Node(11,b);
		Node rL = singleLinked.removeKthLastElement(a, 3);
		assertEquals("11, 3, 7, 2, ", rL.toString());
	}
	
	@Test
	public void evenOdd() {
		Node e = new Node(2);
		Node d = new Node(7,e);
		Node c = new Node(5,d);
		Node b = new Node(3,c);
		Node a = new Node(11,b);
		Node rL = singleLinked.evenOddMerge(a);
		assertEquals("2, 11, 3, 5, 7, ", rL.toString());
	}
	
	@Test
	public void evenOdd2() {
		Node e = new Node(2);
		Node d = new Node(7,e);
		Node c = new Node(5,d);
		Node b = new Node(30,c);
		Node a = new Node(11,b);
		Node rL = singleLinked.evenOddMerge(a);
		assertEquals("30, 2, 11, 5, 7, ", rL.toString());
	}
	
	@Test
	public void evenOdd3() {
		Node d = new Node(7);
		Node c = new Node(5,d);
		Node b = new Node(3,c);
		Node a = new Node(11,b);
		Node rL = singleLinked.evenOddMerge(a);
		assertEquals("11, 3, 5, 7, ", rL.toString());
	}
	
	@Test
	public void evenOddIndices() {
		Node d = new Node(7);
		Node c = new Node(5,d);
		Node b = new Node(3,c);
		Node a = new Node(11,b);
		Node rL = singleLinked.evenOddIndices(a);
		assertEquals("11, 5, 3, 7, ", rL.toString());
	}
}