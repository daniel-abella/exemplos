package dezenove;

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
	private Date dataInicio;
	
	@Temporal(TemporalType.TIME)
	private Date horaInicio;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date instanteTermino;
	
	public Atividade() {}
}
