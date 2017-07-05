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
		if(high-low < 1) {return head;}
		Node dummy = new Node(-1);
		Node preStart = null;
		Node preEnd = null;
		Node curr = head;
		Node prev = dummy;
		int counter = 1;
		Node sS = head;
		while(curr!=null) {
			if(counter==low) {
				preStart = prev;
				sS = curr;
				prev.next = null;
			}
			if(counter==high) {
				preEnd = curr.next;
				curr.next = null;
				break;
			}
			prev = curr;
			curr = curr.next;
			counter++;
		}
		curr = sS;
		Node nS = sS;
		while(curr!=null && curr.next!=null) {
			nS = curr.next;
			curr.next = nS.next;
			nS.next = sS;
			sS = nS;
		}
		
		//reconnect reversed substring back to main string
		if(preStart==dummy) {
			head = sS;
		}
		else {
			preStart.next=sS;
		}
		if(preEnd!=null && curr!=null) curr.next = preEnd;
		return head;
	}
	
}