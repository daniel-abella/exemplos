package p16;

import java.util.List;

public interface ClasseDao extends Dao {
	Classe get(Long id);
	void save(Classe objeto);
	void delete(Classe objeto);
	List<Classe> objetos();
}
