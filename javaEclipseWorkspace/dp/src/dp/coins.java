package dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class coins{
	
	public static int sum(List<Integer> A, int low, int high) {
		int s = 0;
		for(int i=low;i<=high;i++) s+=A.get(i);
		return s;
	}
	
	/*
	 * List of coins is given. 2 players have to select coins from either end
	 * Picking a coin from one end will expose the next coins on the end
	 * What is the max revenue for first player, given series of coins?
	 * */
	
	public static int max(List<Integer> coins, int low, int high, List<List<Integer>> M) {
		if(M.get(low).get(high)!=0) return M.get(low).get(high);
		if(low==high) {
			M.get(low).set(high,coins.get(low));
			return coins.get(low);
		}
		int front = M.get(low).get(high-1);
		front = (front==0) ? max(coins,low,high-1,M) : front;
		front = coins.get(high) + sum(coins,low,high-1) - front;
		
		int back = M.get(low+1).get(high);
		back = (back==0) ? max(coins,low+1,high,M) : back;
		back = coins.get(low) + sum(coins,low+1,high) - back;
		
		int max = Integer.max(back, front);
		M.get(low).set(high, max);
		return max;
	}
	
	public static int rev(List<Integer> coins) {
		List<List<Integer>> M = new ArrayList<List<Integer>>();
		for(int i=0;i<coins.size();i++) {
			M.add(new ArrayList<Integer>(Collections.nCopies(coins.size(),0)));
		}
		return max(coins,0,coins.size()-1,M);
	}
	
	
	
}