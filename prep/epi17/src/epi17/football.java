package epi17;
import java.util.*;

public class football{
	
	public static int go(int score, List<Integer> plays) {
		int[][] A = new int[plays.size()][score+1];
		
		for(int i=0; i<plays.size();i++) {
			A[i][0] = 1;
			for(int j=1; j<score+1;j++) {
//				if(j%plays.get(i)==0) A[i][j]++;
				int withThisPlay = i>0? A[i-1][j]:0;
				int withoutThisPlay = j>=plays.get(i) ? A[i][j-plays.get(i)]:0;
				A[i][j] += withThisPlay + withoutThisPlay;
				
//				for(int x = j; x>0; x-=plays.get(i)) {
//					if(i>0) A[i][j]+=A[i-1][x];
//				}
				
			}
		}

		return A[plays.size()-1][score];
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(go(12,Arrays.asList(2,3,7)));
	}
}