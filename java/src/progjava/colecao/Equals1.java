package progjava.colecao;

public class Equals1 {
	int valor;
	
	public Equals1(int v) {
		valor = v;
	}

	public static void main(String[] args) {
		Equals1 e1 = new Equals1(5);
		Equals1 e2 = new Equals1(5);

		if (e1 == e2) {
			System.out.println("e1 == e2");
		} else {
			System.out.println("e1 != e2");
		}
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
}