package oop;

public class animal{
	
	private String name;
	
	public void speak() {
		System.out.println("This is Animal speaking");
	}
	
	public static void hello(animal a) {
		a.speak();
	}
	
	public animal() {
		name = "no name";
	}
	public animal(String NAME) {
		name = NAME;
	}
	
	public void name(String NAME) {
		name = NAME;
	}
	
	
}