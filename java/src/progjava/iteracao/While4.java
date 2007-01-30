package progjava.iteracao;

/**
 * Copyright (c) 2003 
 * F�bio Nogueira de Lucena
 * Date: 23/05/2003
 * Time: 15:03:18
 */
public class While4 {
    public static void main(String[] args) {
        int x = 0;

        while (x<=10) {
            x = x+1;
            if (x>3) {
                x = x+2;
            }
        }

        System.out.println(x);
    }
}

// O valor impresso n�o � 10
// O valor impresso n�o � 18
// O valor impresso n�o � 13
// O valor impresso n�o � 9
// O valor impresso � 12
// Este c�digo entra em um la�o infinito.