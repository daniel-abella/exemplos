package progjava.iteracao;
public class Pi {

	public static void main(String[] args) {
		int precisao = 5000;
		double pi = getPi(precisao);
		System.out.println("Pi: " + pi);
		System.out.println(Math.PI);
	}

	public static double getPi(int n) {
		int i = 1;
		int s = -1;
		int d = -1;
		double p = 0.0d;
		while (i <= n) {
			d = d + 2;
			s = -1 * s;
			p = p + 4.0d * s / d;
			i = i + 1;
		}
		return p;
	}

}
