package p18;

public class Pessoa {
	private Long id;
	private String nome;
	private Identidade idt;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Identidade getIdt() {
		return idt;
	}
	public void setIdt(Identidade idt) {
		this.idt = idt;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
