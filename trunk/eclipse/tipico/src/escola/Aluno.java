package escola;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class Aluno {
	private String nome;
	private List<Inscricao> cursos = new ArrayList<Inscricao>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void adicionaCurso(Inscricao inscricao) {
		cursos.add(inscricao);
	}

	public String[] cursosEmAndamento() {
		List<String> retorno = new ArrayList<String>();
		Calendar hoje = Calendar.getInstance();
		for (Inscricao inscricao : cursos) {
			if (hoje.before(inscricao.getDataFim()))
				retorno.add(inscricao.getCurso().getNome());
		}
		return retorno.toArray(new String[0]);
	}
	
	public Iterator<Inscricao> inscricoes() {
		return cursos.iterator();
	}
}
