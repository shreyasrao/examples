package epi9;

import java.util.Deque;
import java.util.LinkedList;

public class WellFormed{
	public Deque<String> open = new LinkedList<String>();
	
	private boolean match(String token){
		if(!open.isEmpty()){
			String o = open.removeFirst();
			
			switch(token.charAt(0)){
			case ')':
				return o.contains("(");
			case '}':
				return o.contains("{");
				
			case ']':
				return o.contains("[");
			
			}
			
			
		}
		
		return false;
	}
	
	public boolean isWellFormed(String exp){
		
		
//		Deque<String> close = new LinkedList<String>();
		String[] tokens = exp.split(",");
		
		for(String token:tokens){
			if(("[{(").contains(token)){
				System.out.println("open");
				open.addFirst(token);
			}
			else if(("]})").contains(token)){
				System.out.println("closed");
				if(!match(token)) return false;
			}
			else{
				System.out.println("WTF");
			}
		
		}
		if(!open.isEmpty()) return false;
		return true;
	}
	
	public static void main(String[] args){
		WellFormed a = new WellFormed();
		System.out.println(a.isWellFormed("[,(,),[,],{,(,),(,),},]"));
		
	}
	
}