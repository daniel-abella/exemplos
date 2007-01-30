package progjava.excecao;
public class Exception16 {
	static int x = 1;

	public static int f() {
		try {
			x = 1 / ((x = 2) - 2);
		} catch (Exception e) {
			return x;
		} finally {
			x++;
		}
		return x;
	}

	public static void main(String[] args) {
		System.out.println(x + " " + f() + " " + x);
	}
}