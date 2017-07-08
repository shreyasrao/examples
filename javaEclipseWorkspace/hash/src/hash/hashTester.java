package hash;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import hash.hash;
import org.junit.Test;

public class hashTester{
	
	@Test
	public void in1() {
		String s = "edified";
		assertTrue(hash.palindromePermutation(s));
	}
	
	@Test
	public void in2() {
		String s = "dified";
		assertFalse(hash.palindromePermutation(s));
	}
	
	@Test
	public void in3() {
		String s = "level";
		assertTrue(hash.palindromePermutation(s));
	}
	
	@Test
	public void in4() {
		String s = "levels";
		assertFalse(hash.palindromePermutation(s));
	}
	
	@Test
	public void in5() {
		List<String> A = new ArrayList<>(Arrays.asList("All","work","and", "no", "play","makes","for","no","work","no","fun","and","no","results"));
		assertEquals(2,hash.entryDist(A));
	}
}