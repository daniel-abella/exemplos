package ex2;

public class TiposBasicos {
    private int valor;

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String toString() {
        return "NOME: " + getNome() + "\nVALOR: " + getValor();
    }
}
