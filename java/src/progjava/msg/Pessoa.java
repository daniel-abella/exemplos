package progjava.msg;


public class Pessoa {
    private String nome;
    private int anoNascimento;

    public Pessoa(String n, int an) {
        nome = n;
        anoNascimento = an;
    }

    public String toString() {
        return nome + " (" + anoNascimento + ")";
    }
}

class TestaPessoa {
    public static void main(String[] args) {
        Pessoa p = new Pessoa("Joao", 1975);
        System.out.println(p.toString());
    }
}

// Este c�digo compila, mesmo possuindo mais de uma classe em um mesmo arquivo.
// Este c�digo � executado sem exce��es, mesmo com TestaPessoa n�o sendo p�blica.
// N�o h� erro na linha 13, onde h� sobreposi��o do m�todo toString de Object.
// Nao h� erro na linha 13, toString n�o � m�todo reservado.
// Na linha 21, p.toString() pode ser substitu�do por p, sem alterar a sa�da.