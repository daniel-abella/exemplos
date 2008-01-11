package doze;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Turma {
	@Id
	@GeneratedValue
	private Long id;

	private List<Aluno> alunos;
}
