package p07;

import java.util.List;

public class Livro {
	private Long id;
	private String titulo;
	private List<String> autores;
	
	public String toString() {
		return titulo + " " + autores;
	}
	
	public List<String> getAutores() {
		return autores;
	}
	public void setAutores(List<String> autores) {
		this.autores = autores;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}	
}
