package progjava.exp;

public class Expr03 {
	public static void main(String[] args) {
		int a[] = { 0, 0 };

		int b = 0;

		a[b] = (b = 1); // O mesmo que a[b] = b = 1 (veja exp2.java)

		System.out.println("b = " + b + " a[b] = " + a[b]);
	}
}
