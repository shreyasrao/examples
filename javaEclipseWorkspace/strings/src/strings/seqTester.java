package strings;

import static org.junit.Assert.*;

import org.junit.Test;
import strings.seq;

public class seqTester{
	
	@Test
	public void in0(){
		String a = "a";
		System.out.println("String is: " + a.substring(1, 1));
//		String pat = "aa";
//		String text = "redred";
//		assertTrue(seq.match(pat, text));
	}
	
	@Test
	public void in1(){
		String a = "a";
		System.out.println("String is: " + a.substring(0, 0));
		String pat = "aa";
		String text = "redred";
		assertTrue(seq.match(pat, text));
	}
	
	@Test
	public void in2(){
		String a = "a";
		System.out.println("String is: " + a.substring(0, 0));
		String pat = "aba";
		String text = "redred";
		assertTrue(seq.match(pat, text));
	}
	
	@Test
	public void in3(){
		String a = "a";
		System.out.println("String is: " + a.substring(0, 0));
		String pat = "babba";
		String text = "redred";
		assertTrue(seq.match(pat, text));
	}
	
	@Test
	public void in4(){
		String a = "a";
		System.out.println("String is: " + a.substring(0, 0));
		String pat = "cbabba";
		String text = "redred";
		assertTrue(seq.match(pat, text));
	}
	
	@Test
	public void in5(){
		String a = "a";
		System.out.println("String is: " + a.substring(0, 0));
		String pat = "abba";
		String text = "redbluebluered";
		assertTrue(seq.match(pat, text));
	}
	
	@Test
	public void in6(){
		String a = "a";
		System.out.println("String is: " + a.substring(0, 0));
		String pat = "abba";
		String text = "redbluered";
		assertFalse(seq.match(pat, text));
	}
	
}