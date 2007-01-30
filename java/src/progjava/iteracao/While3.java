package progjava.iteracao;

/**
 * Copyright (c) 2003
 * F�bio Nogueira de Lucena
 * Date: 23/05/2003
 * Time: 14:56:08
 */
public class While3 {
    public static void main(String[] args) {
        int x = 0;
        int y = 0;
        int z = 0;

        while ((x - 2) <= 5) {
            x = x + 1;
        }
        y = y + 1;
        if (y == 3) {
            z = y + z + x;
        } else {
            if (y == 4) {
                y = 15;
                while (y > 12) {
                    y = y - 1;
                }
            } else {
                y = 11;
            }
        }
        x = x + y + z;

        System.out.println(x);
    }
}

// O valor impresso n�o � 26
// O valor impresso n�o � 12
// O valor impresso n�o � 23
// O valor impresso n�o � 13
// O valor impresso � 19
// Este c�digo entra em um la�o infinito.
