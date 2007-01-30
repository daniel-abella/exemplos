/*
 * For6.java vers�o 1.0 02/10/2003
 * Copyright (c) 2003 F�bio Lucena
 */

package progjava.iteracao;

public class For6 {
    public static void main(String[] args) {
        int valor = 1;
        int i = 1;
        int j = 1;
        int k = 1;
        saida:
        for (; i < 2; i++) {
            for (; j < 3; j++) {
                for (; k < 4; k++) {
                    valor++;
                    continue saida;
                }
            }
        }
        System.out.println(valor + i + j + k);
    }
}
