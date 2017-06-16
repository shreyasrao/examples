package trees;
import java.util.ArrayList;
import java.util.List;

import trees.Node;

public class traversal{
	
	public static List<Nwp> inorder(Nwp root){
		
		/*
		 * inorder traversal, uses iterative approach along with just O(1) space
		 * not including storing traversal path. Storage can be removed by using
		 * print statements to reach O(1). Current implementation is easier for testing
		*/
		
		List<Nwp> res = new ArrayList<Nwp>();
		Nwp prev = null, curr = root;
		
		while(curr!=null) {
			Nwp next;
			
			if(prev==curr.parent) {
				//visiting this node for first time (check left first)
				if(curr.left!=null) {
					//go left
					next = curr.left;
				}
				else {
					res.add(curr);
					next = (curr.right!=null) ? curr.right : curr.parent;
				}
			}
			else if (prev==curr.left) {
				//go right or back
				res.add(curr);
				next = (curr.right!=null) ? curr.right : curr.parent;
			}
			else {
				//go back up
				next = curr.parent;
			}
			prev = curr;
			curr = next;
		}
		
		return res;
	}
	
	public static List<Node> inorder(Node root, List<Node> order) {
		if(root==null) return order;
		if(root.left!=null) inorder(root.left,order);
		order.add(root);
		if(root.right!=null) inorder(root.right,order);
		return order;
	}
	
	public static List<Node> preorder(Node root, List<Node> order){
		if(root==null) return order;
		order.add(root);
		if(root.left!=null) preorder(root.left, order);
		if(root.right!=null) preorder(root.right, order);
		return order;
		
	}
	
	public static List<Node> postorder(Node root, List<Node> order){
		if(root==null) return order;
		if(root.left!=null) postorder(root.left, order);
		if(root.right!=null) postorder(root.right, order);
		order.add(root);
		return order;
	}
	
	public static class info{
		boolean bal;
		int height;
		
		public info(int h, boolean b) {
			this.height = h;
			this.bal = b;
		}
	}
	
	public static boolean isBalanced(Node root) {
		return heightBalanced(root).bal;
	}
	
	public static info heightBalanced(Node root) {
		
		/*
		 * Check if tree is height balanced
		 * this means hieght difference between left and right sub tree
		 * is at most 1
		 * */
		
		info leftInfo, rightInfo;
		if(root.left!=null) leftInfo = heightBalanced(root.left);
		else leftInfo = new info(0,true);
		
		if(root.right!=null) rightInfo = heightBalanced(root.right);
		else rightInfo = new info(0,true);
		
		boolean b = (rightInfo.bal==false || leftInfo.bal==false) ? false : 
			(Math.abs(rightInfo.height - leftInfo.height) <= 1 ? true : false);
		int h = Integer.max(leftInfo.height, rightInfo.height) + 1;
		return new info(h,b);
	}
	
	public static boolean isSymmetric(Node root) {
		
		/*
		 * is left and right sub trees mirror images of each other
		 * Note: mirror image! so
		 * 	left.right == right.left &
		 * 	left.left == right.right
		 * This logic is apparent in the overloaded helper function:
		 * 	isSysmmertic(Node,Node)
		 * */
		
		if(root==null) return true;
		return isSymmetric(root.left,root.right);
	}
	
	public static boolean isSymmetric(Node leftTree, Node rightTree) {
		if(leftTree==null && rightTree == null) return true;
		if(leftTree!=null && rightTree!=null) {
			return leftTree.data == rightTree.data &&
				isSymmetric(leftTree.left,rightTree.right) &&
				isSymmetric(leftTree.right, rightTree.left);
		}
		return false;
	}
	
}