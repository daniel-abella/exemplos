package maiusculas;

public class ConverteParaMaiusculasImpl implements ConverteParaMaiusculas {

	public String paraMaiusculas(String str) {
		return str != null ? str.toUpperCase() : null;
	}
}
