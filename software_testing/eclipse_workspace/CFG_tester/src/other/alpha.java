package other;

public class alpha{
	
	public static boolean repOK(){
		int a = 1;
		if(a==1){
			return false;
		}
		else{
			return false;
		}
	}
	
	public static void main(String[] args){
		int a = 5;
		int b = 5;
		b++;
		System.out.println("Line 1");
		if (a<3){
			a = a - 3;
			System.out.println("Less than 3");
		}
		else{
			boolean test = alpha.repOK();
			System.out.println("More than 3" + test);
		}
	}
}
