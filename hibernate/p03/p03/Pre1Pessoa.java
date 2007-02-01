package p03;

/**
 * Classes com o prefixo PreX, onde X será um dos valores
 * 1, 2, 3 e assim por diante, indicam transformações
 * que a classe Pre1Pessoa deverá passar até que seja 
 * passível a persistência dela via Hibernate. A classe
 * resultante (final) destas transformações será a classe
 * Pessoa.
 * 
 * Desejamos armazenar uma classe que representa uma pessoa.
 * Inicialmente apenas o nome da pessoa deverá ser armazenado.
 * Posteriormente outros atributos serão acrescentados.
 */
public class Pre1Pessoa {
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}	
}
