
public class Integer37 implements IRestricao {

	public boolean satisfaz(Object obj) {
		boolean retorno = false;
		if (obj instanceof Integer) {
			if (((Integer) obj).intValue() == 37) {
				retorno = true;
			}
		}
		return retorno;
	}

}
