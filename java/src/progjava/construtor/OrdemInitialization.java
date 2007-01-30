package progjava.construtor;

public class OrdemInitialization {
	static private int valorI = 0;
	
	static {
		if (((int) (Math.random() * 100)) % 2 == 1) {
			valorI = 2 / 0;
		}
	}

	public static void main(final String... args) {
	}
}
