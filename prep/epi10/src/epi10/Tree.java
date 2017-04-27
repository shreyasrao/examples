package epi10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import epi10.BinaryTree.BinaryTreeNode;

public class Tree{
	
	public static Node root;
	
	public static class hB{
		int height;
		boolean bal;
		
		public hB(int h, boolean b) {
			height = h;
			bal = b;
		}
	}
	
	public static boolean isBalanced(Node root) {
		hB res = height(root, new hB(0,true));
		System.out.println("height is " + res.height);
		return res.bal;
	}
	
	public static hB height(Node tree, hB info) {
		if(tree==null) return new hB(info.height-1,info.bal);
		
		hB leftInfo = height(tree.left, new hB(info.height+1,info.bal));
		hB rightInfo = height(tree.right, new hB(info.height+1,info.bal));
		int diff = Math.abs(leftInfo.height - rightInfo.height);
		int maxHeight = Math.max(leftInfo.height, rightInfo.height);
		boolean balanced = diff > 1 ? false : rightInfo.bal && leftInfo.bal;
		
		return new hB(maxHeight,balanced);
		//		hB leftInfo = new hB(info.height+1,true), rightInfo;
		
	}
	
	
	public static sNode bT(List<String> preorder, List<String> inorder) {
		Map<String, Integer> nodeToInIdx = new HashMap<String, Integer>();
		for(int i=0;i<inorder.size();i++) {
			nodeToInIdx.put(inorder.get(i), i);
		}
		System.out.println(nodeToInIdx.get("H"));
//		create()
		return create(preorder,0,preorder.size(),0,inorder.size(), nodeToInIdx);
	}
	
	public static sNode create(List<String> preorder, int preStart, int preEnd, int inStart, int inEnd, Map<String,Integer> nodeToInIdx) {
		
		if(preEnd<=preStart || inEnd<=inStart) return null;
		
		int rootIdx = nodeToInIdx.get(preorder.get(preStart));
		int leftSize = rootIdx - inStart;
		
		return new sNode(
				preorder.get(preStart),
				create(preorder,preStart+1,preStart+1+leftSize,inStart,rootIdx, nodeToInIdx),
				create(preorder,preStart+1+leftSize,preEnd,rootIdx+1,inEnd,nodeToInIdx)
				);
		
	}
	
	public static void connect(Node tree, Node l, Node r) {
		tree.left = l;
		tree.right = r;
	}
	
	public static List<Integer> postOrderTraversal(Node tree) {
		if (tree == null) return new ArrayList<Integer>();
//		List<Node> v = new ArrayList<Node>();
//		v.add(tree);
		List<Integer> explored = new ArrayList<Integer>();
		doPost(tree,explored);
		return explored;
	}
	
	public static void doPost(Node tree, List<Integer> e) {
		
		if(tree==null) return;
		doPost(tree.left,e);
		doPost(tree.right,e);
		e.add(tree.data);
		
//		if(v.isEmpty()) return;
//		Node current = v.get(v.size()-1);
//		if(current==null) return;
		
		
//		e.add(current.data);
	}
	
	public static List<Integer> preOrderTraversal(Node tree) {
		if (tree==null) return new ArrayList<Integer>();
		List<Integer> explored = new ArrayList<Integer>();
		doPre(tree,explored);
		return explored;
	}
	
	public static void doPre(Node tree, List<Integer>e) {
		if(tree==null) return;
		e.add(tree.data);
		doPre(tree.left,e);
		doPre(tree.right,e);
	}
	
	public static List<Integer> inOrderTraversal(Node tree) {
		if(tree==null) return new ArrayList<Integer>();
		List<Integer> explored = new ArrayList<Integer>();
		doIn(tree,explored);
		return explored;
	}
	
	public static void doIn(Node tree, List<Integer> e) {
		if(tree==null) return;
		doIn(tree.left,e);
		e.add(tree.data);
		doIn(tree.right,e);
	}
	
	public static void constructTree() {
		//tree on page 136
		
		Node A = new Node(314);
		Node B = new Node(6);
		Node C = new Node(271);
		Node D = new Node(28);
		Node E = new Node(0);
		Node F = new Node(561);
		Node G = new Node(3);
		Node H = new Node(17);
		Node I = new Node(6);
		Node J = new Node(2);
		Node K = new Node(1);
		Node L = new Node(401);
		Node M = new Node(641);
		Node N = new Node(257);
		Node O = new Node(271);
		Node P = new Node(28);

		connect(A,B,I);
		connect(B,C,F);
		connect(C,D,E);
		connect(F,null,G);
		connect(G,H,null);
		connect(I,J,O);
		connect(O,null,P);
		connect(J,null,K);
		connect(K,L,N);
		connect(L,null,M);
		
//		connect(A,B,K);
//		connect(B,C,H);
//		connect(C,D,G);
//		connect(D,E,F);
//		connect(H,I,J);
//		connect(L,M,N);
//		connect(K,L,O);
		
		
//		connect(E,null,null);
//		connect(F,null,null);
//		connect(I,null,null);
//		connect(J,null,null);
//		connect(M,null,null);
//		connect(N,null,null);
//		connect(O,null,null);
//		connect(G,null,null);
		
		root = A;
	}
	
	public static void main(String[] args) {
		constructTree();
//		System.out.println(postOrderTraversal(root));
		System.out.println(inOrderTraversal(root));
		
//		List<String> in = new ArrayList<String>(Arrays.asList("F","B","A","E","H","C","D","I","G"));
//		bT(in, in);
	}
	
}