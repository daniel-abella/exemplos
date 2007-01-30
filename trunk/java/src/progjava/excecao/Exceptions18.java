package progjava.excecao;

public class Exceptions18 {
	static int x = 1;

	public static int f() {
		try {
			x = 1;
			return x;
		} finally {
			++x;
		}
	}

	public static void main(String[] args) {
		System.out.println(x + " " + f() + " " + x);
	}
}
