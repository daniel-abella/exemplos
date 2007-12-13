package zero;

public class PessoaApplicacao {
	public static void main(String... args) {
		Pessoa p = new Pessoa("Pedro Silva Souza da Silva");
		System.out.println(p);
		p = null;
		System.out.println(p);
	}
}
