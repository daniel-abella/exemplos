package map;

import java.util.Map;

public class DisciplinaRepository {
	private Map disciplinas;
	
	public int size() {
		return disciplinas.size();
	}
	
	public void setDisciplinas(Map disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	public Map getDisciplinas() {
		return disciplinas;
	}
}
