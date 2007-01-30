package progjava.excecao;

public class Excecao14 {
	private String nome = "ok";

	public static void main(String[] args) {
		Excecao14 obj = new Excecao14();
		String nome = obj.getNome();
		System.out.println(nome.toUpperCase());
	}

	public String getNome() {
		return nome;
	}
}