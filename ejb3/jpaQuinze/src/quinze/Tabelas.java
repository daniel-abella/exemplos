package quinze;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
class A {
	@Id
	private byte chave;
}

@Entity
@Table(name="NOME_DA_TABELA_PARA_OBJETOS_B")
class B {
	@Id
	private short chave;
}

@Entity
@Table(catalog="CATALOGO")
class C {
	@Id
	private int chave;
}

@Entity
@Table(schema="ESQUEMA")
class D {
	@Id
	private int chave;
}

@Entity
@Table(schema="ESQUEMA", catalog="CATALOGO")
class E {
	@Id
	private int chave;
}

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"nome", "cpf"})})
class F {
	@Id
	private long chave;
	
	public String nome;
	public String cpf;
}