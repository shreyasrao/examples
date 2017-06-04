package dp;

import static org.junit.Assert.*;
import dp.triangle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class triangleTester{
	@Test
	public void in1() {
		List<List<Integer>> T = new ArrayList<List<Integer>>();
		T.add(new ArrayList<Integer>(Arrays.asList(2)));
		assertEquals(2,triangle.minWeight(T));
	}
	
	@Test
	public void in2() {
		List<List<Integer>> T = new ArrayList<List<Integer>>();
		T.add(new ArrayList<Integer>(Arrays.asList(2)));
		T.add(new ArrayList<Integer>(Arrays.asList(4,4)));
		assertEquals(6,triangle.minWeight(T));
	}
	
	@Test
	public void in3() {
		List<List<Integer>> T = new ArrayList<List<Integer>>();
		T.add(new ArrayList<Integer>(Arrays.asList(2)));
		T.add(new ArrayList<Integer>(Arrays.asList(4,4)));
		T.add(new ArrayList<Integer>(Arrays.asList(8,5,6)));
		assertEquals(11,triangle.minWeight(T));
	}
	
	@Test
	public void in4() {
		List<List<Integer>> T = new ArrayList<List<Integer>>();
		T.add(new ArrayList<Integer>(Arrays.asList(2)));
		T.add(new ArrayList<Integer>(Arrays.asList(4,4)));
		T.add(new ArrayList<Integer>(Arrays.asList(8,5,6)));
		T.add(new ArrayList<Integer>(Arrays.asList(4,2,6,2)));
		assertEquals(13,triangle.minWeight(T));
	}
	
	@Test
	public void in5() {
		List<List<Integer>> T = new ArrayList<List<Integer>>();
		T.add(new ArrayList<Integer>(Arrays.asList(2)));
		T.add(new ArrayList<Integer>(Arrays.asList(4,4)));
		T.add(new ArrayList<Integer>(Arrays.asList(8,5,6)));
		T.add(new ArrayList<Integer>(Arrays.asList(4,2,6,2)));
		T.add(new ArrayList<Integer>(Arrays.asList(1,5,2,3,4)));
		assertEquals(15,triangle.minWeight(T));
	}
}