package p07;

import java.util.List;

public class ClasseDeElementos {
	private Long id;
	private List<Elemento> lista;
	public Long getId() {
		return id;
	}
	private void setId(Long id) {
		this.id = id;
	}
	public List<Elemento> getLista() {
		return lista;
	}
	public void setLista(List<Elemento> lista) {
		this.lista = lista;
	}	
}
