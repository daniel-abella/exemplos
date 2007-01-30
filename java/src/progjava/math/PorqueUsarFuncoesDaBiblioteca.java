/*
 * PorqueUsarFuncoesDaBiblioteca.java vers�o 1.0 17/10/2003
 * Copyright (c) 2003 F�bio Lucena
 */

package progjava.math;

public class PorqueUsarFuncoesDaBiblioteca {

    public static int minhaAbs(int i) {
        return (i<0) ? -i : i;
    }

    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
        for (int i = 0; i < 100 * 1000 * 1000; i++) {
            Math.abs(i);
        }
        long fim = System.currentTimeMillis();
        System.out.println((fim - inicio) / 1000.0);

        inicio = System.currentTimeMillis();
        for (int j = 0; j < 100 * 1000 * 1000; j++) {
            minhaAbs(j);
        }
        fim = System.currentTimeMillis();
        System.out.println((fim - inicio) / 1000.0);
    }
}