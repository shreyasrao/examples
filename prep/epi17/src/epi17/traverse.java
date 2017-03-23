package epi17;

import java.util.Arrays;

public class traverse{
	
	public static int ways(int rows, int cols) {
		int[][] grid = new int[rows][cols];
		grid[0][0] = 1;
		return getWays(rows-1,cols-1,grid);
	}

	private static int getWays(int i, int j, int[][] grid) {
		if(i<0 || j< 0) return 0;
		
		if(grid[i][j]==0) {
			grid[i][j] = getWays(i-1,j,grid) + getWays(i,j-1,grid);
		}
		return grid[i][j];
	}
	
	public static void main(String[] args) {
		
		System.out.println( ways(5,5));
//		int[][] aa = new int[3][2];
//		System.out.println(aa[0][1]);
	}
	
	
}