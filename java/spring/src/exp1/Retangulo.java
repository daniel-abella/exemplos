package exp1;

public class Retangulo {
	private Ponto ie; // canto inferior esquerdo
	private Ponto sd; // canto superior direito

	public Retangulo(Ponto ie, Ponto sd) {
		this.ie = ie;
		this.sd = sd;
	}

	public String toString() {
		return ie.toString() + " " + sd.toString();
	}
	
	public Ponto getIe() {
		return ie;
	}
	
	public Ponto getSd() {
		return sd;
	}
}
