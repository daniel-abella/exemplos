package dominio;

import java.util.ArrayList;
import java.util.List;

public class ConteinerRepositoryDefaultTest {
	
	public static void main(String[] args) {
		ConteinerRepository cr = new ConteinerRepositoryDefault();
		cr.persiste(newConteiner());
	}
	
	private static Conteiner newConteiner() {
		List<Elemento> le = new ArrayList<Elemento>();
		Elemento e = new Elemento();
		e.setNome("a");
		le.add(e);
		e = new Elemento();
		e.setNome("b");
		le.add(e);
		Conteiner ce = new Conteiner();
		ce.setLista(le);		
		return ce;
	}
}
