package progjava.construtor;

abstract class Abstract {
	Abstract(int i) {
		System.out.format("%s: %d\n", "Abstract constructor", Integer.valueOf(i));
	}
}

class Concrete extends Abstract {
	protected Concrete() {
		super('0');
		System.out.println("Concrete constructor");
	}
}

public class ConstructorForAbstract {
	public static void main(String[] args) {
		new Concrete();
	}

}
