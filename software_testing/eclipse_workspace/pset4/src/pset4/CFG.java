package pset4;
import java.util.*;

import org.apache.bcel.Repository;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;
import org.apache.bcel.generic.ClassGen;
import org.apache.bcel.generic.ConstantPoolGen;

public class CFG {
    Set<Node> nodes = new HashSet<Node>();
    Map<Node, Set<Node>> edges = new HashMap<Node, Set<Node>>();
    Map<String, Set<String>> invocations = new HashMap<String, Set<String>>();
    public static class Node {
        int position;
        Method method;
        JavaClass clazz;
        Node(int p, Method m, JavaClass c) {
            position = p;
            method = m;
            clazz = c;
        }
        
        public Method getMethod() {
            return method;
        }
        
        public JavaClass getClazz() {
            return clazz;
        }
        
        public boolean equals(Object o) {
            if (!(o instanceof Node)) return false;
            Node n = (Node)o;
            return (position == n.position) && method.equals(n.method) && clazz.equals(n.clazz);
        }
        
        public int hashCode() {
            return position + method.hashCode() + clazz.hashCode();
        }
        
        public String toString() {
            return clazz.getClassName() + "." + method.getName() + method.getSignature() + ": " + position;
        }
    }
    
    public void addNode(int p, Method m, JavaClass c) {
        addNode(new Node(p, m, c));
    }
    
    private void addNode(Node n) {
        nodes.add(n);
        Set<Node> nbrs = edges.get(n);
        if (nbrs == null) {
            nbrs = new HashSet<Node>();
            edges.put(n, nbrs);
        }
    }
    
    public void addEdge(int p1, Method m1, JavaClass c1, int p2, Method m2, JavaClass c2) {
        Node n1 = new Node(p1, m1, c1);
        Node n2 = new Node(p2, m2, c2);
        addNode(n1);
        addNode(n2);
        Set<Node> nbrs = edges.get(n1);
        nbrs.add(n2);
        edges.put(n1, nbrs);
    }
    
    public void addEdge(int p1, int p2, Method m, JavaClass c) {
        addEdge(p1, m, c, p2, m, c);
    }
    
    public String toString() {
        return nodes.size() + " nodes\n" + "nodes: " + nodes + "\n" + "edges: " + edges;
    }
    
    public boolean isReachable(String methodFrom, String clazzFrom, String methodTo, String clazzTo) {
        // you will implement this method in Question 2.2
    	System.out.println("IS REACHABLE			");
    	Set<String> calls = this.invocations.get(methodFrom);
    	if(calls != null){
    		if(calls.contains(methodTo)) return true;
    	}
    	return false;
    	/*
    	Method fromMethod = null;
    	Method toMethod = null;
    	JavaClass jc = null;
    	try {
			jc = Repository.lookupClass(clazzFrom);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	ClassGen cg = new ClassGen(jc);
        ConstantPoolGen cpg = cg.getConstantPool();
        for (Method m: cg.getMethods()) {
        	if(methodFrom.equals(m.getName())) {
        		fromMethod = m;
        		System.out.println("MATCHED " + methodFrom + " to " + m);
        	}
        	
        	if(methodTo.equals(m.getName())) {
        		toMethod = m;
        		System.out.println("MATCHED " + methodTo + " to " + m);
        	}
        	
//        	else{
//        		System.out.println(m.getName());
//        	}
        }
        if(fromMethod == null || toMethod == null) return false;
        if(fromMethod.equals(toMethod)) return true;
        
        Set<Node> visited = new HashSet<Node>();	
    	
        Node n1 = new Node(0, fromMethod, jc);
        Set<Node> nbrs = edges.get(n1);
        while(!(nbrs.isEmpty())){

        	
        	for(Node node: nbrs){
        		if(node.getMethod().equals(toMethod) && node.position==0) return true;
        		
        		Set<Node> newNbrs = new HashSet<Node>();
        		if(edges.get(node).isEmpty()) break;
        		for(Node nbrsNode: edges.get(node)){
        			newNbrs.add(nbrsNode);
        		}
        		nbrs.addAll(newNbrs);
        		nbrs.remove(node);
        		break;
        	}
        }
        
    	return false;
    	*/
    	
    }
}