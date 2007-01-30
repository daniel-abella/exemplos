/*
 * For2.java vers�o 1.0 02/10/2003
 * Copyright (c) 2003 F�bio Lucena
 */

package progjava.iteracao;

public class For2 {
    public static void main(String[] args) {
        for (int i = 0; ; i++) {
            i = (i > 10) ? i : i % 10;
        }
    }
}
