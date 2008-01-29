package vinte;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
class Surrogate1 {
	// Chave n�o � gerada automaticamente pelo persistence provider
	@Id
	private long id;
	
	public Surrogate1() {
		id = (long) (Math.random() * 1000 * 1000 * 1000);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}	
}

@Entity
class Surrogate2 {
	// Chave gerada pelo persistence provider
	@Id
	@GeneratedValue
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}		
}

@Entity
class Surrogate3 {
	// Chave gerada pelo persistence provider (identity column)
	// Argumento fornecido � o padr�o (opcional)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}	
}

@Entity
class Surrogate4 {
	// Em muitos casos, semelhante a GenerationType.IDENTITY
	// Persistence provider identifica a melhor estrat�gia
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}	
}

@Entity
class Surrogate5 {
	// Usa gerador de seq��ncia
	// Caso n�o dito o contr�rio, um �nico gerador �
	// compartilhado por todas as entidades.
	// Por padr�o, salta de 10 em 10
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}	
}

@Entity
class Surrogate6 {
	// Emprega o mesmo gerador de seq��ncia da entidade acima
	// Ao inserir uma inst�ncia, o pr�ximo n�mero da seq��ncia � empregado
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}	
}

// Usa gerador de seq��ncia "pr�prio", salta de 7 em 7
@SequenceGenerator(name = "GERADOR_SEQUENCIA", sequenceName = "CHAVE", initialValue = 1, allocationSize = 7)
@Entity
class Surrogate7 {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GERADOR_SEQUENCIA")
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}	
}

// Usa o mesmo gerador da entidade acima, mas salta de 9 em 9
@SequenceGenerator(name = "GERADOR_SEQUENCIA", sequenceName = "CHAVE", initialValue = 1, allocationSize = 9)
@Entity
class Surrogate8 {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GERADOR_SEQUENCIA")
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}	
}