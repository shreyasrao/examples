package oop;

public class C extends B{
	
//	public C() {
////		super();
//		System.out.println("Class C constructor");
//	}
	public C(String some) {
		super(some);
		System.out.println("Class C constructor");
	}
	
	public static void main(String[] args) {
//		System.out.println(x);
		C c = new C("h");
		
	}
	
}