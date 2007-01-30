package exp1;

public class PontoFactory extends Factory {
	public static Ponto criaPonto(String nomeRef) {
		return (Ponto) getInstancia(nomeRef);
	}
}
