package dominio;

import java.util.Arrays;
import java.util.List;

import org.springframework.test.annotation.Repeat;
import org.springframework.test.jpa.AbstractJpaTests;

/**
 * Ilustra implementação de teste para camada de persistência implementada
 * usando JPA. Faz uso do JUnit 3.8.1. Incompatível com versão do JUnit 4 
 * ou posterior.
 * 
 * <br>Usado para teste apenas. Observe que não há demarcação explícita de
 * transação. Neste caso, usa-se demarcação padrão implícita e adequada
 * para casos de teste. 
 * 
 * @author Fábio Nogueira de Lucena
 *
 */

public class ConteinerRepositoryDefaultTest extends AbstractJpaTests {
	
	@Override
	protected String[] getConfigLocations() {
		return new String[] { "classpath:db-beans-teste.xml" };
	}

	private ConteinerRepository cr;

	public void setCr(ConteinerRepository cr) {
		this.cr = cr;
	}

	public ConteinerRepositoryDefaultTest() {
		setDefaultRollback(false);
	}
	
	public void testVerificaSpringInjection() {
		assertNotNull(cr);
	}
	
	public void testInsereVerificaRemove() {
		String chave = "x!@21K0-__+2";
		Conteiner c = new Conteiner(chave);
		cr.persiste(c);
		Conteiner outroConteiner = cr.obtem(chave);
		assertNotNull(outroConteiner);
		cr.remove(outroConteiner);
		assertNull(cr.obtem(chave));
		c.setNome(c.getNome() + "--fim");
		cr.atualiza(c);
	}
	
	public void testObtemPorNome() {
		Conteiner c = cr.obtem("55");
		if (c == null)
			cr.persiste(new Conteiner("55"));
		assertNotNull(cr.obtem("55"));
	}

	@Repeat(5)
	public void testInsere10Conteineres() {
		Conteiner c = newConteiner();
		cr.persiste(c);
		assertTrue(true);
	}
	
	private static Conteiner newConteiner() {
		Elemento[] elms = { new Elemento("a"), new Elemento("b") };
		List<Elemento> le = Arrays.asList(elms);
		Conteiner ce = new Conteiner(Long.toString((int)(Math.random() * 100)));
		ce.setLista(le);		
		return ce;
	}
}
