/*
 * For4.java vers�o 1.0 02/10/2003 
 * Copyright (c) 2003 F�bio Lucena
 */

package progjava.iteracao;

public class For4 {
    public static void main(String[] args) {
        int i;
        for (i = 1; i <= 10; i++) {
            if (i > 3) {
                i = 11;
                continue;
            }
        }
        System.out.println(i);
    }
}
