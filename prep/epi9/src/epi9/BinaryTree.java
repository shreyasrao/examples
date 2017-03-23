package epi9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree{
	
	public BinaryTreeNode<Integer> root = null;
	
	public static class BinaryTreeNode<T>{
		public T data;
		public BinaryTreeNode<T> left, right;
		
		public BinaryTreeNode(T val){
			data = val;
			left = null;
			right = null;
		}
		
	}
	
	public void connect(BinaryTreeNode<Integer> a, BinaryTreeNode<Integer> b, BinaryTreeNode<Integer> i){
		a.left = b;
		a.right = i;
	}
	
	public BinaryTree(){
		//constructor
		//constructor tree from page
		BinaryTreeNode<Integer> A = new BinaryTreeNode<>(314);
		BinaryTreeNode<Integer> B = new BinaryTreeNode<>(6);
		BinaryTreeNode<Integer> C = new BinaryTreeNode<>(271);
		BinaryTreeNode<Integer> D = new BinaryTreeNode<>(28);
		BinaryTreeNode<Integer> E = new BinaryTreeNode<>(0);
		BinaryTreeNode<Integer> F = new BinaryTreeNode<>(561);
		BinaryTreeNode<Integer> G = new BinaryTreeNode<>(3);
		BinaryTreeNode<Integer> H = new BinaryTreeNode<>(17);
		BinaryTreeNode<Integer> I = new BinaryTreeNode<>(6);
		BinaryTreeNode<Integer> J = new BinaryTreeNode<>(2);
		BinaryTreeNode<Integer> K = new BinaryTreeNode<>(1);
		BinaryTreeNode<Integer> L = new BinaryTreeNode<>(401);
		BinaryTreeNode<Integer> M = new BinaryTreeNode<>(641);
		BinaryTreeNode<Integer> N = new BinaryTreeNode<>(257);
		BinaryTreeNode<Integer> O = new BinaryTreeNode<>(271);
		BinaryTreeNode<Integer> P = new BinaryTreeNode<>(28);
		
		root = A;
		
		connect(A,B,I);
		connect(B,C,F);
		connect(C,D,E);
		connect(D,null,null);
		connect(E,null,null);
		connect(F,null,G);
		connect(G,H,null);
		connect(H,null,null);
		connect(I,J,O);
		connect(J,null,K);
		connect(K,L,N);
		connect(L,null,M);
		connect(M,null,null);
		connect(N,null,null);
		connect(O,null,P);
		connect(P,null,null);
		
		System.out.println("Tree Constructed");
	}
	
	
	public void explore(Queue<BinaryTreeNode<Integer>> currentL, Queue<BinaryTreeNode<Integer>> nextL, List<Integer> currentNodes, List<List<Integer>> allNodes){
		while(!currentL.isEmpty()){
			BinaryTreeNode<Integer> current = currentL.poll();
			if(current.left!=null) nextL.add(current.left);
			if(current.right!=null) nextL.add(current.right);
			
			currentNodes.add(current.data);
		}
//		System.out.println(currentNodes.toString());
		allNodes.add(new ArrayList(currentNodes));
		
		currentNodes.clear();
		currentL.addAll(nextL);
		nextL.clear();
		if(!currentL.isEmpty()) explore(currentL, nextL, currentNodes, allNodes);
		return;
	}
	
	public List<List<Integer>> depthOrder(){
		
		List<List<Integer>> allNodes = new ArrayList<>();
		List<Integer> currentNodes = new ArrayList<>();
		
		Queue<BinaryTreeNode<Integer>> currentL = new LinkedList<>();
		Queue<BinaryTreeNode<Integer>> nextL = new LinkedList<>();
		
		BinaryTreeNode<Integer> currentNode = root;
		currentL.add(currentNode);

		explore(currentL, nextL, currentNodes, allNodes);
		
//		System.out.println(allNodes.toString());
		return allNodes;
		
	}
	
	public static void main(String[] args){
		
		BinaryTree t = new BinaryTree();
		List<List<Integer>> allNodes = t.depthOrder();
		System.out.println(allNodes.toString());
//		for(List<Integer> level:allNodes){
//			System.out.println(level);
//		}
		
	}
	
}