package quinze;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
class A {
	@Id
	@GeneratedValue
	private int chave;
}

@Entity
@Table(name="NOME_DA_TABELA_PARA_OBJETOS_B")
class B {
	@Id
	@GeneratedValue
	private int chave;
}

@Entity
@Table(catalog="CATALOGO")
class C {
	@Id
	@GeneratedValue
	private int chave;
}

@Entity
@Table(schema="ESQUEMA")
class D {
	@Id
	@GeneratedValue
	private int chave;
}

@Entity
@Table(schema="ESQUEMA", catalog="CATALOGO")
class E {
	@Id
	@GeneratedValue
	private int chave;
}

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"nome", "cpf"})})
class F {
	@Id
	@GeneratedValue
	private long chave;
	
	public String nome;
	public String cpf;
}