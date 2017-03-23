package epi17;

import java.util.Arrays;
import java.util.List;

public class maxSubArray{
	
	public static int go(List<Integer> A) {
		int maxsum=0,sum=0,minsum=0;
		for(int i=0;i<A.size();++i) {
			sum+=A.get(i);
			if(sum<minsum) {
				minsum = sum;
			}
			if(sum-minsum>maxsum) {
				maxsum = sum - minsum;
			}
		}
		
		System.out.println("Max sum is " + maxsum);
		System.out.println("Min sum is " + minsum);
		System.out.println("sum is " + sum);
		
		return maxsum;
		
	}
	
	
	public static void main(String[] args) {
		go(Arrays.asList(4,-5,2,3));
	}
	
}