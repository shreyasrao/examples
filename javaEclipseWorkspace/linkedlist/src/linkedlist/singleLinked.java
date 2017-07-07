package linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class singleLinked{
	
	public static class Node<T>{
		T data;
		Node next;
		
		public Node(T d){
			next = null;
			data = d;
		}
		
		public Node(T d, Node n) {
			data = d;
			next = n;
		}
		
		public String toString() {
			String res="";
			Node curr = this;
			while(curr!=null) {
				res += curr.data + ", ";
				curr = curr.next;
			}
			return res;
		}
	}
	
	public static Node reverse(Node head, int low, int high) {
		
		/*
		 * Reverse sublist of head from low to high inclusive
		 * high must to greater than low
		 * lowest index number is 1
		 * if low is less than 1, first list elem with be considered
		 * if high greater than end of list, method will reverse 
		 * till end of list and return
		 * */
		
		if(high-low<1) return head;
		
		Node dummy = new Node(0, head);
		Node sS = dummy;
		for(int counter=1;counter<low;counter++) {
			if(sS==null) return head;
			sS = sS.next;
		}
		Node sIter = sS.next;
		for(int i=low;i<high;i++) {
			if(sIter.next==null) break;
			Node temp = sIter.next;
			sIter.next = temp.next;
			temp.next = sS.next;
			sS.next = temp;
		}
		
		//if we moved the head then we need to update it
		head = (sS==dummy) ? sS.next : head;
		return head;
	}
	
	public static Node removeKthLastElement(Node head, int k) {
		
		/*
		 * We do not know the length of the list before hand
		 * nor can we assume we can record length of list.
		 * Both of those scenarios would make this algorithm trivial
		 * Our approach is to use 2 iterators, one which is ahead
		 * */
		
		Node dummy = new Node(0, head);
		Node sIter = dummy;
		Node fIter = dummy;
		
		//advance fast iter by k
		for(int i=0; i<=k;i++) {fIter = fIter.next;}
		
		//advance both iters
		while(fIter!=null) {
			fIter = fIter.next;
			sIter = sIter.next;
		}
		
		//Remove kth elem, i.e. sIter.next
		Node temp = sIter.next;
		sIter.next = (temp==null) ? null : temp.next;
		
		return dummy.next;
	}
	
	public static Node evenOddMerge(Node head) {
		/*
		 * Return linked list with all even numbers
		 * followed by odd numbers
		 * */
		
		Node eDummy = new Node(0);
		Node oDummy = new Node(0);
		Node eIter = eDummy;
		Node oIter = oDummy;
		Node<Integer> curr = head;
		
		while(curr!=null) {
			if(curr.data%2==0) {
				//even
				eIter.next = curr;
				eIter = curr;
			}
			else {
				//odd
				oIter.next = curr;
				oIter = curr;
			}
			curr = curr.next;
			oIter.next = null;
			eIter.next = null;
		}
		eIter.next = oDummy.next;
		head = (eDummy.next==null) ? oDummy.next : eDummy.next;
		return head;
	}
	
	
	public static Node evenOddIndices(Node head) {
		/*
		 * Return list with all of the even indices
		 * followed by odd. Note: we do not care about
		 * the actual data in the node
		 * */
		
		Node eDummy = new Node(0), oDummy = new Node(0);
		List<Node> evenOdd = new ArrayList<Node>(Arrays.asList(eDummy,oDummy));
		Node curr = head;
		int count = 0;
		
		while(curr!=null) {
			evenOdd.get(count).next = curr;
			evenOdd.set(count, evenOdd.get(count).next);
			curr = curr.next;
			count ^= 1;
		}
		System.out.println(eDummy);
		System.out.println(oDummy);
		evenOdd.get(1).next = null;
		evenOdd.get(0).next = oDummy.next;
		return eDummy.next;
	}
	
}