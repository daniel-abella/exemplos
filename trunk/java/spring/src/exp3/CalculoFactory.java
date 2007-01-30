package exp3;

public class CalculoFactory {
	public static ICalculo newICalculo() {
		ICalculo resultado = null;
		try {
			resultado = (ICalculo) Class.forName("exp3.CalculoAbordagemX").newInstance();
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
