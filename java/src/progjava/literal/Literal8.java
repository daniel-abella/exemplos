package progjava.literal;

public class Literal8 {
    public static void main(String[] args) {
        System.out.println("tab\t\ttab\u0022);
    }
}

// O c�digo acima n�o provoca um erro em tempo de compila��o.
// A linha 5 n�o provoca um erro em tempo de execu��o.
// A linha 5 imprime os caracteres tab e tab separados por duas tabula��es.
// O valor UNICODE \u0022 equivale a aspas duplas.
// ZerosComSinal UNICODE s�o processados primeiro, ou seja, \u0022 � transformado em
// uma aspas duplas, o que evita um erro de compila��o deste c�digo.