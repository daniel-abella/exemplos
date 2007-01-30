/*
 * While1.java
 * Vers�o: 1.1.1
 * Data: 14/05/2003 17:50:58
 * Copyright (c) F�bio Nogueira de Lucena
 */
package progjava.iteracao;

public class While1 {
    public static void main(String[] args) {
        int x = 0;
        int y = 0;

        while ((x-2) <= 5) {
            x = x + 1;
        }
        while (3 != y) {
            y = y + 1;
            while ( (x*x + y*y + 0*0) >= 10 ) {
                x = x - 1;
            }
        }

        System.out.println("x = " + x);
    }
}

// O valor impresso pelo programa abaixo � 0
// O valor impresso pelo programa abaixo n�o � 2
// O valor impresso pelo programa abaixo n�o � 3
// O valor impresso pelo programa abaixo n�o � 5