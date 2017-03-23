package epi10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree{
	
	public BinaryTreeNode<Integer> root;
	public int height;
//	public Node<Integer> rootNode = null;
	
	
	public static class BinaryTreeNode<T>{
		public T data;
		public BinaryTreeNode<T> left, right;
		
		public BinaryTreeNode(T val){
			data = val;
			left = null;
			right = null;
		}
		
		public String toString(){
			return data.toString();
		}
		
	}
	
	public void connect(BinaryTreeNode<Integer> a, BinaryTreeNode<Integer> b, BinaryTreeNode<Integer> i){
		a.left = b;
		a.right = i;
	}
	
//	public BinaryTree(){
//		//constructor
//		//constructor tree from page 136
//		BinaryTreeNode<Integer> A = new BinaryTreeNode<>(314);
//		BinaryTreeNode<Integer> B = new BinaryTreeNode<>(6);
//		BinaryTreeNode<Integer> C = new BinaryTreeNode<>(271);
//		BinaryTreeNode<Integer> D = new BinaryTreeNode<>(28);
//		BinaryTreeNode<Integer> E = new BinaryTreeNode<>(0);
//		BinaryTreeNode<Integer> F = new BinaryTreeNode<>(561);
//		BinaryTreeNode<Integer> G = new BinaryTreeNode<>(3);
//		BinaryTreeNode<Integer> H = new BinaryTreeNode<>(17);
//		BinaryTreeNode<Integer> I = new BinaryTreeNode<>(6);
//		BinaryTreeNode<Integer> J = new BinaryTreeNode<>(2);
//		BinaryTreeNode<Integer> K = new BinaryTreeNode<>(1);
//		BinaryTreeNode<Integer> L = new BinaryTreeNode<>(401);
//		BinaryTreeNode<Integer> M = new BinaryTreeNode<>(641);
//		BinaryTreeNode<Integer> N = new BinaryTreeNode<>(257);
//		BinaryTreeNode<Integer> O = new BinaryTreeNode<>(271);
//		BinaryTreeNode<Integer> P = new BinaryTreeNode<>(28);
//		
//		root = A;
//		
//		connect(A,B,I);
//		connect(B,C,F);
//		connect(C,D,E);
//		connect(D,null,null);
//		connect(E,null,null);
//		connect(F,null,G);
//		connect(G,H,null);
//		connect(H,null,null);
//		connect(I,J,O);
//		connect(J,null,K);
//		connect(K,L,N);
//		connect(L,null,M);
//		connect(M,null,null);
//		connect(N,null,null);
//		connect(O,null,P);
//		connect(P,null,null);
//		
//		System.out.println("Tree Constructed");
//	}
	
	
	public void postorder(Queue<BinaryTreeNode<Integer>> stack, Queue<BinaryTreeNode<Integer>> result){
		
		BinaryTreeNode<Integer> current = stack.poll();
		if(current!=null){
			if(current.left!=null){
				stack.add(current.left);
				postorder(stack,result);
			}
			if(current.right!=null){
				stack.add(current.right);
				postorder(stack,result);
			}
			result.add(current);
		}
		return;
	}
	
	public void postorderTraversal(){
		
		Queue<BinaryTreeNode<Integer>> stack = new LinkedList<BinaryTreeNode<Integer>>();
		Queue<BinaryTreeNode<Integer>> result = new LinkedList<BinaryTreeNode<Integer>>();
		
		if(root!=null){
			stack.add(root);
			postorder(stack, result);
		}
		
		System.out.print("Post Order Traversal: " + result.toString());
		
	}
	
	
	public class hS{
		public int h;
		public boolean bal;

		public hS(int hi, boolean status){
			this.h = hi;
			this.bal = status;
		}
	}
	
	
	public static class Node<T>{
		public T data;
		public Node<T> left, right;
		
		public Node(T val){
			data = val;
			left = null;
			right = null;
		}
		
		public String toString(){
			return data.toString();
		}
		
	}
	
	public hS exploreLeft(BinaryTreeNode<Integer> N, int h){
		if(N.left==null) return new hS(h,true);
		else return explore(N.left, h+1);
	}
	
public hS exploreRight(BinaryTreeNode<Integer> N, int h){
		
		if(N.right==null) return new hS(h,true);
		
		return explore(N.right, h+1);
		
		
	}
	
	public hS explore(BinaryTreeNode<Integer> N, int h){
		hS test = new hS(h,true);
		
		hS LHS = exploreLeft(N, h);
		hS RHS = exploreRight(N, h);
		
		boolean bal = Math.abs(LHS.h - RHS.h) <= 1 ? true:false;
		int maxH = Math.max(LHS.h, RHS.h);
		
		if((!bal) || (!LHS.bal) || (!RHS.bal)){
			return new hS(maxH, false);
		}
		
		return new hS(maxH, true);
	}
	
	

	public BinaryTree(){
		
		//tree on page 139
		
		if (root != null) System.out.println("ERROR already initiliazrd");
		
		BinaryTreeNode<Integer> A = new BinaryTreeNode<>(314);
		BinaryTreeNode<Integer> B = new BinaryTreeNode<>(6);
		BinaryTreeNode<Integer> C = new BinaryTreeNode<>(561);
		BinaryTreeNode<Integer> D = new BinaryTreeNode<>(3);
		BinaryTreeNode<Integer> E = new BinaryTreeNode<>(6);
		BinaryTreeNode<Integer> F = new BinaryTreeNode<>(561);
		BinaryTreeNode<Integer> G = new BinaryTreeNode<>(3);
//		BinaryTreeNode<Integer> H = new BinaryTreeNode<>(17);
//		BinaryTreeNode<Integer> I = new BinaryTreeNode<>(6);
//		BinaryTreeNode<Integer> J = new BinaryTreeNode<>(2);
//		BinaryTreeNode<Integer> K = new BinaryTreeNode<>(1);
//		BinaryTreeNode<Integer> L = new BinaryTreeNode<>(401);
//		BinaryTreeNode<Integer> M = new BinaryTreeNode<>(641);
//		BinaryTreeNode<Integer> N = new BinaryTreeNode<>(257);
//		BinaryTreeNode<Integer> O = new BinaryTreeNode<>(271);
		
	
		root = A;
		
		connect(A,B,E);
		connect(B,null,C);
		connect(C,null,D);
		
		connect(E,F,null);
//		connect(F,G,null);
		
		connect(D,null,null);
		connect(F,G,null );
		connect(G,null,null);
		
		System.out.println("Tree Constructed");
		
	}
	
public void BinaryTree2(){
		
		//tree on page 139
		
		if (root != null) System.out.println("ERROR already initiliazrd");
		
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
		
	
		root = A;
		
		connect(A,B,K);
		connect(B,C,H);
		connect(C,D,G);
		connect(D,E,F);
		connect(H,I,J);
		connect(L,M,N);
		connect(K,L,O);
		
		
		connect(E,null,null);
		connect(F,null,null);
		connect(I,null,null);
		connect(J,null,null);
		connect(M,null,null);
		connect(N,null,null);
		connect(O,null,null);
		connect(G,null,null);
		
		System.out.println("Tree Constructed");
		
	}

	public boolean isBalanced(){
//		System.out.println(root.data);
		hS res = explore(root, 0);
		this.height = res.h;
		return res.bal;
	}
	
	
//	public List<Integer> subTree(BinaryTreeNode<Integer> N){
//		
//		if(N==null) return new LinkedList<Integer>();
//		List<Integer> LST = subTree(N.left);
//		List<Integer> RST = subTree(N.right);
//		LST.addAll(RST);
//		LST.add(N.data);
//		return LST;
//		
//		
//	}
//	
//	
//	public boolean isSym(){
//		List<Integer> LST = subTree(root.left);
//		List<Integer> RST = subTree(root.right);
//		return LST.equals(RST);
//
//	}
	
	public boolean sym(BinaryTreeNode<Integer> left, BinaryTreeNode<Integer> right){
		if(left==null && right==null){
			return true;
		}
		if(left!=null & right != null){
			return sym(left.left, right.right) && sym(left.right, right.left) && left.data==right.data;
		}
		return false;
	}
	
	public boolean isSym(){
		if(root==null) return true;
		return sym(root.left, root.right);
	}
	
	
	public static void main(String[] args){
		
		BinaryTree t = new BinaryTree();
		System.out.println(t.isSym());
//		if(t.root.left==null) System.out.println(t.root.left);
//		
//		System.out.println(t.isBalanced());
//		System.out.println(t.height);
		
//		List<Integer> left = new LinkedList<Integer>();
//		List<Integer> right = new LinkedList<Integer>();
//		left.addAll(right);
//		left.add(5);
//		boolean a;
//		a = false && false;
//		System.out.println(a);
	}
	
}