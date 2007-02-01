package p16;

import org.junit.Test;

public class ClasseDaoTest extends BaseDaoTestCase {
	private ClasseDao classeDao = null;

	public ClasseDaoTest() {
		// Todas as mudanças serão efetuadas (commit)
		// Para definir commit ou rollback por método, primeiro
		// comente a linha abaixo e acrescente o método setComplete()
		// em cada método que deve realizar o commit. 
		setDefaultRollback(false);
	}
	
	public void setClasseDao(ClasseDao classeDao) {
		this.classeDao = classeDao;
	}

	@Test
	public void testCriaInstancia() {
		int total = classeDao.objetos().size();
		Classe objeto = new Classe();
		classeDao.save(objeto);
		assertEquals(total + 1, classeDao.objetos().size());
	}
	
	@Test
	public void testCriaObjetoDePropriedades() throws Exception {
		Classe objeto = new Classe();
		objeto = (Classe) populate(objeto);
		System.out.println(objeto);
	}
}
