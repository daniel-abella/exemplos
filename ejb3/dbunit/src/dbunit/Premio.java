package dbunit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Premio {
	@Id @GeneratedValue
	private Long id;
	
	private String descricao;
	@OneToOne
	private Aluno aluno;

	public Premio(String descricao, Aluno aluno) {
		super();
		this.descricao = descricao;
		this.aluno = aluno;
	}
	
	public Premio(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
}
