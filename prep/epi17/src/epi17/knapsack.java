package epi17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class knapsack{
	
	public static class item{
		Integer value;
		Integer weight;
		
		public item(int v, int w) {
			this.value = v;
			this.weight = w;
		}
		
	}
	
	public static int go(List<item> l, int capacity) {
		int[][] V = new int[l.size()][capacity+1];
//		for(int[] row:V) {
//			Arrays.fill(row, -1);
//		}
		
		return fillV(l,capacity,V);
		
	}
	
	public static int fillV(List<item> l, int capacity, int[][] V) {
		
		for(int i=0;i<=capacity;i++) {
			V[0][i] = i<l.get(0).weight ? 0 : l.get(0).value;
		}
		
		for(int row = 1; row<l.size(); row++) {
			int v = l.get(row).value;
			int w = l.get(row).weight;
			
			for(int i=0;i<=capacity;i++) {
				if(w>i) {
					V[row][i] = V[row-1][i];
				}
				else {
					int withItem = v + V[row-1][i-w];
					int withoutItem = V[row-1][i];
					V[row][i] = Integer.max(withItem, withoutItem);
				}
			}
		}
		return V[l.size()-1][capacity];
		
		
	}
	
	public static void main(String[] args) {
		List<item> l = new ArrayList<item>();
		l.add(new item(60,5));
		l.add(new item(50,3));
		l.add(new item(70,4));
		l.add(new item(30,2));
		System.out.println(go(l,5));
		
	}
	
}