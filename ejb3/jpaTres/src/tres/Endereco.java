package tres;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco {
    private String rua;
    private int numero;
    
    // Construtor default é obrigatório
    public Endereco() {}
    
    public Endereco(String rua, int numero) {
	super();
	this.rua = rua;
	this.numero = numero;
    }

    public String toString() {
	return rua + " " + numero;
    }
}
