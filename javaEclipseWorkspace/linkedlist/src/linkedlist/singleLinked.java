package linkedlist;

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
	
}