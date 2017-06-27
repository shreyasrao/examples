package strings;

import java.util.Collections;

public class stringMethods{
	
	public static boolean isPalindrome(String input) {
		
		/*
		 * Is input string a palindrome
		 * i.e. reads the same forwards as backwards
		 * only consider letters or numbers
		 * */
		
		int low = 0, high = input.length()-1;
		while(low<high) {
			if(!Character.isLetterOrDigit(input.charAt(low))) {
				low++;
				continue;
			}
			if(!Character.isLetterOrDigit(input.charAt(high))) {
				high--;
				continue;
			}
			if(Character.toLowerCase(input.charAt(low++)) != Character.toLowerCase(input.charAt(high--))) return false;
		}
		
		return true;
	}
	
	public static char[] reverse(char[] s, int low, int high) {
		while(low<high) {
			char temp = s[low];
			s[low++] = s[high];
			s[high--] = temp;
		}
		return s;
	}
	
	public static char[] reverseSentence(char[] s) {
		
		/*
		 * Swap the order of words in a sentence
		 * */
		
		reverse(s,0,s.length-1);
		int wB = 0, wE = 0;
		
		//find beging of first word
		while(s[wB]==' ') {
			wB++;
			wE++;
		}
		
		while(wE<s.length) {
			//reverse each whitespace separated word using helper method 
			if(s[wE]==' ') {
				reverse(s,wB,wE-1);
				wB = wE+1;
				wE = wB;
				continue;
			}
			else wE++;
		}
		reverse(s,wB,wE-1);
		return s;
	}
	
}