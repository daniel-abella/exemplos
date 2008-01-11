package doze;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Aluno {
	@Id
	@GeneratedValue
	private Long id;

	private String nome;
}
