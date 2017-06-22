package dp;

import static org.junit.Assert.*;

import java.util.ArrayList;
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
	
	
}