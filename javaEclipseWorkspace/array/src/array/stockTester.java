package array;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class stockTester{
	
	@Test
	public void in1() {
		List<Integer> prices = Arrays.asList(310,315,275,295,260,270,290,230,255,250);
		assertEquals(stock.sellOnce(prices),30);
	}
	
	
	
	@Test
	public void in2() {
		List<Integer> prices = Arrays.asList(12,11,13,9,12,8,14,13,15);
		assertEquals(stock.sellTwice(prices),10);
	}
	
}