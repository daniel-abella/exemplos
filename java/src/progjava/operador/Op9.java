package progjava.operador;

class Op9 {
    public static void main(String[] args) {
        int[] v = new int[2];
        int x = 0;

        v[++x] += 1;

        System.out.println(v[0]);
        System.out.println(v[1]);
    }
}

// N�o ocorre um erro em tempo de compila��o na linha 8
// N�o ocorre um erro em tempo de execu��o na linha 8
// S�o impressos os valores 0 e 1, nesta ordem.
