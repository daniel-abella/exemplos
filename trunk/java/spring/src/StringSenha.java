
public class StringSenha implements IRestricao {

	public boolean satisfaz(Object obj) {
		boolean satisfaz = false;
		if (obj instanceof String) {
			satisfaz = ((String) obj).equals("Senha");
		}
		return satisfaz;
	}
}
