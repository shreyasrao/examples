package epi16;

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
			res+=',';
			res+=col.toString();
			res+=')';
			return res;
		}
		
		public boolean isDiag(cell placed) {
			int xD = Math.abs(row - placed.row);
			int yD = Math.abs(col - placed.col);
			if(xD==yD) return true;
			
			return false;
		}
		
	}