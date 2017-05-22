package array;

import java.util.List;
import java.util.Arrays;

import org.junit.Test;
import static org.junit.Assert.*;

public class flagTester{
	
	@Test
	public void in2() {
		List<Integer> res = Flag.group(Arrays.asList(1,0),0);
		assertEquals(res,Arrays.asList(0,1));
	}
	
	@Test
	public void in2b() {
		List<Integer> res = Flag.group(Arrays.asList(1,0),1);
		assertEquals(res,Arrays.asList(0,1));
	}
	
	@Test
	public void in3() {
		List<Integer> res = Flag.group(Arrays.asList(1,0,-1),1);
		assertEquals(res,Arrays.asList(-1,0,1));
	}
	
	@Test
	public void in3b() {
		List<Integer> res = Flag.group(Arrays.asList(1,-1,-1),1);
		assertEquals(res,Arrays.asList(-1,-1,1));
	}
	
	@Test
	public void in3c() {
		List<Integer> res = Flag.group(Arrays.asList(1,0,-1),2);
		assertEquals(res,Arrays.asList(-1,0,1));
	}
	
	@Test
	public void in3d() {
		List<Integer> res = Flag.group(Arrays.asList(1,0,1,0,-1,0,0,0,-1),4);
		assertEquals(res.subList(0, 2),Arrays.asList(-1,-1));
	}
	
	@Test
	public void in3e() {
		List<Integer> res = Flag.group(Arrays.asList(1,0,1,0,-1,0,0,0,-1),1);
		assertEquals(res,Arrays.asList(-1,-1,0,0,0,0,0,1,1));
	}
	
	@Test
	public void color3() {
		List<Flag.Color> input = Arrays.asList(Flag.Color.red,Flag.Color.blue,Flag.Color.white,Flag.Color.red,Flag.Color.white,Flag.Color.blue,Flag.Color.blue,Flag.Color.white,Flag.Color.red);
		List<Flag.Color> res = Flag.groupColor(input,1);
		assertEquals(res,Arrays.asList(-1,-1,0,0,0,0,0,1,1));
	}
}