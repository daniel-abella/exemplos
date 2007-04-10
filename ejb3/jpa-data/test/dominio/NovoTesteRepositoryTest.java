package dominio;

import org.springframework.test.jpa.AbstractJpaTests;

public class NovoTesteRepositoryTest extends AbstractJpaTests {
	
	@Override
	protected String[] getConfigLocations() {
		return new String[] { "classpath:applicationContext.xml" };
	}

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
