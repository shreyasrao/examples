package oop;

public class dog extends animal{
	
	public void speak() {
		
		if(this.getClass().equals(animal.class)) {
			super.speak();
		}
		else System.out.println("WOOF");
	}
	
	
	public dog(String NAME) {
		this.name(NAME);
	}
	
	
	public static void main(String[] args) {
		
		dog mothee = new dog("Mothee");
		mothee.speak();
		animal kai = (animal)mothee;
		kai.speak();
		System.out.println(kai.getClass());
//		System.out.println(kai);
//		System.out.println(mothee);
		
//		animal cobra = new animal("cobra");
//		cobra.speak();
//		System.out.println(cobra);
		
		
		
		
	}
	
}