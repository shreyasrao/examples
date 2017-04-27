package epi10;

public class Node{
	Integer data;
	Node left,right;
	
	public Node(int D) {
		data = D;
		left = null;
		right = null;
	}
	
	public void join(Node l, Node r) {
		right = r;
		left = l;
	}
}