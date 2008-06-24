
/**
 * Carro com um único atributo (autonomia em kilômetros).
 * 
 * @author Fábio Nogueira de Lucena
 * @version 0.1
 *
 */
public class Carro {
	private int autonomia;

	public int getAutonomia() {
		return autonomia;
	}
	
	public void setAtutonomia(int novaAutonomia) {
		autonomia = novaAutonomia;
	}
	
	public Carro(int autonomia) {
		this.autonomia = autonomia;
	}
}
