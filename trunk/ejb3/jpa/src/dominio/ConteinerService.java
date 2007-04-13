package dominio;

public class ConteinerService {
	private ConteinerRepository cr = null;
	
	public Conteiner tornaNomesMaiusculasPorConteiner(String nome) {
		Conteiner c = cr.obtem(nome);
		for (Elemento e : c.getLista())
			e.setNome(e.getNome().toUpperCase());
		cr.atualiza(c);
		return c;
	}

	public ConteinerRepository getCr() {
		return cr;
	}

	public void setCr(ConteinerRepository cr) {
		this.cr = cr;
	}
}
