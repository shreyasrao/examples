package epi14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class sorting{
	
	public static List<Integer> intersect(List<Integer> A, List<Integer> B) {
		List<Integer> res = new ArrayList<Integer>(); 
		
		int aIdx = 0;
		int bIdx = 0;
		int lastVal = Integer.MIN_VALUE;
//		int i=0;
		while(aIdx < A.size() && bIdx < B.size()) {
			int a = A.get(aIdx);
			int b = B.get(bIdx);
			
			if(a==b) {
				
				if(A.size()==0 || a!=lastVal) {
					res.add(a);
					lastVal = a;
				}
				aIdx++;
				bIdx++;
				
			}
			else if(a<b) {
				aIdx++;
			}
			else {
				bIdx++;
			}
			
		}
		return res;
		
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		List<Integer> A = new ArrayList<>(Arrays.asList(2,3,3,5,5,6,7,7,8,12));
		List<Integer> B = new ArrayList<>(Arrays.asList(5,5,6,8,8,9,10,10));
		List<Integer> res = intersect(A,B);
		System.out.println(res.toString());
	}
}