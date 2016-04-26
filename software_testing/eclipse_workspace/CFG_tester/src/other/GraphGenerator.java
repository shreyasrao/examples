package other;
import java.util.*;
public class GraphGenerator{
	public static Graph g = null;
	
	public static void main(String[] args){
		
		//example from page 67 of software testing book
		//the sol was given in hw so easy to check implementation
		//E = {(1,2),(1,7),(2,3),(2,4),(3,2),(4,5),(4,6),(5,6),(6,1)}
		g = new Graph();
		g.addEdge(1, 7);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(2, 4);
		g.addEdge(3, 2);
		g.addEdge(4, 5);
		g.addEdge(4, 6);
		g.addEdge(5, 6);
		g.addEdge(6, 1);
		g.genPaths();
//		System.out.println(g.paths);
//		System.out.println(g.cycles);
		g.reduce();
		System.out.println(g.cycles);
		System.out.println(g.paths);
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(7);
		ArrayList<Integer> b = new ArrayList<Integer>();
		b.add(3);
		b.add(7);
		System.out.println(g.subpath(a,b));
		//{3,5}
//		System.out.println(g.edges.get(1));
//		Map<Integer, ArrayList<Integer>> a = new TreeMap<Integer, ArrayList<Integer>>();
	}
	
	
}