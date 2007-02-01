package p07;

import java.util.Currency;
import java.util.Locale;

public class Configuracao {
	private Long id;
	private Locale local;
	private Currency moeda;
	
	public String toString() {
		return id + " " + local.toString() + " " + moeda.toString();
	}
	
	public Locale getLocal() {
		return local;
	}
	
	public void setLocal(Locale local) {
		this.local = local;
	}
	
	public Currency getMoeda() {
		return moeda;
	}
	
	public void setMoeda(Currency moeda) {
		this.moeda = moeda;
	}

	public Long getId() {
		return id;
	}

	private void setId(Long id) {
		this.id = id;
	}
}
