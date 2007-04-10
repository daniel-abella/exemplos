package dominio;

public interface ConteinerRepository {
	void persiste(Conteiner c);
	Conteiner obtem(String nome);
}
