package dominio;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ConteinerTest {
	private Conteiner c = null;
	
	@Before
	public void antes() {
		c = new Conteiner();
		List<Elemento> le = new ArrayList<Elemento>();
		le.add(new Elemento("um"));
		le.add(new Elemento("dois"));
		c.setLista(le);
	}
	
	@Test
	public void simples() {
		assertTrue("um".equals(c.getLista().get(0).getNome()));
		assertTrue("dois".equals(c.getLista().get(1).getNome()));
	}
}
