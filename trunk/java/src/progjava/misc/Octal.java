
package progjava.misc;
class Octal {

    public static void main(String[] a) {

        int i = 65;
        System.out.println("\ni = " + i);

        // Ira imprimir 6.8 + 5 = 53
        // Observe que � atribu�do a j um valor octal do tipo long
        long j = 065l;
        System.out.println("j = " + j);

        // Atribui��o do octal 10 � vari�vel i
        i = (int) 010l;
        System.out.println("(int)010l = " + i);

        // Atribui��o do decimal 10 � vari�vel i
        i = (int) 010f;
        System.out.println("(int)010f = " + i);

        // Observe que a linha abaixo causa um erro
        // integer number too large: 09
        // Lembre-se de que seq��ncias de d�gitos iniciadas por 0 representam
        // n�meros na base octal e, portanto, o maior d�gito � 8.
        // O valor decimal 9 na base octal � 011.
        i = 011; // 09 provoca erro.
        System.out.println("\ni = " + i);

    }

}
