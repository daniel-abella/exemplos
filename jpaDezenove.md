### Onde obter ###
http://exemplos.googlecode.com/svn/trunk/ejb3/jpaDezenove/

Exemplos ([série](http://code.google.com/p/exemplos/wiki/ejbPersistence)): [ANTERIOR](http://code.google.com/p/exemplos/wiki/jpaDezoito) e [PRÓXIMO](http://code.google.com/p/exemplos/wiki/jpaVinte).

# Introdução #
Informações que representam instantes de tempo são comuns. Em alguns casos há interesse em persistir todo um instante, o que inclui a hora, o minuto e o segundo corrente, juntamente com o dia, mês e ano. Em outros, apenas a data contendo o dia, o mês e o ano. Em outros, tem-se interesse apenas na hora, no minuto e no segundo corrente.

Cada uma das três opções apresentadas acima são representadas, respectivamente, pelos tipos **TemporalType.TIMESTAMP**, **TemporalType.DATE** e, por último, **TemporalType.TIME**.  Estes tipos são fornecidos como argumentos para a anotação **@Temporal**, conforme ilustrado na classe abaixo. Convém ressaltar que, por padrão, quando nenhuma anotação é fornecida, é empregada o tipo "mais completo", contendo a data e a hora, ou seja, o equivalente à anotação **@Temporal(TemporalType.TIMESTAMP)**.

```
package dezenove;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Atividade {
	@Id
	@GeneratedValue
	private long id;

	private Date criacao;

	@Temporal(TemporalType.DATE)
	private Date inicio;

	@Temporal(TemporalType.TIME)
	private Date hora;

	@Temporal(TemporalType.TIMESTAMP)
	private Date termino;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar previsao;

	public Atividade() {
	}

	public Atividade(Date inicio, Date hora, Date termino, Calendar previsao) {
		super();
		criacao = new Date();
		this.inicio = inicio;
		this.hora = hora;
		this.termino = termino;
		this.previsao = previsao;
	}

	public Date getCriacao() {
		return criacao;
	}

	public Date getInicio() {
		return inicio;
	}

	public Date getHora() {
		return hora;
	}

	public Date getTermino() {
		return termino;
	}

	public Calendar getPrevisao() {
		return previsao;
	}

	public String toString() {
		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL,
				DateFormat.FULL);
		String fmt = "%s\n%s\n%s\n%s\n%s\n";
		return String.format(fmt, df.format(criacao), df.format(inicio), 
				df.format(hora), df.format(termino), 
				df.format(previsao.getTime()));
	}
	
	public String toStringTermino() {
		return termino.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(AtividadesAplicacao.newAtividade());
	}
}
```

A persistência da classe acima é ilustrada no programa abaixo. Convém ressaltar, da saída produzida que, embora todas as linhas exibidas estejam empregando um mesmo formato, nem todas elas possuem informações apropriadas. Por exemplo, quando se persiste apenas da data, a hora recuperada correspondente é indicada por **00h00min00s**. Quando se persiste apenas a hora, a data recuperada correspondente é **1 de Janeiro de 1970**. Naturalmente, no primeiro caso, a hora não é relevante, assim como a data no segundo caso.

```
package dezenove;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AtividadesAplicacao {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("jpaDezenove");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Atividade uma = newAtividade();
		em.persist(uma);
		tx.commit();
		em.close();
		
		System.out.println("Atividade persistida:\n" + uma);
				
		em = emf.createEntityManager();
		Atividade atv = em.find(Atividade.class, 1L);
		System.out.println("Atividade recuperada:\n" + atv);
	}

	public static Atividade newAtividade() {
		Calendar agora = Calendar.getInstance();

		Calendar noveHoras30minutos = Calendar.getInstance();
		noveHoras30minutos.set(Calendar.HOUR_OF_DAY, 9);
		noveHoras30minutos.set(Calendar.MINUTE, 30);

		Calendar amanha = Calendar.getInstance();
		amanha.add(Calendar.DAY_OF_MONTH, 1);

		Calendar umMesAposHoje = Calendar.getInstance();
		umMesAposHoje.add(Calendar.MONTH, 1);

		return new Atividade(agora.getTime(), noveHoras30minutos.getTime(),
				amanha.getTime(), umMesAposHoje);
	}
}
```