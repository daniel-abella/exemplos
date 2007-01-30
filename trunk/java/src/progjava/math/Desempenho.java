/*
 * Desempenho.java vers�o 1.0 27/10/2003
 * Copyright (c) 2003 F�bio Lucena
 */

package progjava.math;

public class Desempenho {

    static double rq1(double n) {
        double r = 1.0;
        for (int i = 9; i > 0; i--) {
            r = (r + n / r) / 2;
        }
        return r;
    }

    public static void main(String[] args) {
        long inicio, fim;

        double numero = Math.PI;
        inicio = System.currentTimeMillis();
        for (int i = 0; i < 1000 * 1000; i++) {
            numero = rq1(numero) * Math.E;
        }
        fim = System.currentTimeMillis();
        System.out.println("rq1: " + (fim - inicio) + "\t" + numero);

        numero = Math.PI;
        inicio = System.currentTimeMillis();
        for (int i = 0; i < 1000 * 1000; i++) {
            numero = Math.sqrt(numero) * Math.E;
        }
        fim = System.currentTimeMillis();
        System.out.println("sqrt " + (fim - inicio) + "\t" + numero);
    }
}
