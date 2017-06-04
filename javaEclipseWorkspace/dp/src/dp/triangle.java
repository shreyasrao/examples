package dp;

import java.util.Collections;
import java.util.List;

public class triangle{
	
	/*
	 * Triangle of 'blocks' is given in the form of list<list<>> triangle
	 * Starting from the top of triangle, what is the min weight path to
	 * the bottom? The path must be continous, i.e. can only consider
	 * neighboring blocks on the path
	 * 
	 * */
	
	public static int topVal(List<List<Integer>> A,int rowIdx,int i) {
		if((rowIdx==0)) return 0;
		if((i<0)) return A.get(rowIdx-1).get(0);
		if((i==A.get(rowIdx).size()-1)) return A.get(rowIdx-1).get(i-1);
		return A.get(rowIdx-1).get(i);
	}
	
	public static int minWeight(List<List<Integer>> triangle) {
		List<Integer> currRow = null;
		int val = 0;
		for(int row=0;row<triangle.size();row++) {
			currRow = triangle.get(row);
			for(int i=0;i<currRow.size();i++) {
				val = Integer.min(topVal(triangle,row,i-1), topVal(triangle,row,i))
						+ currRow.get(i);
				currRow.set(i,val);
			}
		}
		return Collections.min(currRow);
	}
	
}