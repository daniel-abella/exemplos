package dominio;

import java.util.Arrays;
import java.util.List;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

@RunWith(JMock.class)
public class ConteinerServiceTest {
	Mockery contexto = new JUnit4Mockery();

	@Test
	public void maiusculas() {
		final ConteinerRepository cr = contexto.mock(ConteinerRepository.class);
		ConteinerService cs = new ConteinerService();
		cs.setCr(cr);
		final String nome = "teste";
		final Conteiner conteiner = newConteiner();
		contexto.checking(new Expectations() {
			{
				one(cr).obtem(nome); will(returnValue(conteiner));
				one(cr).atualiza(conteiner);
			}
		});

		Conteiner cnt = cs.toUpperCase("teste");
		assertNotNull(cnt);
		assertTrue(cnt.getLista().get(0).getNome().equals("CASA"));
	}

	private static Conteiner newConteiner() {
		Elemento[] elms = { new Elemento("casa"), new Elemento("bola") };
		List<Elemento> le = Arrays.asList(elms);
		Conteiner ce = new Conteiner("teste");
		ce.setLista(le);
		return ce;
	}
}
