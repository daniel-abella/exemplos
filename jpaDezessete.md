### Onde obter ###
http://exemplos.googlecode.com/svn/trunk/ejb3/jpaDezessete/

Exemplos ([série](http://code.google.com/p/exemplos/wiki/ejbPersistence)): [ANTERIOR](http://code.google.com/p/exemplos/wiki/jpaDezesseis) e [PRÓXIMO](http://code.google.com/p/exemplos/wiki/jpaDezoito).

# Introdução #
Observe o tipo enum abaixo.

```
package dezessete;

public enum EstadoPedido {
	ABERTO, FECHADO, APROVADO, PENDENTE
}
```

Para persistir o estado de uma variável deste tipo, não é necessário nenhum mapeamento onde o tipo é declarado. A classe que faz uso do tipo, contudo, pode explicitamente indicar se o que se deseja persistir é o valor ordinal do tipo ou a seqüência de caracteres correspondente, conforme ilustrado abaixo.

```
package dezessete;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pedido {
	@Id
	@GeneratedValue
	private long id;
	
	@Enumerated(EnumType.ORDINAL)
	private EstadoPedido estado;
	
	@Enumerated(EnumType.STRING)
	private EstadoPedido estadoInicial;
	
	public Pedido() {}
	
	public Pedido(EstadoPedido corrente, EstadoPedido inicial) {
		estado = corrente;
		estadoInicial = inicial;
	}
}
```

A classe acima emprega dois atributos do tipo EstadoPedido. O primeiro deles será persistido por meio do valor ordinal correspondente, ou seja, um valor de 0 a 3, para o tipo EstadoPedido. O segundo será persistido por meio da representação textual do valor, ou seja, ou a seqüência de caracteres "ABERTO", "FECHADO", "APROVADO" ou "PENDENTE" será persistida.

A aplicação persiste uma instância de Pedido e permite verificar estas opções. Observe que o mapeamento **EnumType.ORDINAL** é o padrão, ou seja, **@Enumerated(EnumType.ORDINAL)** é equivalente à **@Enumerated**.

```
package dezessete;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EnumAplicacao {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaDezessete");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.persist(new Pedido(EstadoPedido.ABERTO, EstadoPedido.APROVADO));

		tx.commit();
		em.close();
	}
}
```