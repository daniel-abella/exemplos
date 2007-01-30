package progjava.construtor;

class AtletaDeReferencia {
	AtletaDeReferencia() {
		System.out.print("Pele");
	}
}

public class Esporte {
	AtletaDeReferencia atleta = new AtletaDeReferencia();

	private Esporte() {
		System.out.print("futebol");
	}

	public static void main(String[] args) {
		new Esporte();
	}

	public AtletaDeReferencia getAtleta() {
		return atleta;
	}

	public void setAtleta(AtletaDeReferencia atleta) {
		this.atleta = atleta;
	}
}