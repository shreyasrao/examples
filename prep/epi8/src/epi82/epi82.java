package epi82;

import java.util.Stack;

public class epi82{
	
	public class ListNode<T>{
		public T data;
		public ListNode<T> next;
	}
	
	public static void reverseSublist(ListNode<Integer> L, int start, int finish){
		
		int k = 0;
		ListNode<Integer> dummyHead = ListNode<Integer>();
		
	}
	
	public static void reverseSublist0(ListNode<Integer> L, int start, int finish){
		
		Stack<ListNode<Integer>> c = new Stack<ListNode<Integer>>();
		
		int pos = 1;
		ListNode<Integer> current = L;
		
		ListNode<Integer> preStart = null;
		ListNode<Integer> postFinish = null;
		
		while(current.next!=null){
			
			if((pos==start-1) && (start>1)) preStart = current;
			
			if(pos>=start){
				c.add(current);
			}
			
			if(pos == finish){
				postFinish = current.next;
				break;
			}
			
			current = current.next;
			pos++;
			
			
		}
		
		if(preStart==null) preStart = c.pop();
		
		while(!c.isEmpty()){
			preStart.next = c.pop();
			preStart = preStart.next;
			
		}
		
		preStart.next = postFinish;
		
		
		
		
//		while(pos <= finish){
//			
//			if(pos>= start){
//				c.add(current);
//				
//			}
//			if(pos==finish) postFinish = current.next;
//			current = current.next;
//			pos++;
//			
//		}
//		
//		current = L;
//		pos = 1;
//		
//		while(pos<=finish){
//			if(pos>=start){
//				current.next = c.pop();
//			
//				if(pos<finish) current = current.next;
//				else current.next = postFinish;
//				
//			}
//			else{
//				current = current.next;
//				pos++;
//			}
//			
//			
//		}
		
		
		
	}
	
	
}