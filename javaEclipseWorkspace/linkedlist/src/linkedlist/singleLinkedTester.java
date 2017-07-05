package linkedlist;
import static org.junit.Assert.*;

import org.junit.Test;

import linkedlist.singleLinked.Node;

public class singleLinkedTester{
	
	@Test
	public void in0() {
		Node e = new Node(2);
		Node d = new Node(7,e);
		Node c = new Node(5,d);
		Node b = new Node(3,c);
		Node a = new Node(11,b);
//		System.out.println(a);
//		singleLinked.reverse(a, 1, 5);
	}
	
	@Test
	public void in1() {
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
	public void in2() {
		Node e = new Node(2);
		Node d = new Node(7,e);
		Node c = new Node(5,d);
		Node b = new Node(3,c);
		Node a = new Node(11,b);
		Node rL = singleLinked.reverse(a, 2, 3);
		assertEquals("11, 5, 3, 7, 2, ", rL.toString());
	}
	
	@Test
	public void in3() {
		Node e = new Node(2);
		Node d = new Node(7,e);
		Node c = new Node(5,d);
		Node b = new Node(3,c);
		Node a = new Node(11,b);
		Node rL = singleLinked.reverse(a, 2, 6);
		assertEquals("11, 2, 7, 5, 3, ", rL.toString());
	}
	
	@Test
	public void in4() {
		Node e = new Node(2);
		Node d = new Node(7,e);
		Node c = new Node(5,d);
		Node b = new Node(3,c);
		Node a = new Node(11,b);
		Node rL = singleLinked.reverse(a, 1, 5);
		assertEquals("2, 7, 5, 3, 11, ", rL.toString());
	}
}