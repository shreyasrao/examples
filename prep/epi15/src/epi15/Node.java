package epi15;

public class Node<T>{
	public T data;
	public Node<T> left,right;
	
	public Node(T d){
		this.data = d;
		this.left = null;
		this.right = null;
	}
	
	public void join(Node<T> l, Node<T> r) {
		this.left = l;
		this.right = r;
	}
	
	public String toString() {
		String res = this.data + ", ";
		return res;
	}
}