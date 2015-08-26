### Onde obter ###
http://exemplos.googlecode.com/svn/trunk/ejb3/jpaOito/

Exemplos ([série](http://code.google.com/p/exemplos/wiki/ejbPersistence)): [ANTERIOR](http://code.google.com/p/exemplos/wiki/jpaSete) e [PRÓXIMO](http://code.google.com/p/exemplos/wiki/jpaNove).

# Introdução #
Há duas formas de se ter acesso ao estado de um objeto: campo (acesso baseado em campo) ou propriedade (acesso baseado em propriedade). O acesso baseado em propriedades faz uso dos métodos get/set. Estas formas não podem ser combinadas em uma mesma hierarquia, ou seja, ou uma classe emprega campos ou propriedades, exclusivamente. Adicionalmente, em uma dada hierarquia, ou todas as classes usam o acesso por campo ou por propriedade.

Acesso por campo. Significa que o _persistence provider_ irá ter acesso direto ao atributo do objeto, sem emprego dos métodos get/set.

Acesso por propriedade. Significa que o _persistence provider_ irá fazer uso, necessariamente, dos métodos get/set sempre que for preciso obter o valor ou definir o valor para um dado atributo de um objeto. Tais métodos devem ser declarados como **public** ou **protected**.

O acesso por propriedade, ao contrário do acesso por campo, permite contemplar cenários onde os métodos get/set realizam operações além de simplesmente recuperar/definir o valor de um atributo.

A opção pelo acesso é realizado pelo local onde se coloca uma anotação. Se a anotação se refere a um atributo, então o acesso é por campo. Alternativamente, se a anotação é realizado em método get (necessariamente o método get), então o acesso é por propriedade.

Para ilustrar como fazer uso destas duas opções, observe as classes Campo e Propriedade, fornecidas abaixo. Observe que a classe Campo foi anotada sobre um campo (atributo id). Isto significa que, todas as demais anotações também devem ser realizadas sobre atributos. O que não for anotada também é implicitamente definido como acesso a campo. Convém ressaltar do parágrafo anterior que para uma dada classe ou se emprega campo ou propriedade.

```
package oito;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Campo {
    @Id
    @GeneratedValue
    private Long id;

    private int x;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public int getX() {
	return x;
    }

    public void setX(int x) {
	String quem = new Throwable().getStackTrace()[1].toString();
	System.out.println("setX " + quem);
	this.x = x;
    }
}
```

Abaixo segue a classe Propriedade. Ao contrário do exemplo anterior, a anotação foi associada a uma propriedade (método get). Isto significa que, se houvessem outras anotações, estas também deveriam ser realizadas sobre os métodos get correspondentes. No exemplo abaixo, esta é a única anotação. Todos os acessos às informações mantidas por objetos desta classe, contudo, serão realizados pelos _persistence provider_ por meio dos método get/set correspondentes.

```
package oito;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Propriedade {
    private long id;
    private int x;
	
    @Id
    @GeneratedValue
    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public int getX() {
	return x;
    }

    public void setX(int x) {
	String quem = new Throwable().getStackTrace()[1].toString();
	System.out.println("setX " + quem);
	this.x = x;
    }
}
```

# Programa exemplo #
O programa abaixo permite ilustrar que, de fato, o acesso via campo não faz uso dos métodos get/set, enquanto o acesso via propriedades, exige que o _persistence provider_ faça necessáriamente acesso via os métodos get/set correspondentes. No exemplo abaixo tem-se uma única aplicação, demonstrando que formas distintas podem coexistir em uma mesma aplicação. Convém ressaltar, contudo, que isto não é permitido por classe, que exige um ou outra forma exclusivamente.

Ao executar o programa abaixo observa-se que o método **setX** é chamado para a instância de Campo pelo método **main**. O método **setX** de Propriedade também é chamado para a instância de Propriedade pelo método **main**. Contudo, a execução mostra que o método **setX** é chamado uma terceira vez. Esta chamada adicional ocorre por conta do _persistence provider_ ao recuperar a instância de Propriedade anteriormente armazenada. Observe que o método **setX** não é chamado para a instância recuperada da classe Campo, pois o acesso aos atributos desta classe é feito diretamente no atributo, sem emprego dos métodos get/set.

```
package oito;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Aplicacao {
    public static void main(String[] args) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaOito");
	EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();
	tx.begin();
		
	Campo campo = new Campo();
	campo.setX(1);
	em.persist(campo); // Insere campo
		
	Propriedade propriedade = new Propriedade();
	propriedade.setX(2);
	em.persist(propriedade); // Insere propriedade
		
	tx.commit();
	em.close();	
		
	em = emf.createEntityManager();
	em.find(Campo.class, campo.getId());
	em.find(Propriedade.class, propriedade.getId());		
	em.close();
    }
}
```

# Considerações finais #
Este exemplo ilustrou as diferenças e forma de funcionamento das duas formas de acesso aos atributos de um objeto: campo ou propriedade. No primeiro caso, campo, o _persistence provider_ faz uso direto da propriedade, tanto para ter acesso ao valor quanto para estabelecê-lo, sem fazer uso dos métodos get/set. No segundo caso, propriedade, o _persistence provider_ faz uso, necessariamente, dos métodos get/set. Naturalmente, dada uma propriedade para a qual os métodos get/set realizam várias operações, por exemplo, consistência, o acesso pela forma propriedade é aconselhada. Em geral, contudo, quando os métodos get/set apenas permitem recuperar/definir o valor de um atributo privado, então a forma campo é recomendada.