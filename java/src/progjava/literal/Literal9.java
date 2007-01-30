package progjava.literal;

public class Literal9 {
    public static void main(String[] args) {
        char c = \u0027\u0022\u0027;
        System.out.println(c);
        System.out.println(\u0027\u0022\u0027);
        System.out.println(\u0063);
    }
}

// C�digo UNICODE � processado antes da identifica��o de tokens em Java.
// O valor \u0027 � aspas simples e \u0022 � aspas duplas. Ou seja, a atribui��o da linha 5 deposita em c o caractere '"'.
// A linha 6 imprime o caractere aspas duplas (").
// A linha 7 imprime outra aspas duplas.
// A linha 8 imprime a terceira das asplas duplas impressas por este programa.
// N�o ocorre um erro de compila��o na linha 8. Como valores UNICODE s�o inicialmente processados, \u0063 � convertido no caractere c, que neste contexto, equivale � vari�vel c.
