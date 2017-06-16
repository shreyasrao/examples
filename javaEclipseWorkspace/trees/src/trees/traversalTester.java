package trees;
import trees.Node;
import trees.Nwp;
import trees.traversal;
import trees.traversal.info;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class traversalTester{
	
	public static void connect(Node root, Node l, Node r) {
		root.left = l;
		root.right = r;
	}
	
	public static void connect(Nwp root, Nwp l, Nwp r) {
		root.left = l;
		if(l!=null) root.left.parent = root;
		root.right = r;
		if(r!=null) root.right.parent = root;
	}
	
	@Test
	public void nr1() {
		Nwp A = new Nwp("A");
		Nwp B = new Nwp("B");
		Nwp I = new Nwp("I");
		connect(A,B, I);
		assertEquals(new ArrayList<Nwp>(Arrays.asList(B,A,I)),traversal.inorder(A));
	}
	
	@Test
	public void in1() {
		Node A = new Node("A");
		Node B = new Node("B");
		Node I = new Node("I");
		connect(A,B, I);
		System.out.println();
//		List<Node> res = 
		assertEquals(new ArrayList<Node>(Arrays.asList(B,A,I)),traversal.inorder(A, new ArrayList<Node>()));
	}
	
	@Test
	public void pre1() {
		Node A = new Node("A");
		Node B = new Node("B");
		Node I = new Node("I");
		connect(A,B, I);
		assertEquals(new ArrayList<Node>(Arrays.asList(A,B,I)),traversal.preorder(A, new ArrayList<Node>()));
	}
	
	@Test
	public void post1() {
		Node A = new Node("A");
		Node B = new Node("B");
		Node I = new Node("I");
		connect(A,B, I);
		assertEquals(new ArrayList<Node>(Arrays.asList(B,I,A)),traversal.postorder(A, new ArrayList<Node>()));
	}
	
	@Test
	public void nr2() {
		Nwp A = new Nwp(314);
		Nwp B = new Nwp(6);
		Nwp C = new Nwp(271);
		Nwp D = new Nwp(28);
		Nwp E = new Nwp(0);
		Nwp F = new Nwp(561);
		Nwp G = new Nwp(3);
		Nwp H = new Nwp(17);
		Nwp I = new Nwp(6);
		Nwp J = new Nwp(2);
		Nwp K = new Nwp(1);
		Nwp L = new Nwp(401);
		Nwp M = new Nwp(641);
		Nwp N = new Nwp(257);
		Nwp O = new Nwp(271);
		Nwp P = new Nwp(28);

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
		
		assertEquals(new ArrayList<Nwp>(Arrays.asList(D,C,E,B,F,H,G,A,J,L,M,K,N,I,O,P)),traversal.inorder(A));
		
	}
	
	@Test
	public void in2() {
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
		
		assertEquals(new ArrayList<Node>(Arrays.asList(D,C,E,B,F,H,G,A,J,L,M,K,N,I,O,P)),traversal.inorder(A, new ArrayList<Node>()));
		
	}
	
	@Test
	public void pre2() {
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
		
		assertEquals(new ArrayList<Node>(Arrays.asList(A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P)),traversal.preorder(A, new ArrayList<Node>()));
		
	}
	
	@Test
	public void post2() {
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
		
		assertEquals(new ArrayList<Node>(Arrays.asList(D,E,C,H,G,F,B,M,L,N,K,J,P,O,I,A)),traversal.postorder(A, new ArrayList<Node>()));
		
	}
	
	@Test
	public void hb1() {
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
		assertTrue(traversal.isBalanced(A));
	}
	
	@Test
	public void hb2() {
		Node A = new Node(314);
		Node B = new Node(6);
		Node C = new Node(271);
		
		connect(A,B,null);
		connect(B,C,null);
		assertFalse(traversal.isBalanced(A));
	}
	
	@Test
	public void sym1() {
		Node A = new Node(314);
		Node B = new Node(6);
		Node E = new Node(6);
		connect(A,B,E);
		assertTrue(traversal.isSymmetric(A));
	}
	
	@Test
	public void sym2() {
		Node A = new Node(314);
		Node B = new Node(6);
		Node E = new Node(6);
		Node C = new Node(2);
		Node F = new Node(2);
		Node D = new Node(3);
		Node G = new Node(3);
		
		
		connect(A,B,E);
		connect(B,null,C);
		connect(C,null,D);
		connect(E,F,null);
		connect(F,G,null);
		assertTrue(traversal.isSymmetric(A));
	}
	
	@Test
	public void sym3() {
		Node A = new Node(314);
		Node B = new Node(6);
		Node E = new Node(6);
		Node C = new Node(561);
		Node F = new Node(2);
		Node D = new Node(3);
		Node G = new Node(1);
		
		
		connect(A,B,E);
		connect(B,null,C);
		connect(C,null,D);
		connect(E,F,null);
		connect(F,G,null);
		assertFalse(traversal.isSymmetric(A));
	}
	
	@Test
	public void sym4() {
		Node A = new Node(314);
		Node B = new Node(6);
		Node E = new Node(6);
		Node C = new Node(2);
		Node F = new Node(2);
		Node D = new Node(3);
		Node G = new Node(3);
		
		
		connect(A,B,E);
		connect(B,null,C);
		connect(C,null,D);
		connect(E,F,null);
		assertFalse(traversal.isSymmetric(A));
	}
}