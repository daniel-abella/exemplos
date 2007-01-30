
package progjava.iteracao;
public class Do2 {
    public static void main(String[] args) {
        int I = 1;

        do {
            while (I < 1) {
                System.out.println("I is " + I);
            }
        } while (I > 1);
    }
}

/* O programa abaixo, sem o emprego das chaves do do-while e while
 * torna-se de dif�cil interpreta��o, embora um programa v�lido.
 */

