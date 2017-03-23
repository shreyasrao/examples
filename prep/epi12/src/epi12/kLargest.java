package epi12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class kLargest{
	
	public static int pIdx=-1;
	
	public static int largest(List<Integer> A, int low, int high, int k) {
		
		int idx = low;
		pIdx = low + (int)(Math.random() * ((high - low) + 1));
		System.out.println("Started. pIdx = " + pIdx);
		
		
		while(pIdx < high && idx<=high) {
//			System.out.println(idx);
			if(A.get(idx) <= A.get(pIdx) && idx>pIdx) {
				Collections.swap(A, pIdx + 1, idx);
				Collections.swap(A, pIdx, pIdx + 1);
				pIdx++;
			}
			idx++;
		}
		
		System.out.println(pIdx + " ? " + A.toString());
		
		
		if(pIdx<A.size()-k) {
			largest(A,pIdx+1,high,k);
		}
		if(pIdx > A.size()-k){
			largest(A,low,pIdx,k);
		}
		
		return A.get(pIdx);
		
	}
	
	public static int go(List<Integer>A, int k) {
		int low = 0;
		int high = A.size()-1;
		pIdx = low + (int)(Math.random() * ((high - low) + 1));
		pIdx = partition(A,pIdx,low,high);
		
		while(pIdx!=A.size()-k) {
			
			if(pIdx<A.size()-k) {
				low = pIdx;
			}
			else {
				high = pIdx;
			}
			int newPivot = low + (int)(Math.random() * ((high - low) + 1));
			pIdx = partition(A,newPivot,low,high);
		}
		return A.get(pIdx);
	}
	
	public static int partition(List<Integer> A, int pIdx, int low, int high) {
		int pivotElem = A.get(pIdx);
		int currentElem = A.get(low);
		while(low<=high) {
			if(currentElem<pivotElem) {
				low++;
			}
			else {
				if(A.get(high)<pivotElem) {
					Collections.swap(A, high, low);
					high--;
					low++;
				}
				else {
					high--;
				}
			}
			currentElem = A.get(low);
		}
		Collections.swap(A, pIdx, low);
		return low;
		
		//		int idx = low;
//		int pIdx = low + (int)(Math.random() * ((high - low) + 1));
//		while(idx<=high) {
//			if(A.get(idx)<=A.get(pIdx)) {
//				//elem <= pivotElem
//				if(idx>pIdx) {
//					Collections.swap(A, pIdx + 1, idx);
//					Collections.swap(A, pIdx, pIdx + 1);
//					pIdx++;
//				}
//				idx++;
//			}
//			else {
//				//elem > pivotElem
//				if(idx<pIdx) {
//					Collections.swap(A, idx, high);
//					high--;
//				}
//			}
//			
//		}
		
	}
	
	
	public static void main(String[] args) {
		List<Integer> A = new ArrayList<Integer>(Arrays.asList(3,2,1,5,4));
//		System.out.println(largest(A,0,A.size()-1,5));
		System.out.println(go(A,3));
	}
	
}