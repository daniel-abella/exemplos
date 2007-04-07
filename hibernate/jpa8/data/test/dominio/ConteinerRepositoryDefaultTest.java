package dominio;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ConteinerRepositoryDefaultTest {
	
	@Test
	public void criaPersisteConteiner() {
		ConteinerRepository cr = new ConteinerRepositoryDefault();
		cr.persiste(newConteiner());
	}
	
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
