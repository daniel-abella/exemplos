
package progjava.decision;
public class Switch3 {

    public static void main(String[] args) {

        byte g = 3;

        final int i = 2;

        /* Compila sem problemas. Observe que o valor armazenado na vari�vel int
           i est� na faixa de um byte.
        */
        switch (g) {
            case 1:
                System.out.println("1");
                break;
            case i:
                System.out.println("128");
                break;
            default:
                System.out.println("valor não detectado");
        }

    }
}
