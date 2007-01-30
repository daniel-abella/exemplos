package progjava.literal;

public class Literal2 {
    public static void main(String[] args) {
        int a = -2147483648;
        System.out.println(a);
    }
}

// O valor impresso pela execu��o da linha 6 � -2147483648.
// Ocorre um erro de compila��o na linha 5.
// O valor impresso � o menor valor inteiro, do tipo int, poss�vel em Java.
// N�o ocorre um erro de compila��o na linha 5.
