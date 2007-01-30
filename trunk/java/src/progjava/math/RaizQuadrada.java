/*
 * RaizQuadrada.java vers�o 1.0 27/10/2003 Copyright (c) 2003 F�bio Lucena
 */

package progjava.math;

public class RaizQuadrada {

    static double rq1(double n) {
        double r = 1.0;
        for (int i = 7; i > 0; i--) {
            r = (r + n / r) / 2;
        }
        return r;
    }

    static double rq2(double n) {
        double ans = n / 2.0;
        for (int i = 60; i > 0; i--) {
            ans = ans - ((ans * ans - n) / (2.0 * n));
        }
        return ans;
    }

    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
        for (int i = 0; i < 1000 * 1000; i++) {
            rq1(Math.PI);
        }
        long fim = System.currentTimeMillis();
        System.out.print("rq1: " + (fim - inicio) / 1000.0);
        System.out.println("\t" + rq1(Math.PI));

        inicio = System.currentTimeMillis();
        for (int i = 0; i < 1000 * 1000; i++) {
            rq2(Math.PI);
        }
        fim = System.currentTimeMillis();
        System.out.print("rq2: " + (fim - inicio) / 1000.0);
        System.out.println("\t" + rq2(Math.PI));

        inicio = System.currentTimeMillis();
        for (int i = 0; i < 1000 * 1000; i++) {
            Math.sqrt(Math.PI);
        }
        fim = System.currentTimeMillis();
        System.out.print("sqrt " + (fim - inicio) / 1000.0);
        System.out.println("\t" + Math.sqrt(Math.PI));
    }
}
