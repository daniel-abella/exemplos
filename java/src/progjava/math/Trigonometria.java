/*
 * Trigonometria.java vers�o 1.0 16/10/2003 
 * Copyright (c) 2003 F�bio Lucena
 */

package progjava.math;

public class Trigonometria {
    public static void main(String[] args) {
        double radianos;
        double sen;
        double cos;
        for (int i = 0; i <= 360; i++) {

            // 1 grau equivale a PI/180 radianos
            radianos = i*Math.PI/180;
            assert Math.abs(radianos - Math.toRadians(i)) < 1E-10 : i;

            sen = Math.sin(radianos);
            cos = Math.cos(radianos);

            // A soma dos quadrados do seno e cosseno de um �ngulo � 1.
            assert Math.abs((cos*cos + sen*sen) - 1.0) <  1E-10 : i;
        }
    }
}
