package dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class knapsack{
	
	/*
	 * Classic knapsack dynamic programming problem
	 * solution uses O(mn) space with O(mn) runtime
	 * where n is number of items and m is max capacity (i.e. weight)
	 * */
	
	public static class item{
		int weight, value;
		
		public item(int w, int val) {
			weight = w;
			value = val;
		}
	}
	
	public static int getMax(List<item> A, int capacity) {
		List<List<Integer>> M = new ArrayList<List<Integer>>();
		for(int i=0;i<A.size();i++) {
			M.add(new ArrayList<Integer>(Collections.nCopies(capacity+1, -1)));
		}
		return getMax(A,M);
		
	}
	
	public static int getMax(List<item> A, List<List<Integer>> M) {
		
		for(int i=0;i<A.size();i++) {
			item curr = A.get(i);
			
			for(int j=0;j<M.get(0).size();j++) {
				int with, without;
				without = (i>0) ? M.get(i-1).get(j) : 0; 
				with = (curr.weight>j) ? 0 :
					(j-curr.weight>=0) ? curr.value + M.get(i).get(j - curr.weight) : curr.value; 
				M.get(i).set(j, Integer.max(with, without));
			}
		}
		return M.get(M.size()-1).get(M.get(0).size()-1);
	}
	
}