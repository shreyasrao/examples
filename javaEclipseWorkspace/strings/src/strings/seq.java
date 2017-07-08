package strings;

import java.util.HashMap;
import java.util.Map;

public class seq{
	
	public static boolean match(String pattern, String text) {
		/*
		 * pattern is a sequence of letters, i.e abba
		 * text is a string, i.e. redbluebluered
		 * for that specific string, pattern should match
		 * true with a=red,b=blue
		 * 
		 * should also allow empty pattern match.
		 * patter = abba
		 * text = redred
		 * true with a=red,b=""
		 * */
		
		Map<String,String> D = new HashMap<String,String>();
		boolean res = helper(pattern,text,D);
		System.out.println(D);
		return res;
	}
	
	private static boolean helper(String pattern, String text, Map<String,String> D) {
		
		if(pattern.length()==0 && text.length()==0) return true;
		if(pattern.length()==0 && text.length()!=0) return false;
		
		for(int i=text.length();i>=0;i--) {
			String letter = String.valueOf(pattern.charAt(0)); //we focus on matching letter at 0 to a pattern in this recursion
			String thisText = text.substring(0, i); //start by looking at entire pattern, slow stripping off the end char each iteration
			String newText = text.substring(thisText.length()); //ensures remaining text is passed to next recursion
			String newPat = pattern.substring(1); //if string len = 1, this returns empty string
			if(!D.containsKey(letter)) {
				D.put(letter, thisText);
				if(helper(newPat,newText,D)) return true;
				D.remove(letter); //if we don't pattern match for remaining pattern and text, we have to remove this match from map
			}
			else if(D.get(letter).equals(thisText)) {
				if(helper(newPat,newText,D)) return true;
			}
			//if map has this letter key but with different value, do nothing
			//the for loop will explore all possibilities, if one is not found
			//we return false once we exit for loop
		}
		
		return false;
	}
	
}