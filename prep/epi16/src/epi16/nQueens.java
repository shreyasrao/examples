package epi16;
import java.util.*;

public class nQueens{
	
	public class cell{
		Integer row,col;
		public cell(Integer r, Integer c) {
			row = r;
			col = c;
		}
		
		public String toString() {
			String res = new String();
			res+='(';
			res+=row.toString();
			res+=col.toString();
			res+=')';
			return res;
		}
	}
	
	private int NUM_QUEENS;
	public List<List<cell>> sucessP = null;
	public List<cell> tryP = null;
	
	public void start(int n) {
		if(n<3) return;
		
		NUM_QUEENS = n;
		tryP = new ArrayList<>();
		place(0,new cell(0,0));
		if(sucessP!=null) System.out.println(sucessP);
	}
	
	private void place(int queen, cell c) {
		// TODO Auto-generated method stub
		if((queen>=NUM_QUEENS)) checkP();
		
		boolean valid = isValid(c);
		if(valid) {
			tryP.add(c);
			cell newC = new cell(c.row+1,0);
			place(queen+1,newC);
		}
		else {
			increment(queen,c);
		}
		
	}
	
	
	private void checkP() {
		// TODO Auto-generated method stub
		if(tryP.size()==NUM_QUEENS) {
			if(sucessP==null) sucessP = new ArrayList<List<cell>>();
			sucessP.add(tryP);
		}
		//check for more solutions
		cell oldC = tryP.remove(0);
		tryP.clear();
		increment(0,oldC);
	}

	public boolean isDiag(cell c, cell placed) {
		int rowsApart = c.row - placed.row;
		int colsApart = c.col - placed.col;
		if(colsApart<0) {
			return ((c.col + rowsApart) == placed.col);
		}
		else {
			return ((c.col - rowsApart) == placed.col);
		}
	}
	
	private boolean isValid(cell c) {
		// TODO Auto-generated method stub
		
		for(cell placedQueen:tryP) {
			if(placedQueen.row==c.row) return false;
			if(placedQueen.col==c.col) return false;
			if(isDiag(c,placedQueen)) return false;
		}
		
		return true;
	}

	private void increment(int queen, cell c) {
		int row = c.row;
		int col = c.col + 1;
		if(col==NUM_QUEENS) {
			if(queen==0) return;
			back(queen);
		}
		place(queen,new cell(row,col));
	}
	
	private void back(int queen) {
		// TODO Auto-generated method stub
		cell oldC = tryP.remove(queen-1);
		increment(queen-1,oldC);
	}

	public static void main(String[] args) {
		nQueens a = new nQueens();
//		a.start(4);
//		System.out.println(a.isDiag(new cell(0,0), new cell(2,2)));
	}
}