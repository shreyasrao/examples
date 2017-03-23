package epi16;
import java.util.*;

import epi16.cell;

public class chess{
	
	private int N;
	public List<cell> tryP = null;
	
	public chess(int n){
		if(n<4) return;
		N = n;
		tryP = new ArrayList<>();
		start(0,new cell(0,0));
	}
	
	private void start(int queen, cell c) {
		place(0,c);
		
		if(tryP.size()==N) {
			System.out.println(tryP);
			//check for more solutions
			cell oldC = tryP.remove(0);
			tryP.clear();
			if(oldC.col+1<N) {start(0,new cell(oldC.row,oldC.col+1));}
		}
		
	}
	
	private void place(int queen, cell c) {
		if((queen>=N)) return;
		
		boolean valid = isValid(c);
		if(valid) {
			tryP.add(c);
			cell newC = new cell(c.row+1,0);
			place(queen+1,newC);
		}
		else {increment(queen,c);}
	}

	private void increment(int queen, cell c) {
		if(++c.col==N) back(queen);
		else place(queen,new cell(c.row,c.col));
	}
	
	private void back(int queen) {
		if(queen==0) return;
		increment(queen-1,tryP.remove(queen-1));
	}
	
	private boolean isValid(cell c) {
		for(cell placedQueen:tryP) {if((placedQueen.row==c.row) || (placedQueen.col==c.col) || (c.isDiag(placedQueen))) return false;}
		return true;
	}
	
	public static void main(String[] args) {
		chess a = new chess(4);
		
		
	}
	
	
}