package progjava.iteracao;

/**
 * Copyright (c) 2003
 * F�bio Nogueira de Lucena
 * Date: 23/05/2003
 * Time: 15:05:22
 */
public class While5 {
    public static void main(String[] args) {
        int x = 0;
        int y = 0;

        while (y <= 5) {
            x = x + 1;
            if (x > 3) {
                y = y + 1;
            }
        }

        System.out.println(x);
    }
}

// O valor impresso n�o � 26
// O valor impresso n�o � 6
// O valor impresso n�o � 10
// O valor impresso n�o � 8
// O valor impresso � 9
// Este c�digo entra em um la�o infinito.