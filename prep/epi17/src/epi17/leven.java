package epi17;

import java.util.Arrays;

public class leven{
	
	public int calcleven(String A, String B) {
		int[][] dist = new int[A.length()][B.length()];
		for(int[] row: dist) {Arrays.fill(row, -1);}
		
		return dist(A, A.length() - 1, B, B.length()-1, dist);
		
	}
	
	public int dist(String A, int aIdx, String B, int bIdx, int[][] dist) {
		
		if(aIdx<0) {
			return bIdx + 1;
		} else if(bIdx<0) {
			return aIdx + 1;
		}
		
		if(dist[aIdx][bIdx]==-1) {
			if(B.charAt(bIdx)==A.charAt(aIdx)) {
				dist[aIdx][bIdx] = dist(A, aIdx-1, B, bIdx-1, dist);
			}
			else {
				int sub = dist(A, aIdx-1, B, bIdx-1, dist);
				int add = dist(A, aIdx, B, bIdx-1, dist);
				int del = dist(A, aIdx-1, B, bIdx, dist);
				dist[aIdx][bIdx] = 1 + Integer.min(sub, Integer.min(add, del));
				
			}
		}
		
		
		return dist[aIdx][bIdx];
		
	}
	
	
	
	public static void main(String[] args) {
		leven a = new leven();
		System.out.println( a.calcleven("Carthorse","Orchestra"));
	}
	
	
}