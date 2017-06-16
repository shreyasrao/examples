package trees;

/* 
 * Very similar to Node class but with parents pointers 
*/

public class Nwp<T>{
	public T data;
	public Nwp<T> left, right,parent;
	
	public Nwp(T d){
		data = d;
		left = null;
		right = null;
		parent = null;
	}
	
	public Nwp(T d, Nwp<T> l, Nwp<T> r) {
		data = d;
		left = l;
		left.parent = this;
		right = r;
		right.parent = this;
		parent = null;
	}
	
	public void connect(Nwp<T> l, Nwp<T> r) {
		left = l;
		left.parent = this;
		right = r;
		right.parent = this;
	}
	
	public String toString() {
		return data.toString();
	}
}