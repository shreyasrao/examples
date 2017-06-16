package trees;

/*
 * Use this as a simple tree node. Nodes do NOT have parent pointers
 * 
 * */

public class Node<T>{
	public T data;
	public Node<T> left, right;
	
	public Node(T d){
		data = d;
		left = null;
		right = null;
	}
	
	public Node(T d, Node<T> l, Node<T> r) {
		data = d;
		left = l;
		right = r;
	}
	
	public void connect(Node<T> l, Node<T> r) {
		left = l;
		right = r;
	}
	
	public String toString() {
		return data.toString();
	}
}