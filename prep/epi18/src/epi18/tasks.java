package epi18;

import java.util.*;

public class tasks{
	public class PairedTasks{
		public Integer task1;
		public Integer task2;
		
		PairedTasks(int Task1, int Task2){
			this.task1 = Task1;
			this.task2 = Task2;
		}
		
		public String toString() {
			String res = "(";
			res += this.task1.toString() + ", ";
			res += this.task2.toString() + ")";
			return res;
		}
		
	}
	
	
	public List<PairedTasks> give(List<Integer> A) {
		Collections.sort(A);
		List<PairedTasks> res = new ArrayList<PairedTasks>();
		
		for(int low = 0, high = A.size() -1 ; low<high ; low++,high--) {
			res.add(new PairedTasks(A.get(high),A.get(low)));
		}
		return res;
	}
	
	public int minWait(List<Integer>A) {
		Collections.sort(A);
		int time = 0;
		List<Integer> times = new ArrayList<Integer>();
		times.add(0);
		for(int i = 1; i<A.size();i++) {
			int t = times.get(i-1)+A.get(i-1);
			times.add(t);
			time += t;
		}
		return time;		
	}
	
	public boolean hasTwoSum(List<Integer> A, int t) {
		
		int i = 0, j = A.size() - 1;
		while(i<=j) {
			if(A.get(i) + A.get(j) == t) return true;
			else if(t-(2*A.get(i))==0) return true;
			else if(t-(2*A.get(j))==0) return true;
			else if (A.get(i)+A.get(j)< t) ++i;
			else --j;
		}
		return false;
		
	}
	
	public boolean hasThreeSum(List<Integer> AA, int t) {
		Collections.sort(AA);
		LinkedList<Integer> A = new LinkedList<Integer>(AA);
		for(int k=0;k<A.size();k++) {
			int a = A.remove(k);
			if(t-(3*a)==0)return true;
			if(hasTwoSum(A,t-a)) return true;
			A.add(k, a);
		}
		
		return false;
	}
	
	private class cityGallons{
		public int city;
		public int gallonsRemaining;
		
		public cityGallons(int c, int g) {
			this.city = c;
			this.gallonsRemaining = g;
		}
	}
	
	public int findAmpleCity(List<Integer> gallons, List<Integer> distances) {
		
		int MPG = 20;
		List<cityGallons> g = new ArrayList<cityGallons>();
		g.add(new cityGallons(0,1000)); //1000 gallons in tank to start
		cityGallons min = g.get(0);
		for(int i=1;i<gallons.size();i++) {
			cityGallons n = new cityGallons(i,g.get(i-1).gallonsRemaining - distances.get(i-1)/MPG + gallons.get(i));  
			if(n.gallonsRemaining < min.gallonsRemaining) min = n;
			g.add(n);	
//			gallonsRemaining.add(MPG*gallons.get(i) - distances.get(i));
		}
		cityGallons n = new cityGallons(0,g.get(gallons.size()-1).gallonsRemaining - distances.get(gallons.size()-1)/MPG + gallons.get(0));
		if(n.gallonsRemaining < min.gallonsRemaining) min = n;
		g.set(0, n);
		return min.city;
	}
	
	
	public static void main(String[] args) {
		
		int cents = 98;
		int coins = 0;
		coins += cents/50;
		cents %= 50;
//		System.out.println(coins + " " + cents);
		tasks j = new tasks();
		System.out.println(j.give(Arrays.asList(5,2,1,6,4,4)));
		System.out.println(j.minWait(Arrays.asList(2,5,1,3)));
		System.out.println(j.hasThreeSum(Arrays.asList(2,5,11,7,3),22));
		List<Integer> gals = Arrays.asList(50,20,5,30,25,10,10);
		List<Integer> dist = Arrays.asList(900,600,200,400,600,200,100);
		System.out.println(j.findAmpleCity(gals, dist));
	}
}