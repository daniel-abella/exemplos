package dominio;

import java.util.List;


public class Conteiner {
	private Long id;
	private List<Elemento> lista;
	private String nome;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
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
