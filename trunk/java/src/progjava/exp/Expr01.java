package progjava.exp;
/* As duas atribui��es a[b] = b = 1 s�o executadas da direita para a 
   esquerda. Contudo, os valores das express�es "parciais" s�o da esquerda
   para a direita, ou seja, ser� em a[0] que algum valor ser� depositado pelo
   lado direito da atribui��o. Neste caso, n�o h� posi��o 5 no array a e, 
   dessa forma, ocorre um erro em tempo de execu��o: 
   ArrayIndexOutOfBoundsException.
*/

public class Expr01 {
    public static void main(String[] args) {
        int a[] = {0, 0};

        int b = 5;

        a[b] = b = 1;

        System.out.println("b = " + b + " a[b] = " + a[b]);
    }
}
