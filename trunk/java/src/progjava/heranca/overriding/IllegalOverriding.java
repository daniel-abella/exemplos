package progjava.heranca.overriding;

class Animal {
	public void eat() {
	}
}

public class IllegalOverriding extends Animal {
	// Compiler error (not an override because of return)
	// public void eat() {}
	
	// Below follows an overloading, not overriding
	public void eat(String str) {}
	
	// Compiler error
	// Checked exception not defined in Animal
	// public void eat() throws Exception {}
	
	// Compiler error
	// Reducing visibility
	// void eat() {}
}
