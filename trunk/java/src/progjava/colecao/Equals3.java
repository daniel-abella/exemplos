package progjava.colecao;

public class Equals3 {
	public static void main(String[] args) {
		Equals3 a = new Equals3();
		Equals3 b = new Equals3();

		if (a != b) {
			a = b;
			if (a == b) {
				System.out.println("a != b");
			}
		}
	}
}