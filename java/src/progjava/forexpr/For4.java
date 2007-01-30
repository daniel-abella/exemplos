package progjava.forexpr;
public class For4 {
	public static void main(String[] args) {
		int x = 0;

		// A declara��o 'int i;' provocaria erro de compila��o.
		// Pois i seria usado sem um valor inicial previamente definido.
		int i = 1;
		while (x < 0)
			i++;
	}
}
