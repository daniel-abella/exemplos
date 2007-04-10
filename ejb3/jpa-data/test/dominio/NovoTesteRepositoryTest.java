package dominio;

import org.springframework.test.jpa.AbstractJpaTests;

public class NovoTesteRepositoryTest extends AbstractJpaTests {
	private ConteinerRepository cr;
	
	public ConteinerRepository getCr() {
		return cr;
	}

	public void setCr(ConteinerRepository cr) {
		this.cr = cr;
	}

	public NovoTesteRepositoryTest() {
		setDefaultRollback(false);
	}

	public void testverificaSpringInjection() {
		assertNotNull(cr);
	}

}
