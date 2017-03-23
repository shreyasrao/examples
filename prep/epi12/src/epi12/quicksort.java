package epi12;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class quicksort{
	
	public static int getPivIndex(List<Integer> A, int l, int r) {

		System.out.println(A);
		System.out.println("sorting between " + l +" and " + r);
		int pIndex = ThreadLocalRandom.current().nextInt(l, r+1);
		
		Integer pivot = A.get(pIndex);
		Collections.swap(A, pIndex, l);
		pIndex = l++;

		while(l<=r) {
			if(A.get(l)<=pivot) l++;
			else {
				if(A.get(r)<=pivot) Collections.swap(A, r, l++);
				else r--;
			}
		}
		
		Collections.swap(A, pIndex, r);
		System.out.println("Done sort "+ A);
		return r;
		
	}
	
	public static int sort(List<Integer> A, int low, int high) {
		if(high-low < 0 ) return -1;
		
		int piv = getPivIndex(A,low,high);
		sort(A,low,piv-1);
		sort(A,piv+1,high);
		
		return piv;
	}
	
	
	public static void main(String[] args) {
//		System.out.println("HELLO");
		List<Integer> a = new ArrayList<>(Arrays.asList(0,-7,33,-5,5,4,-9,5));
//		System.out.println(a);
		sort(a,0,a.size()-1);
//		System.out.println("Pivot Index is " + sort(a,0,a.size()-1));
		System.out.println(a);
	}
}