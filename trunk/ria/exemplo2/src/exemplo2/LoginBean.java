package exemplo2;

public class LoginBean {
	private String nome;
	private String senha;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String login() {
		if ("a".equals(nome) && "a".equals(senha))
			return "sucesso";
		else
			return "falha";
	}
}
