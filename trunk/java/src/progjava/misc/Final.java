package progjava.misc;
abstract public class Final {
	final int x;

	public Final() {
		x = 2;
		System.out.println(x);
	}
}

class D extends Final {
	D() {
		super();
		// PMD
	}
	
	void metodoFinal() {
		// PMD
	}
}
