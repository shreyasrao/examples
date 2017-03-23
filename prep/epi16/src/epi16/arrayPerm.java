package epi16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class arrayPerm{
	
	public static List<Deque<Integer>> getPerms(LinkedList<Integer> A){
		List<Deque<Integer>> res = new ArrayList<Deque<Integer>>();
		if(A.size()==1) {
			res.add(new LinkedList<Integer>(A));
		}
		else {
			for(int x = 0;x<A.size();x++) {
				int elem = A.remove(x);
				List<Deque<Integer>> out = getPerms(A);
				for(Deque<Integer> arr:out) {
					arr.addFirst(elem);
				}
				A.add(x, elem);
				res.addAll(out);
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		
		List<Deque<Integer>> res = getPerms(new LinkedList<Integer>(Arrays.asList(2,3,5,7)));
		System.out.println(res.size());
		for(Deque<Integer> arr:res) {
			System.out.println(arr);
		}
		
	}
}