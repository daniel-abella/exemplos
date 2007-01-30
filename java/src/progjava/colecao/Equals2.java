package progjava.colecao;

public class Equals2 {
    int valor;

    Equals2(int v) {
        valor = v;
    }

    public static void main(String[] args) {
        Equals2 a = new Equals2(5);
        Equals2 b = new Equals2(5);

        System.out.println(a == b ? "a == b" : "a != b");
    }

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
}