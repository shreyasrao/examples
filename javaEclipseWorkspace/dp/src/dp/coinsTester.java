package dp;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.*;
import dp.coins;

public class coinsTester{
//	@Test
//	public void in1() {
//		List<Integer> c = new ArrayList<>(Arrays.asList(1,25));
//		assertEquals(coins.rev(c, 0, 1),25);
//	}
	
	@Test
	public void in1() {
		List<Integer> c = new ArrayList<>(Arrays.asList(5,25));
		coins.rev(c);
		assertEquals(coins.rev(c),25);
	}
	
	@Test
	public void in2() {
		List<Integer> c = new ArrayList<>(Arrays.asList(5,25,10));
		coins.rev(c);
		assertEquals(coins.rev(c),15);
	}
	
	@Test
	public void in3() {
		List<Integer> c = new ArrayList<>(Arrays.asList(5,25,10,1));
		coins.rev(c);
		assertEquals(coins.rev(c),26);
	}
	
	@Test
	public void in4() {
		List<Integer> c = new ArrayList<>(Arrays.asList(10,25,5,1,10,5));
		coins.rev(c);
		assertEquals(coins.rev(c),31);
	}
	
	
	
}