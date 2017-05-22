package array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Flag{
	static enum Color {red,white,blue};
	
	public static List<Integer> group(List<Integer> A, int pivotIdx) {
		int cI=0, lI = 0;
		int mI = A.size()-1;
		int pivot = A.get(pivotIdx);
		while(cI<=mI) {
			if(A.get(cI)==pivot) {
				cI++;
			}
			else if(A.get(cI)<pivot) {
				Collections.swap(A, lI++, cI++);
			}
			else {
				Collections.swap(A, mI--, cI);
			}
		}
		return A;
	}
	
	public static List<Color> groupColor(List<Color> A, int pivotIdx) {
		int cI=0, lI = 0;
		int mI = A.size()-1;
		int pivot = A.get(pivotIdx).ordinal();
		while(cI<=mI) {
			if(A.get(cI).ordinal()==pivot) {
				cI++;
			}
			else if(A.get(cI).ordinal()<pivot) {
				Collections.swap(A, lI++, cI++);
			}
			else {
				Collections.swap(A, mI--, cI);
			}
		}
		return A;
	}
	
	public static void main(String[] args) {
		System.out.println(Flag.group(Arrays.asList(1,0,1,0,-1,0,0,0,-1),1));
		List<Flag.Color> input = Arrays.asList(Flag.Color.red,Flag.Color.blue,Flag.Color.white,Flag.Color.red,Flag.Color.white,Flag.Color.blue,Flag.Color.blue,Flag.Color.white,Flag.Color.red);
		List<Flag.Color> res = Flag.groupColor(input,2);
		System.out.println(res);
	}
	
}