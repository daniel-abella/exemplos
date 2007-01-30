package progjava.heranca;

class Dog {}
class Harrier extends Dog {}

public class Caes {
	public static void main(String[] args) {
		Dog d1 = new Dog();
		Harrier h1 = new Harrier();
		Dog d2 = (Dog) h1;
		Harrier h2 = (Harrier) d2;
		Harrier h3 = (Harrier) d2;
	}
}
