
package progjava.exp;
public class Expr05 {
    public static void main(String[] args) {
        int i1 = Integer.MAX_VALUE;
        int i2 = 1;
        long l = i1 + i2;
        System.out.println(l);
    }
}

// O valor impresso pela linha 7 � um valor negativo.
// A soma da linha 6 d� origem a um valor que n�o pode ser armazenado em um int.
// A express�o do lado direito da atribui��o � do tipo int.