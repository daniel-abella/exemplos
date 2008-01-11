package quinze;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
class Tabelas {
	@Id
	private byte chave;
}

@Entity
@Table(name="TABELA_B")
class B {
	@Id
	private short chave;
}

@Entity
@Table(catalog="TESTE")
class C {
	@Id
	private int chave;
}

