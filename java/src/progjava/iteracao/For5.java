/*
 * For5.java vers�o 1.0 02/10/2003
 * Copyright (c) 2003 F�bio Lucena
 */

package progjava.iteracao;

public class For5 {
    public static void main(String[] args) {
        int x = 1;
        int i = 1;
        int j = 1;
        externo:
        for (; i < 2; i++) {
            for (; j < 3; j++) {
                x++;
                continue externo;
            }
        }

        System.out.println(x + i + j);
    }
}
