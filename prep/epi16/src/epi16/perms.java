package epi16;
import java.util.*;


public class perms{
	
	public static List<List<Integer>> start(List<Integer> A) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		getPerms(0,A,res);
		return res;
	}
	
	public static void getPerms(int i, List<Integer> A, List<List<Integer>> res) {
		if(i==A.size()-1) {
			res.add(new ArrayList<>(A));
			return;
		}
		
		for(int j=i;j<A.size();++j) {
			Collections.swap(A, i, j);
			getPerms(i+1,A,res);
			Collections.swap(A, i, j);
		}
		return;
		
	}
	
	public static void main(String[] args) {
		
		List<List<Integer>> res = start(Arrays.asList(2,3,5,7));
//		System.out.println(res.size());
//		for(List<Integer> arr:res) {
//			System.out.println(arr);
//		}
		
		for(int j=0;j<4;++j) {
			System.out.println(j);
		}
		
	}
}