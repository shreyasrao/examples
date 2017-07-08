package hash;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class hash{
	
	public static boolean palindromePermutation(String s) {
		/*
		 * Check if the letters in input string could be moved around
		 * to make a palindrome. The string itself doesnt need to be
		 * a palindrome in its current state
		 * */
		
		Map<Character,Integer> M = new HashMap<Character,Integer>();
		s = s.toLowerCase();
		for(int i=0;i<s.length();i++) {
			if(M.containsKey(s.charAt(i))) {
				int count = M.get(s.charAt(i))+1;
				M.put(s.charAt(i), count);
			}
			else {
				M.put(s.charAt(i), 1);
			}
		}

		int oddCount = 0;
		for(Character c:M.keySet()) {
			//odd count allowed only if string length odd and there is only 1 odd count letter
			if(M.get(c)%2!=0 && ++oddCount>1) return false;
		}
		return true;
	}
	
	public static int entryDist(List<String> A) {
		int res = Integer.MAX_VALUE;
		Map<String,Integer> M = new HashMap<String,Integer>();
		M.put(A.get(0).toLowerCase(), 0);
		for(int i=1;i<A.size();i++) {
			String s = A.get(i).toLowerCase();
			if(M.containsKey(s)) {
				int dist = i - M.get(s);
				res = (dist<res) ? dist : res;
			}
			M.put(s, i);
		}
		
		return res;
	}
	
}