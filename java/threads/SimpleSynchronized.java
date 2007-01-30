
public class SimpleSynchronized {
	int x = 0;
	
	void faz() {
		// Todo bloco sincronizado exige a identificação
		// do objeto cujo lock será adquirido
		synchronized (this) { x++; }
	}
}
