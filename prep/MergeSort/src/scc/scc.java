package scc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class scc{
	
	public static Map<Integer,Set<Integer>> edges = new HashMap<Integer, Set<Integer>>();
	public static Map<Integer,Set<Integer>> reverseEdges = new HashMap<Integer, Set<Integer>>();
	public static Map<Integer,Set<Integer>> RenamedGraph = new HashMap<Integer, Set<Integer>>();
	
	public static Map<Integer, Integer> f = new HashMap<Integer, Integer>();
	public static Map<Integer, Integer> leader = new HashMap<Integer, Integer>();
	
	public static int t = 0;
	public static int n = 0;
	public static Integer s = null;
	
	public static boolean firstpass = true;
	
	private static void max5(){
		
		int[] counts = new int[n+1];
		
		for(int i=0;i<=n;i++){
			counts[i] = 0;
		}
		
		for(int node:leader.values()){
			counts[node] = counts[node]+1;
		}
		
//		System.out.println(counts[6]);
//		System.out.println(counts[9]);
//		System.out.println(counts[4]);
		
//		int a=0;
//		int b=0;
//		int c=0;
//		int d=0;
//		int e=0;
		
//		TreeSet<Integer> maxCounts = new TreeSet<Integer>();
		
//		SortedList<Integer> maxCounts = new SortedList<Integer>();
		
//		for(int i:counts){
//			maxCounts.add(i);
//		}
//		
//		System.out.println(maxCounts);
		
		Arrays.sort(counts);
		
//		int[] top = new int[5];
//		for(int i=0;i<5;i++){
//			top[i] = 0;
//		}
//		
//		int i=0;
//		while(i<5 & (!maxCounts.isEmpty())){
//			top[i] = maxCounts.pollLast();
//			i++;
//		}
		System.out.println("Top 5 scc sizes are: ");
		for(int r=counts.length-1;r>=counts.length-5;r--){
			System.out.println(counts[r]);
		}
		
		
//		a = maxCounts.pollLast();
//		b = maxCounts.pollLast();
//		c = maxCounts.pollLast();
//		d = maxCounts.pollLast();
//		e = maxCounts.pollLast();
//		
//		for(int i:counts){
//			if(i>a) a = i;
//			else{
//				if(i>b) b = i;
//				else{
//					if(i>c) c = i;
//					else{
//						if(i>d) d = i;
//						else{
//							if(i>e) e = i;
//						}
//					}
//				}
//			}
//			
//		}
		
//		System.out.println(counts[4]);

//		System.out.println(a);
//		System.out.println(b);
//		System.out.println(c);
//		System.out.println(d);
//		System.out.println(e);

		
		
	}
	
	
	private static void addEdge(int a, int b){
		Set<Integer>neighbors =  edges.get(a);
		
		if(neighbors==null){
			neighbors = new TreeSet<Integer>();
		
		}
		neighbors.add(b);
		edges.put(a, neighbors);
		
		Set<Integer> reverseN = reverseEdges.get(b);
		if(reverseN==null){
			reverseN = new TreeSet<Integer>();
		
		}
		reverseN.add(a);
		reverseEdges.put(b, reverseN);
		
		
	}
	
	
	private static void DFS(int node, Set<Integer> explored, Map<Integer,Set<Integer>> graph){
//		System.out.println("INSIDE SHARED DFS");
		explored.add(node);
		leader.put(node, s);
		
		Set<Integer> arcs = graph.get(node);
		System.out.println("NODE is " + node);
		if(arcs==null){
			
		}
		else{
			for(int j:arcs){
				if(!explored.contains(j)){
					DFS(j,explored,graph);
				}
			}
		}
		
		t++;
		
		
		if(firstpass) f.put(node, t);
		
//		f.add(node, t);
		
	}
	
	private static void forwardDFS(){
		n = RenamedGraph.keySet().size();
		System.out.println("Number of nodes is " + n);
		
		Set<Integer> explored = new TreeSet<Integer>();
		
		for(int i=n;i>0;i--){
			System.out.println("Iteration num " + i);
			if(!explored.contains(i)){
				s = i;
				DFS(i, explored, RenamedGraph );
			}
			
		}
		
		
		
		System.out.println("Forward DFS complete");
		System.out.println("Forward explored:" + explored);
		
		
		System.out.println(f.toString());
		System.out.println(leader.toString());
		
		max5();
	}
	
	private static Set<Integer> renameEdges(Set<Integer> oldEdges){
		
		Set<Integer> newEdges = new TreeSet<Integer>();
		
		for(int node:oldEdges){
			newEdges.add(f.get(node));
		}
		
		return newEdges;
		
	}
	
	private static void rename(){
		int newName = 0;
		
		for(int oldName:edges.keySet()){
			Set<Integer> oldEdges = edges.get(oldName);
			
			Set<Integer> newEdges = renameEdges(oldEdges);
			
			newName = f.get(oldName);
			
			RenamedGraph.put(newName, newEdges);
		}
		
	}
	
	private static void reverseDFS(){
		n = reverseEdges.keySet().size();
		System.out.println("Number of nodes is " + n);
		
		Set<Integer> explored = new TreeSet<Integer>();
		
		for(int i=n;i>0;i--){
			System.out.println("Iteration num " + i);
			if(!explored.contains(i)){
				
				DFS(i, explored, reverseEdges );
			}
			
		}
		
		System.out.println("Reverse DFS complete");
		System.out.println("Reverse explored:" + explored);
		
		
		firstpass = false;
		rename();
		forwardDFS();
		
	}
	
	
	public static void main(String[] args) throws IOException{
		
		LineNumberReader  lnr = new LineNumberReader(new FileReader(new File("/Users/shreyas/Desktop/git-repo/shreyas/prep/MergeSort/src/scc/input.txt")));
		lnr.skip(Long.MAX_VALUE);
		
		int lines = (lnr.getLineNumber()) + 1;
		
//		System.out.println(lines);
		
		lnr.close();
		
		Scanner scanner = new Scanner(new File("/Users/shreyas/Desktop/git-repo/shreyas/prep/MergeSort/src/scc/input.txt"));
		
		while(scanner.hasNextInt()){
		   int a = scanner.nextInt();
		   int b = scanner.nextInt();
		   addEdge(a,b);
		}
		
		reverseDFS();
		
	}
	
	
}