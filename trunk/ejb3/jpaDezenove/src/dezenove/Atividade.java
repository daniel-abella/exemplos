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
