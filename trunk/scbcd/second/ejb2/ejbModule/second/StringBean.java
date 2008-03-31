package second;

import javax.ejb.Stateful;

/**
 * Session Bean implementation class for: StringBean
 *
 */

@Stateful
public class StringBean implements StringBeanLocal {
	private String anterior = "";
	
	public String maiuscula(String entrada) {
		if (entrada == null || entrada.length() == 0)
			return anterior.toUpperCase() + " (usando valor anterior)";
		anterior = entrada;
		return anterior.toUpperCase();
	}
}
