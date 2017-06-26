package dp;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import dp.knapsack;

public class knapsackTester{
	
	@Test
	public void in1() {
		List<knapsack.item> A = new ArrayList<knapsack.item>();
		A.add(new knapsack.item(5, 60));
		A.add(new knapsack.item(3, 50));
		A.add(new knapsack.item(4, 70));
		A.add(new knapsack.item(2, 30));
		assertEquals(80,knapsack.getMax(A,5));
	}
	
	@Test
	public void split() {
		int[] set = {5,6,3,5};
		int a = knapsack.divideSpoils(set);
		//for given input, split is 10 and 9
		//our algo should return 10 as sum of one of the subsets
		assertEquals(a,10);
	}
	
	@Test
	public void split1() {
		int[] set = {65,35,245,195,65,150,275,155,120,320,75,40,200,100,220,99};
		int a = knapsack.divideSpoils(set);
		//for given input, split is 1180 and 1179
		//our algo should return 1180 as sum of one of the subsets
		assertEquals(a,1180);
	}
}