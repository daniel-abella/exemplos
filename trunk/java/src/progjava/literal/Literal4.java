package progjava.literal;

public class Literal4 {
    public static void main(String[] args) {
        System.out.println("string".length());
        System.out.println("".length());
    }
}

// N�o ocorre erro de compila��o na linha 5.
// N�o ocorre erro de compila��o na linha 6.
// Toda literal string � uma refer�ncia para uma inst�ncia da classe String.
// A linha 5 imprime o valor 6.
// A linha 5 n�o gera exce��o em tempo de execu��o.
// A linha 6 n�o gera exce�ao em tempo de execu��o.
// A linha 5 n�o imprime o valor null.
// A linha 6 n�o imprime o valor null.
// A linha 6 imprime o valor 0.
