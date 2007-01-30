package progjava.misc;

public class RecursaoV1 {

    static int[] v = new int[16];

    static final int FIM = 25;
    static final int TC = 15;
    static int contador = 0;
    static int pilha = 0;
    static int maximo = 0;

    public static void geraSeq() {
        //System.out.println();
        //for (int i = 1; i <= TC; i++) {
        //    System.out.print(" " + v[i]);
        //}
        contador++;
    }

    public static void gera(int k) {
        pilha++;
        maximo = (maximo < pilha) ? pilha : maximo;
        
        if (k == TC) {
            for (v[k] = v[k - 1] + 1; v[k] <= FIM; v[k]++) {
                geraSeq();
            }
            v[k]--;
            pilha--;
        } else {
            for (v[k] = v[k - 1] + 1; v[k] <= FIM; v[k]++) {
                gera(k + 1);
            }
            v[k]--;
            pilha--;
        }
    }

    public static void main(String[] args) {
        for(int i = 0; i < v.length; i++) {
            v[i] = i;
        }
        gera(1);
        System.out.println("\nTOTAL: " + contador);
        System.out.println("PILHA: " + pilha);
        System.out.println("MAXIMO: " + maximo);
    }

}