package exp3;

import java.util.Enumeration;

public class CalculoAbordagemX implements ICalculo {

	public double media(Enumeration e) {
		Integer inteiro = null;
		long soma = 0;
		int contador = 0;
		while (e.hasMoreElements()) {
			inteiro = (Integer) e.nextElement();
			soma += inteiro.intValue();
			contador++;
		}
		return ((double) soma) / contador;
	}

}
