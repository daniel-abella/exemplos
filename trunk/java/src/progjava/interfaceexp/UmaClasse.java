package progjava.interfaceexp;

class Qualquer {
	public Qualquer() {
		System.out.println("Instancia de Qualquer criada");
	}

	public int getInt() {
		return 10;
	}
}

abstract interface UmaInterface {
	Qualquer q = new Qualquer();
}

public class UmaClasse implements UmaInterface {
	public static void main(String[] args) {
		System.out.println(UmaClasse.q.getInt());
	}
}
