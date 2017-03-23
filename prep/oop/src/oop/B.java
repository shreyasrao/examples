package oop;

public class B extends A {
	
	public B() {
//		super();
		System.out.println("Class B default constructor");
	}
	
	public B(String something) {
//		super(something);
		System.out.println("Class B constructor");
		
	}
	
	public static void main(String[] args) {
//		System.out.println(x);
		
		B b = new B("H");
	}
	
}