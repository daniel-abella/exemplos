/*
 * SqrtAjuste.java vers�o 1.0 27/10/2003
 * Copyright (c) 2003 F�bio Lucena
 */

package progjava.math;

public class SqrtAjuste {

    static double rq1(double n, int ajuste) {
        double r = 1.0;
        for (int i = ajuste; i > 0; i--) {
            r = (r + n / r) / 2;
        }
        return r;
    }

    public static void main(String[] args) {
        double numero, rq = 1, mrq = 0;
        int ajuste = 1;

        for (int i = 0; i < 1000 * 1000; i++) {
            numero = Math.random();
            while (rq != mrq) {
                rq = rq1(numero, ajuste);
                mrq = Math.sqrt(numero);
                ajuste = (ajuste > 100) ? ajuste + 1000 : ajuste + 1;
                if (ajuste % 100 == 0)
                    System.out.println(ajuste + " diferenca: " + Math.abs(rq-mrq));
            }
            if (i % 1000 == 0)
                System.out.println(i + " Ajuste: " + ajuste);
        }
    }
}
