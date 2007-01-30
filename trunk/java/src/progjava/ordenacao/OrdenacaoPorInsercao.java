package progjava.ordenacao;

public class OrdenacaoPorInsercao {
    public static void insercao(int[] v) {
        int j;
        int aux;
        int i;
        for (j = 1; j < v.length; j = j + 1) {
            aux = v[j];
            i = j - 1;
            while ((i >= 0) && (v[i] > aux)) {
                v[i + 1] = v[i];
                i = i - 1;
            }
            v[i + 1] = aux;
        }
    }

    public static void main(String[] args) {
        int arrayDesordenado[] = {10, 5, 2, 4, -20};

        System.out.print("\nArray desordenado: ");
        for (int i = 0; i < arrayDesordenado.length; i++)
            System.out.print(arrayDesordenado[i] + " ");

        insercao(arrayDesordenado);

        System.out.print("\nArray ordenado: ");
        for (int i = 0; i < arrayDesordenado.length; i++)
            System.out.print(arrayDesordenado[i] + " ");

    }

}
