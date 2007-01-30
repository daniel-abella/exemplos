package exp3;

import java.util.Enumeration;

public class DadosFactory {
	public static Enumeration newDados() {
		Enumeration resultado = null;
		try {
			resultado = (Enumeration) Class.forName("exp3.DadosXML").newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultado;
	}
}
