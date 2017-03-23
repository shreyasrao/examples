package epi17;

import java.util.Arrays;

public class steps{
	
	public static int k;
	
	public static int calcSteps(int steps, int ways) {
		int[] cache = new int[steps+1];
//		Arrays.fill(cache, -1);
		k = ways;
		return F(steps,cache);
	}
	
	public static int F(int steps, int[] cache) {
		if(cache[steps]!=0) return cache[steps];
		if(steps<=1) return 1;
		int res = 0;
		for(int i=1;i<=k && steps - i > -1;i++) {
			res += F(steps-i,cache);
		}
		cache[steps] = res;
		return res;
	}
	
	
	public static void main(String[] args) {
		System.out.println(calcSteps(4,2));
	}
	
}