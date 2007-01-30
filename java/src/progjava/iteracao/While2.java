package progjava.iteracao;

/**
 * Copyright (c) 2003
 * F�bio Nogueira de Lucena
 * Date: 23/05/2003
 * Time: 13:37:42
 */
public class While2 {
    public static void main(String[] args) {
        int x = 0;
        int y = 0;
        int z = 5;

        while ((x * x + y * y) != z * z) {
            x = x + 1;
        }
        y = x + 1;

        while ((x * x - y * y) >= z * z) {
            y = y + 1;
        }

        if (x > (y - z)) {
            x = y + 1;
        } else {
            x = x + 1;
        }

        System.out.println(x);

    }
}
// O valor impresso na linha 30 n�o � 5
// O valor impresso na linha 30 n�o � 6
// O valor impresso na linha 30 n�o � 3
// O valor impresso na linha 30 n�o � 8
// O valor impresso na linha 30 � 7
// Este c�digo entra em um la�o infinito.
