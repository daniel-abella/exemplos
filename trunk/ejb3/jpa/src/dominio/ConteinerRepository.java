package dominio;

public interface ConteinerRepository {
	void persiste(Conteiner c);
	void remove(Conteiner c);
	Conteiner obtem(String nome);
	void atualiza(Conteiner c);
}
