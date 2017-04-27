package epi13;
import java.util.*;

public class hash{
	
	public static int nearestRepeatedEntries(List<String> A) {
		Map<String,Integer> elements = new HashMap<>(); 
		int nearest = Integer.MAX_VALUE;
		
		for(int i=0;i<A.size();i++) {
			String elem = A.get(i);
			if(elements.containsKey(elem)) {
				int dist = i - elements.get(elem);
				nearest = dist < nearest ? dist : nearest;
			}
			elements.put(elem, i);
		}
		return nearest;
		
	}
	
	
	public static void main(String[] args) {
		
		List<String> s = new ArrayList<>(Arrays.asList("All", "work", "and", "no", "play", "makes","for","no","work","no","fun","and","no","results"));
		System.out.println(nearestRepeatedEntries(s));
	}
}