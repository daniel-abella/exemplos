package p11;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Recorde {
	private Long id;
	private Calendar data;
	private String descricao;
	private Recorde anterior;

	public boolean equals(Object obj) {
		if (obj instanceof Recorde) {
			Recorde robj = (Recorde) obj;
			if (robj.data.equals(data) && robj.descricao.equals(descricao))
				return true;
			else
				return false;
		} else
			return false;
	}
	
	public int hashCode() {
		return data.hashCode() + descricao.hashCode();
	}
	
	public String toString() {
		Locale loc = new Locale("pt", "BR");
		DateFormat df = DateFormat.getTimeInstance(DateFormat.FULL, loc);
		StringBuilder sb = new StringBuilder(descricao);
		sb.append(String.format(" (%s)",df.format(data.getTime())));
		return sb.toString();
	}
	
	public Recorde getAnterior() {
		return anterior;
	}
	public void setAnterior(Recorde anterior) {
		this.anterior = anterior;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}	
}
