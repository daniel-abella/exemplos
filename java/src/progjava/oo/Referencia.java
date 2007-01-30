package progjava.oo;

public class Referencia {
    public String titulo;
    
    public String imprime(String prefixo, int npaginas) {
        return prefixo + titulo + " " + npaginas;
    }
}

class Livro extends Referencia {
    public String imprime(String prefixo, byte npaginas) {
        return prefixo + titulo + " " + npaginas;
    }
}