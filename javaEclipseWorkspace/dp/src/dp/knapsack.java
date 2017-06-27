package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class knapsack{
	
	public static class item{
		int weight, value;
		
		public item(int w, int val) {
			weight = w;
			value = val;
		}
	}
	
	public static int getMax(List<item> A, int capacity) {
		
		/*
		 * Classic knapsack dynamic programming problem
		 * solution uses O(mn) space with O(mn) runtime
		 * where n is number of items and m is max capacity (i.e. weight)
		 * */
		
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
	
	public static int divideSpoils(int[] A) {
		/*
		 * Given array of item values, split them into 2 subset
		 * such that the difference between sub set sums is as
		 * small as possible
		 * Return gives sum of largest subset <= sum/2;
		 * Trivially the other subset is sum - return val
		 * */
		
		int N = A.length;
		int sum = 0;
		for(int a:A) sum += a;
		
		//find the target sum by ceil(sum/2)
		sum = (sum%2==0) ? sum/2 : sum/2 + 1;
		boolean M[][] = new boolean[N+1][sum+1];
		
		// when sum=0, all n values are true
		for(int i=0;i<N+1;i++) M[i][0] = true;
		
		// when sum!=0 and n!=0, all values are false
		for(int j=1;j<sum+1;j++) M[0][j] = false;
		
		for(int n=1;n<N+1;n++) {
			
			for(int s=1;s<sum+1;s++) {
				boolean m = M[n-1][s]; //exclude current element 				
				//if current s gte to element, then consider including element
				M[n][s] = (s>=A[n-1]) ? m || M[n-1][s-A[n-1]] : m ;
			}
			
		}
		
		// once we have filled M, traverse to find largest s thats true
		int res=0;
		for(int i=sum;i>=0;i--) {
			if(M[N][i]) {
				res = i;
				break;
			}
		}
		getItems(M,res,A); // This is an optional method call. Can be commented out
		return res;
	}
	
	public static void getItems(boolean M[][], int sum, int items[]) {
		/*
		 * Optional method call which allows use to trace the matrix M
		 * that was populated in the divideSpoils method to determine
		 * which items from input array are used to generate the sum
		 * */
		
		List<Integer> A = new ArrayList<>();
		int col = sum;
		int row = items.length;
		while(col>0 && row>0) {
			if(M[row][col]) {
				if(M[row-1][col]) row--; //this means the item was not used to get sum
				else {
					/*
					 * this implies that this item was actually used to 
					 * generate the sum. Add it to List<> A
					 * */
					
					A.add(items[row-1]);
					col = col - items[row-1];
					row--;
				}
			}
		}
		System.out.println("Item values: " + A);
	}
	
	public static void divideEqualItems(int[] A, List<Integer> a, List<Integer> b) {
		Arrays.sort(A);
		int n = A.length-1;
		
		int aSum = A[n];
		int bSum = 0;
		a.add(A[n--]);
		List<Integer> curr = b;
		
		// start adding elements into array with smaller sum
		// stop when all elems are accounted for, or if one array
		// reaches half the size of input array
		
		while(n>=0 && curr.size()<A.length/2) {
			curr.add(A[n]);
			
			if(curr==a) aSum += A[n--];
			else bSum += A[n--];
			
			if(aSum==bSum) {
				curr = (a.size()<b.size()) ? a :
					(b.size() < a.size()) ? b : a;
			}
			else if(aSum<bSum) curr = a;
			else curr = b;
		}
		
		//the top loop can end before all items are accounted for
		//run this loop to fill remaining items into smaller array
		curr = (a.size()<b.size()) ? a : b;
		while(n>=0) {curr.add(A[n--]);}
		return;
	}
}