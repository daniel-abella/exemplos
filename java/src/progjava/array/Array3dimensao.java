package progjava.array;

public class Array3dimensao {

    public static void main(String[] args) {
        // Um array de 3 dimensoes
        int[][][] a3;

        // Um array de 10 posicoes, cada uma delas e' um array
        // de duas dimensoes.
        a3 = new int[10][][];

        a3[0] = new int[10][10]; // Inicia a posicao 0 de um array de 3 dimensoes
        // com um array de 2 dimensoes (10x10)

        a3[1] = new int[10][10];
        a3[2] = new int[10][10];
        a3[3] = new int[10][10];
        a3[4] = new int[10][10];
        a3[5] = new int[10][10];
        a3[6] = new int[10][10];
        a3[7] = new int[10][10];
        a3[8] = new int[10][10];
        a3[9] = new int[10][10];

        // As inicializacoes acima poderiam ser substituidas por aquela abaixo
        // a2 = new int[10][10][10];

        int i = 10, j = 10, k = 10;
        while (--i >= 0) {
            while (--j >= 0) {
                while (--k >= 0)
                    a3[i][j][k] = 1;

                k = 10;
            }
            j = 10;
        }

        i = j = k = 10;
        int total = 0;
        while (--i >= 0) {
            while (--j >= 0) {
                while (--k >= 0)
                    total += a3[i][j][k];

                k = 10;
            }
            j = 10;
        }

        System.out.println("total = " + total);

    }
}
