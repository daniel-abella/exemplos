package progjava.construtor;

public class Anta {
	Anta() {
		System.out.println(getIdade());
	}

	public final int getIdade() {
		return 15;
	}

	public static void main(String[] args) {
		new Anta();
	}
}