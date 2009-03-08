package tres;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class Endereco implements Serializable {

    private String rua;
    private int numero;

    // Construtor default é obrigatório
    public Endereco() {
    }

    public Endereco(String rua, int numero) {
        super();
        this.rua = rua;
        this.numero = numero;
    }

    @Override
    public String toString() {
        return rua + " " + numero;
    }
}
