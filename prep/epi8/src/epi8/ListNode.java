package epi8;

import java.util.Arrays;
import java.util.List;

public class ListNode<T>{
	
	public T data;
	public ListNode<T> next;
	
	public ListNode(T val, ListNode<T> nextNode){
		data = val;
		next = nextNode;
	}
	
	
	public static ListNode<Integer> evenOddMerge(ListNode<Integer> L ){
		if(L==null) return L;
		
		ListNode<Integer> dummyOdd = new ListNode<>(0,null);
		ListNode<Integer> dummyEven = new ListNode<>(0,null);
		
		int turn = 0;
		
		List<ListNode<Integer>> tails = Arrays.asList(dummyEven,dummyOdd);
		
		for(ListNode<Integer> iter=L; iter!=null; iter = iter.next){
			tails.get(turn).next = iter;
			tails.set(turn, tails.get(turn).next);
			turn ^= 1;
		}
		
		tails.get(1).next = null;
		tails.get(0).next = dummyOdd.next;
		
		return dummyEven.next;
		
		
	}
	
	public static ListNode<Integer> evenOddMerge1(ListNode<Integer> L){
		ListNode<Integer> dummy = new ListNode<Integer>(0,L);
		
		ListNode<Integer> even = dummy.next;
		ListNode<Integer> odd = even.next;
		
		if(odd==null) return dummy.next;
		if(odd.next==null) return dummy.next;
		
		ListNode<Integer> firstOdd = odd;
		
		
		while(odd.next!=null){
			even.next = odd.next;
			even = even.next;
			odd.next = even.next;
			odd = odd.next;
			if(odd==null) break;
		}
		even.next = firstOdd;
		
		
		
		return dummy.next;
		
	}
	
	public static ListNode<Integer> reverseSublist(ListNode<Integer> L, int start, int finish){
		
		if(start==finish)return L;
		
		ListNode<Integer> dummy = new ListNode<>(0,L);
		ListNode<Integer> sublistHead = dummy;
		int k = 1;
		
		while(k++<start){
			sublistHead = sublistHead.next;
		}
		
		ListNode<Integer> sublistIter = sublistHead.next;
		
		while(start++ < finish){
			ListNode<Integer> temp = sublistIter.next;
			sublistIter.next = temp.next;
			temp.next = sublistHead.next;
			sublistHead.next = temp;
			
			
//			temp.next = sublistIter.next.next;
//			sublistIter.next.next = temp;
//			
//			sublistIter = temp.next;
			
		}
		
		return dummy.next;
		
	}
	
	
	
}