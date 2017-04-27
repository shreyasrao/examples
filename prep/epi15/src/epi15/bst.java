package epi15;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class bst{
	
	public static Node<Integer> root=null;
	
	public static void createTree() {
		Node<Integer> A = new Node<Integer>(19);
		Node<Integer> B = new Node<Integer>(7);
		Node<Integer> C = new Node<Integer>(3);
		Node<Integer> D = new Node<Integer>(2);
		Node<Integer> E = new Node<Integer>(5);
		Node<Integer> F = new Node<Integer>(11);
		Node<Integer> G = new Node<Integer>(17);
		Node<Integer> H = new Node<Integer>(13);
		Node<Integer> I = new Node<Integer>(43);
		Node<Integer> J = new Node<Integer>(23);
		Node<Integer> K = new Node<Integer>(37);
		Node<Integer> L = new Node<Integer>(29);
		Node<Integer> M = new Node<Integer>(31);
		Node<Integer> N = new Node<Integer>(41);
		Node<Integer> O = new Node<Integer>(47);
		Node<Integer> P = new Node<Integer>(53);
		
		connect(A,B,I);
		connect(B,C,F);
		connect(C,D,E);
		connect(F,null,G);
		connect(G,H,null);
		connect(I,J,O);
		connect(J,null,K);
		connect(K,L,N);
		connect(L,null,M);
		connect(O,null,P);
		
		root = A;
	}
	
	public static void connect(Node<Integer> p, Node<Integer> l, Node<Integer> r) {
		p.left = l;
		p.right = r;
	}
	
	
	public static class info {
		boolean valid;
		int low,high;
		
		public info(boolean v, int l, int h) {
			this.valid = v;
			this.low = l;
			this.high = h;
		}
	}
	
	public static info getInfo(Node<Integer> node, Node<Integer> parent) {

		if(node==null) {
			System.out.println("Null Node. Parent data: " + parent.data);
			return new info(true,parent.data,parent.data);
		}

		System.out.println("Node data: " + node.data);
		info leftInfo = getInfo(node.left, node);
		info rightInfo = getInfo(node.right, node);
		System.out.println("Get info complete for : " + node.data);
		boolean v = (leftInfo.high <= node.data) && (leftInfo.low <= node.data) && (leftInfo.valid) &&
					(rightInfo.high >= node.data) && (rightInfo.low >= node.data) && (rightInfo.valid);
		int l = Integer.min(leftInfo.high, leftInfo.low);
		int h = Integer.max(rightInfo.high, rightInfo.low);
		
		return new info(v,l,h);
		
	}
	
	public static boolean isBST(Node<Integer> root) {
		if (root==null ) return true;
		info res = getInfo(root, root);
		return res.valid;
		
	}
	
	public static List<Node<Integer>> kGreatest(Node<Integer> tree, int k, List<Node<Integer>> res) {
		
		if(tree!= null && res.size()<k) {
			kGreatest(tree.right, k, res);
			if(res.size()<k) {
				res.add(tree);
				kGreatest(tree.left,k,res);
			}
		}
		return res;
		
	}
	
	public static void findGreatestK(Node<Integer> node, int k) {
		if(node==null) return;
		Deque<Node<Integer>> queue = new ArrayDeque<Node<Integer>>();
		List<Node<Integer>> res = new LinkedList<Node<Integer>>();
		queue.add(node);
		findK(queue,res,k);
		System.out.println("Res array is this big " + res.size());
		
		
		System.out.println(res.toString());
	}
	
	
	public static void findK(Deque<Node<Integer>> v, List<Node<Integer>> res, int k) {
		
		Node<Integer> node = null;
		Deque<Node<Integer>> e = new ArrayDeque<Node<Integer>>();
		int eP,vP;
		while(!v.isEmpty() && k>0) {
			Node<Integer> eNode = e.peekLast();
			eP = eNode == null ? Integer.MIN_VALUE : eNode.data;
			
			node = v.removeLast();
			vP = node.data;
			
			if(eP>=vP) {
				e.removeLast();
				res.add(eNode);
				k--;
				v.addLast(node);
			}
			else {
				if(node.left!=null) v.addLast(node.left);
				if(node.right!=null) v.addLast(node.right);
				e.addLast(node);
			}
			
			
		}
		//add remaining in e to V before ending method
		while(!e.isEmpty()&&k>0) {
			res.add(e.removeLast());
			k--;
		}
	}
	
	public static void findLCA(Node<Integer> tree, Integer a, Integer b) {
		if(a==b) {
			System.out.println("Node are same, LCA is itself");
			return;
		}
		Integer low, high;
		if(a<b) {low = a; high = b;}
		else {low = b; high = a;}
		
		System.out.println(lca(tree, low, high));
		
	}
	
	public static int lca(Node<Integer> tree, Integer low, Integer high) {
		int lca = tree.data;
		if(low < tree.data && high < tree.data) {lca = lca(tree.left, low, high);}
		else if(low > tree.data && high > tree.data) lca = lca(tree.right, low, high);
		return lca;
	}
	
	
	public static void main(String[]args) {
//		Node A = new Node(19);
//		Node B = new Node(7);
//		Node I = new Node(43);
//		
//		Node C = new Node(3);
//		Node F = new Node(12);
//		A.join(B, I);
//		B.join(C, F);
//		System.out.println(isBST(A));
//		findGreatestK(A,3);
//		List<Node<Integer>> res = kGreatest(A,3,new ArrayList<Node<Integer>>());
//		System.out.println(res);
		createTree();
		findLCA(root,31,41);
	}
}