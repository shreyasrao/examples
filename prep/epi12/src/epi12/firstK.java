package epi12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class firstK{
	
	public static int kIdx;
	
	public static int findK(List<Integer> A, int k) {
		kIdx = Integer.MAX_VALUE;
		S(A,k,0,A.size()-1);
		return kIdx;
	}
//	System.out.println("Searching " + low + " : " + high + " mid is: " + mid);
	public static void S(List<Integer> A, int k, int low, int high) {
		if(high < low) return;
		
		int mid = low + (high - low)/2;
		
		int midVal = A.get(mid);
		if(midVal == k) {
			if(mid < kIdx) kIdx = mid;
			S(A,k,low,mid-1);
		}
		else if(midVal<k) {
			S(A,k,mid+1,high);
		}
		else {
			S(A,k,low,mid-1);
		}
	}
	
	
	public static void main(String[] args) {
		List<Integer> A = new ArrayList<Integer>(Arrays.asList(-14,-10,2,108,108,243,285,285,285,401));
		System.out.println(findK(A,285));
	}
	
}