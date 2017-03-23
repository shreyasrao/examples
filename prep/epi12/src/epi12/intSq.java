package epi12;

public class intSq{
	
	public static int calcSquare(int num) {
		int low = 0;
		int high = num;
		
		while(high >= low) {
			int mid = low + (high-low)/2;
			int val = mid * mid;
			if(val<=num) {
				low = mid+1;
			}
			else {
				high = mid - 1;
			}
		}
//		System.out.println("res is " + res + " low is " + low);
//		res = res == -1 ? low-1 : res;
		return low -1;
	}
	
	public static void sq(int num, int low, int high) {
		
		
		
	}
	
	public static void main(String[] args) {
		System.out.println(calcSquare(16));
	}
}