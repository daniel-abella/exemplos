package p16;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class ClasseDaoImpl extends HibernateDaoSupport implements ClasseDao {
	public Classe get(Long id) {
		return (Classe) getHibernateTemplate().get(Classe.class, id);
	}
	
	public void save(Classe objeto) {
		getHibernateTemplate().save(objeto);
	}
	
	public void delete(Classe objeto) {
		getHibernateTemplate().delete(objeto);
	}
	
	public List<Classe> objetos() {
		return getHibernateTemplate().find("from Classe");
	}
}
