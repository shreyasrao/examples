package list1;

public class LinkedList{
	
	public class Node{
		Node next;
		int data;
	}
	
	private Node head=null;
	private Node tail=null;
	
	public void insert(int value){
		
		if(head==null){
			
			Node n = new Node();
			n.data = value;
			n.next = null;
			head = n;
			
			tail = head;
			
		}
	
		//code for non empty list:
		else{
			Node last = tail;
			Node n = new Node();
			n.next = null;
			n.data = value;
			last.next = n;
			tail = n;
		}
		
	}
	
	public String toString(){
		
		Node current = head;
		
		String res = new String();
		
		res += "Contents: ";
		
		while(current!=null){
//			System.out.println(current.data);
			res += current.data;
			res += ", ";
			current = current.next;
		}
		
		
		return res;
		
	}
	
	public static void main(String[] args){
		
		LinkedList A = new LinkedList();
		System.out.println(A);
		A.insert(2);
		System.out.println(A);
		A.insert(1);
		System.out.println(A);
	}
	
	
}