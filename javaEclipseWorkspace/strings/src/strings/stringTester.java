package strings;

import static org.junit.Assert.*;

import org.junit.Test;

public class stringTester{
	@Test
	public void in1() {
		assertTrue(stringMethods.isPalindrome(""));
	}
	
	@Test
	public void palindrome1b() {
		assertTrue(stringMethods.isPalindrome("a"));
	}
	
	@Test
	public void palindrome2() {
		assertFalse(stringMethods.isPalindrome("ba"));
	}
	
	@Test
	public void palindrome2b() {
		assertTrue(stringMethods.isPalindrome("$ a A"));
	}
	
	@Test
	public void palindrome2c() {
		assertFalse(stringMethods.isPalindrome("$ a A1"));
	}
	
	@Test
	public void palindromeLong() {
		assertTrue(stringMethods.isPalindrome("A man, a plan, a canal, Panama"));
	}
	
	@Test
	public void palindromeLong2() {
		assertFalse(stringMethods.isPalindrome("Ray a ray"));
	}
	
	@Test
	public void reverse1() {
		assertArrayEquals(stringMethods.reverse("ram is costly".toCharArray(),0,"ram is costly".length()-1), "yltsoc si mar".toCharArray());
	}
	
	@Test
	public void reverseSen1() {
		assertArrayEquals(stringMethods.reverseSentence("ram is costly".toCharArray()), "costly is ram".toCharArray());
	}
	
	@Test
	public void reverseSen2() {
		assertArrayEquals(stringMethods.reverseSentence(" ram is costly ".toCharArray()), " costly is ram ".toCharArray());
	}
}