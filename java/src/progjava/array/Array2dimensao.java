package progjava.array;

public class Array2dimensao {

    public static void main(String[] args) {
        // Um array de duas dimensoes de inteiros.
        int[][] a2;

        a2 = new int[10][];   // Array de 10 posicoes, cada uma
        // delas um array

        a2[0] = new int[10];  // Inicia cada uma das 10 posicoes de arrays
        a2[1] = new int[10];  // com arrays de 10 posicoes de inteiros
        a2[2] = new int[10];
        a2[3] = new int[10];
        a2[4] = new int[10];
        a2[5] = new int[10];
        a2[6] = new int[10];
        a2[7] = new int[10];
        a2[8] = new int[10];
        a2[9] = new int[10];

        // As linhas imediatamente acima podem ser substituidas
        // por a2 = new int[10][10];

        int i = 10, j = 10;
        while (--i >= 0) {
            while (--j >= 0)
                a2[i][j] = 1;

            j = 10;
        }

        i = j = 10;
        int total = 1;
        while (--i >= 0) {
            while (--j >= 0)
                total += a2[i][j];

            j = 10;
        }

        System.out.println("total = " + total);

    }
}
