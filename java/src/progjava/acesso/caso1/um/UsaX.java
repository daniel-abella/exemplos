package progjava.acesso.caso1.um;

public class UsaX extends X {
	public X get() {
		this.x = -9;
		X retorno = new X();
		retorno.x = 20;
		return retorno;
	}
}
