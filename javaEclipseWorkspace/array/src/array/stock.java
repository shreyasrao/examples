package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class stock{
	
	public static int sellOnce(List<Integer> prices) {
		int profit = 0;
		int min = prices.get(0);
		for(int i=1;i<prices.size();i++) {
			min = Integer.min(min, prices.get(i));
			profit = Integer.max(profit, prices.get(i)-min);
		}
		return profit;
	}
	
	public static int sellTwice(List<Integer> prices) {
		List<Integer> F,R;
		F = new ArrayList<Integer>();
		
		R = new ArrayList<Integer>(Collections.nCopies(prices.size(), 0));
		
		int minPrice = Integer.MAX_VALUE;
		int maxProfitSeen = 0;
		
		for(int i=0;i<prices.size();i++) {
			minPrice = Math.min(minPrice, prices.get(i));
			maxProfitSeen = Math.max(maxProfitSeen,prices.get(i)-minPrice);
			F.add(maxProfitSeen);
		}
		System.out.println(R);
		
		int maxPrice = Integer.MIN_VALUE;
		maxProfitSeen = 0;
		int twoDayMax = 0;
		
		for(int j=prices.size()-1;j>0;j--) {
			maxPrice = Integer.max(maxPrice, prices.get(j));
			maxProfitSeen = Math.max(maxProfitSeen, maxPrice - prices.get(j));
			twoDayMax = Math.max(twoDayMax, maxProfitSeen + F.get(j-1));
//			R.add(maxProfitSeen);
			
		}
//		Collections.reverse(R);
//		System.out.println(R);
		
		
		return twoDayMax;
	}
	
	
	public static void main(String[] args) {
//		List<Integer> prices = Arrays.asList(310,315,275,295,260,270,290,230,255,250);
//		System.out.println(sellOnce(prices));
		
		List<Integer> prices = Arrays.asList(12,11,13,9,12,8,14,13,15);
		System.out.println(sellTwice(prices));
	}
	
}