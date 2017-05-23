package array;

import java.util.ArrayList;
import java.util.List;

public class stock{
	
	public static int sellOnce(List<Integer> prices) {
//		int profit = Integer.MIN_VALUE;
		int profit = 0;
		int min = prices.get(0);
		for(int i=1;i<prices.size();i++) {
			profit = Integer.max(profit, prices.get(i)-min);
			min = Integer.min(min, prices.get(i));
		}
		return profit;
	}
	
	public static int sellTwice(List<Integer> prices) {
		List<Integer> F,R;
		F = new ArrayList<Integer>();
		R = new ArrayList<Integer>();
		for(int i=1;i<prices.size();i++) {
			F.add(sellOnce(prices.subList(0, i+1)));
			R.add(sellOnce(prices.subList(i, prices.size())));
		}
		
		int profit = R.get(0);
		for(int i=0;i<F.size()-1;i++) {
			profit = Integer.max(profit, F.get(i) + R.get(i+1));
		}
		
		return profit;
	}
	
	
	public static void main(String[] args) {
//		List<Integer> prices = Arrays.asList(310,315,275,295,260,270,290,230,255,250);
//		System.out.println(sellOnce(prices));
		
//		List<Integer> prices = Arrays.asList(12,11,13,9,12,8,14,13,15);
//		System.out.println(sellTwice(prices));
	}
	
}