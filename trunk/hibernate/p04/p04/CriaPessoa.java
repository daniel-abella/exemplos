package p04;

public class CriaPessoa {
	public static void main(String[] args) {
		Pessoa p = new Pessoa();
		p.setNome("João da Silva");
		
		// Hibernate irá persistir esta instância ou não?
		// NÃO. Toda ação deve ser explicitamente requisitada.
		// A instância criada estará perdida para sempre ao
		// final deste programa.
	}
}
