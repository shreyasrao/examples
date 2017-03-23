package epi9;

import java.util.Deque;
import java.util.LinkedList;

public class rpn{
	
	
	
	public static int eval(String rpnExp){
		
		Deque<Integer> vals = new LinkedList<Integer>();
		String[] tokens = rpnExp.split(",");
		
		for(String token:tokens){
			if(token.length()==1 && ("+-*/").contains(token)){
				int y = vals.removeFirst();
				int x = vals.removeFirst();
				
				switch(token.charAt(0)){
				case '+':
					vals.addFirst(x+y);
					break;
				case '-':
					vals.addFirst(x-y);
					break;
				case '*':
					vals.addFirst(x*y);
					
					break;
				case '/':
					vals.addFirst(x/y);
					break;
				
				}
				
			}
			else{
				vals.addFirst(Integer.parseInt(token));
			}
			
		}
		return vals.removeFirst();
	}
	
	
}