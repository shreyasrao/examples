package epi6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class arr{
	
	public static enum Color {red,white,blue};
	
	public static void flag(int pivIdx, List<Color> A) {
		int left = 0;
		int right = A.size() - 1;
		Color lC, rC;
		while(left<right) {
			Color piv = A.get(pivIdx);
			lC = A.get(left);
			rC = A.get(right);
			if(lC.ordinal() < piv.ordinal()) {
				left++;
			}
			else if (lC.ordinal()==piv.ordinal()) {
				
			}
			else {
				if(rC.ordinal()<piv.ordinal()) {
					Collections.swap(A, left, right);
					left++;
					right--;
				}
				else if(rC.ordinal()==piv.ordinal()) {
					
				}
			}
			
		}
	}
	
	public static void dutch(int pivIdx, List<Color> A) {
		Color pivot = A.get(pivIdx);
		
		int smaller =0, equal = 0, larger = A.size();
		
		while(equal<larger) {
			if(A.get(equal).ordinal()<pivot.ordinal()){
				Collections.swap(A, smaller++, equal++);
			}
			else if(A.get(equal).ordinal()==pivot.ordinal()) {
				++equal;
			}
			else {
				Collections.swap(A, equal, --larger);
			}
		}
		
	}
	
	public static void dutch2(int pivIdx, List<Color> A) {
		Color pivot = A.get(pivIdx);
		int smaller = 0, equal = 0, larger = A.size()-1;
		
		while(equal<larger) {
			if(A.get(equal).ordinal()<pivot.ordinal()) {
				Collections.swap(A, equal++, smaller++);
//				equal++;
//				smaller++;
			}
			else if(A.get(equal).ordinal()==pivot.ordinal()) {
				equal++;
			}
			else {
				Collections.swap(A, equal, larger--);
//				larger--;
			}
		}
		
		
	}
	
	
	public static void evenFirst(int[] A) {
		
		int eP = A.length % 2 == 0 ? A.length-2 : A.length-1;
		int oP = 1;
		
		while(eP>oP) {
			int even = A[eP];
			A[eP] = A[oP];
			A[oP] = even;
			eP = eP - 2;
			oP = oP + 2;
		}
		
	}
	
	
	public static int stock(List<Integer> prices) {
		if(prices.size()==0) return 0;
		
		List<Integer> A = new ArrayList<Integer>();
		A.add(0);
		int last = prices.get(0);
		
		for(int i=1;i<prices.size();i++) {
			System.out.println("adding " + (prices.get(i)-last));
			A.add(prices.get(i)-last);
			last = prices.get(i);
		}
		
		
		int s = 0 , ms = 0;
		
		for(int i=0;i<A.size();i++) {
			if(s+A.get(i)<ms) {
				s = A.get(i) < 0 ? 0 : A.get(i);
			}
			else {
				s += A.get(i);
				ms = s;
			}
		}
		
		
		return ms;
	}
	
	public static int bestPrice(List<Integer> prices) {
		int minPrice = Integer.MAX_VALUE;
		int maxProfit = 0;
		for(int i=0;i<prices.size();i++) {
			maxProfit = Math.max(maxProfit, prices.get(i)-minPrice);
			minPrice = Math.min(minPrice, prices.get(i));
		}
		return maxProfit;
	}
	
	public static void spiral(List<List<Integer>> matrix, int offset, List<Integer> res) {
		int rowMax = matrix.size()-offset;
		int colMax = matrix.get(0).size()-offset;
		int rowMin = offset, colMin=offset;
		
		for(int col=colMin;col<colMax;col++) {
			res.add(matrix.get(rowMin).get(col));
		}
		
		for(int row=rowMin+1;row<rowMax;row++) {
			res.add(matrix.get(row).get(colMax-1));
		}
		
		for(int col=colMax-2;col>rowMin;col--) {
			res.add(matrix.get(rowMax-1).get(col));
		}
		
		for(int row=rowMax-1;row>rowMin;row--) {
			res.add(matrix.get(row).get(colMin));
		}
		
		int d = matrix.size() - 2*(offset+1);
		if(d>0) spiral(matrix,++offset,res);
	}
	
		
	public static void main(String[] args) {
//		int[] a = new int[6];
//		a[0] = 0;
//		a[1] = 1;
//		a[2] = 2;
//		a[3] = 3;
//		a[4] = 4;
//		a[5] = 5;
//		evenFirst(a);
////		System.out.println(a.length);
//		for(int i=0;i<a.length;i++) {
//			System.out.println(a[i]);
//		}
//		List<Color> A = new ArrayList<Color>(Arrays.asList(Color.red,Color.white,Color.red,Color.white,Color.blue));
//		dutch2(1,A);
//		System.out.println(A);
//		int b = 0;
//		System.out.println(b++ + ++b);
////		System.out.println(a[1]);
//		
////		List<Integer> diff = new ArrayList<Integer>(Arrays.asList(0,5,-40,20,-35,10,20,-60,25,-5));
//		List<Integer> diff = new ArrayList<Integer>(Arrays.asList(310,315,275,295,260,270,290,230,255,250));
////		System.out.println(stock(diff));
//		System.out.println(bestPrice(diff));
		
		List<Integer> a = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		List<Integer> b = new ArrayList<Integer>(Arrays.asList(6,7,8,9,10));
		List<Integer> c = new ArrayList<Integer>(Arrays.asList(11,12,13,14,15));
		List<Integer> d = new ArrayList<Integer>(Arrays.asList(16,17,18,19,20));
		List<Integer> e = new ArrayList<Integer>(Arrays.asList(21,22,23,24,25));
		List<List<Integer>> matrix = new ArrayList<List<Integer>>();
		matrix.add(a);
		matrix.add(b);
		matrix.add(c);
		matrix.add(d);
		matrix.add(e);
		List<Integer> res = new ArrayList<Integer>();
		spiral(matrix,0,res);
		System.out.println(res);
	}
}