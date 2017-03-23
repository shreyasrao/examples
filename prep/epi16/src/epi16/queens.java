package epi16;
import java.util.*;

public class queens{
	
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
	private List<Integer> invRow = null;
	private List<Integer> invCol = null;
	public List<List<cell>> successP = null;
	public List<List<cell>> invDiag = null;
	
	public void start(int n) {
		if(n<1) return;
		
		NUM_QUEENS = n;
		List<cell> p = new ArrayList<>();
		place(0,new cell(0,0), p);
		if(successP!=null) System.out.println(successP);
	}
	
	private void place(int queen, cell c, List<cell> p) {
		// TODO Auto-generated method stub
		if(c.row!=queen) return;
		if(queen==NUM_QUEENS) return;
		
		boolean valid = isValid(c);
		
		if(valid) {
			p.add(c);
			updateInvalids(c);
			cell newC = increment(c);
			if(newC==null)return;
			else place(queen+1,newC,p);
		}
		else {
			cell newC = increment(c);
			if(newC==null)return;
			else place(queen,newC,p);
		}
		
	}
	
	private void updateInvalids(cell c) {
		invRow.add(c.row);
		invRow.add(c.col);
		
		//add diag cell logic
		
	}
	

	private boolean isValid(cell c) {
		// TODO Auto-generated method stub
		if(invRow==null) {invRow = new ArrayList<>();}
		else {if(invRow.contains(c.row)) return false;}
		
		if(invCol==null) {invCol = new ArrayList<>();}
		else {if(invCol.contains(c.col)) return false;}
		
		if(invDiag==null) {invDiag = new ArrayList<List<cell>>();}
		else {
			for(List<cell> l:invDiag) {
				if(l==null) {}
				else {
					if(l.contains(c)) return false;
				}
			}
		}
		
		return true;
	}

	private cell increment(cell c) {
		int row = c.row;
		int col = c.col + 1;
		if(col==NUM_QUEENS) {
			col = 0;
			row++;
		}
		
		if(row==NUM_QUEENS) {
			//ADD LOGIC TO CHECK IF SOLUTION exists
			return null;
		}
		return new cell(row,col);
	}
	
	public static void main(String[] args) {
		queens a = new queens();
		a.start(4);
	}
}