package pset1;
import java.util.HashSet;
import java.util.Set;
public class SLList {
    Node header;
    static class Node {
        int elem;
        Node next;
    }
    
    boolean repOk() {
        // postcondition: returns true iff <this> is an acyclic list, i.e.,
        //                          there is no path from a node to itself,
        //                          and the elements are sorted (<=)
        Set<Node> visited = new HashSet<Node>();
        Node n = header;
        while (n != null) {
            if (!visited.add(n)) {
                return false;
            }
            if (n.next != null) {
                if (n.elem > n.next.elem) return false;
            }
            n = n.next;
        }
        return true;
    }
    
    
    void add(int e) {
        // precondition: this.repOk()
        // postcondition: adds <e> in a new node in the list in sorted order;
        //                the rest of the list is unmodified
    	Node in = new Node();
		in.elem = e;
		in.next = null;
		
    	if(header==null){
    		header = new Node();
    		header.next = in;
    		header.next.elem = e;
//    		header.next = null;
    	}else{
    		Node n = header;
    		while(n.next!=null){
//    			if(n.elem>=e){
//    				in.next = n;
//    				header = in;
//        		}else
        		if(n.next.elem>=e){
        			in.next = n.next;
        			n.next = in;
        			return;
        		}else{
        			n = n.next;
        		}
    		}
    		n.next = in;
    		
    		
    	}
    	
    }
    
}