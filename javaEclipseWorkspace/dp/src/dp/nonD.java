package dp;

import java.util.List;

public class nonD{
	
	/*
	 * Given list of ints, find length of longest non decreasing
	 * sub sequence. 
	 * */
	
	public static int longestSub(List<Integer> A, List<Integer> M) {
		
		if(A.size()==0) return 0;
	
		M.set(0, 1);
		int i = A.size()-1;
		int elem = A.get(i);		
		
		if(M.get(i-1)==0) longestSub(A.subList(0, A.size()-1),M);

		int max=0;
		for(int j=0;j<A.size();j++) {
			if(A.get(j)<=elem) max = M.get(j) > max ? M.get(j) : max;
		}
		M.set(i, max+1);

		return M.get(i);
	}
	
}