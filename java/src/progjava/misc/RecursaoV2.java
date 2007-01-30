package progjava.misc;

public class RecursaoV2 {

    static int[] v = new int[16];

    static int fim = 25;
    static int tc = 15;
    static int contador = 0;

    public static void geraSeq() {
        //System.out.println();
        //for (int i = 1; i <= TC; i++) {
        //    System.out.print(" " + v[i]);
        //}
        contador++;
    }

    public static void gera(int k) {
        for (v[k] = v[k - 1] + 1; v[k] <= fim; v[k]++) {
            if (k == tc) {
                geraSeq();
            } else {
                gera(k + 1);
            }
        }
        v[k]--;
    }
    
    public static void gerador(int nCols, int dominio) {
        fim = dominio;
        tc = nCols;
        gera(1);
    }

    public static void main(String[] args) {
        for (int i = 0; i < v.length; i++) {
            v[i] = i;
        }
        gerador(15,25);

        System.out.println("\nTOTAL: " + contador);
    }
}