package p15;

public class Telefone {
	private String area;
	private String numero;
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String toString() {
		return area + " " + numero;
	}
}
