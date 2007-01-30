package progjava.misc;

public class GeraInstanciaDe {
	public static Object criaInstancia(String nomeTipo) {
		Object obj = null;
		try {
			obj = Class.forName(nomeTipo).newInstance();
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Classe nao encontrada");
			obj = null;
		} catch (IllegalAccessException iae) {
			System.out.println("Acesso ilegal");
			obj = null;
		} catch (InstantiationException ie) {
			System.out.println("Excecao ao instanciar classe");
			obj = null;
		}
		return obj;
	}

	public static void main(String[] args) {
		criaInstancia(args[0]).toString();
	}

}
