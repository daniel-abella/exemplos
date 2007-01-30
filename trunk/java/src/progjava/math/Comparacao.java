/*
 * Comparacao.java vers�o 1.0 15/10/2003
 * Copyright (c) 2003 F�bio Lucena
 */

package progjava.math;

public class Comparacao {
    public static void main(String[] args) {
        if (Math.min(-0.0, 0.0) < 0.0) {
            System.out.println("menor");
        } else if (Math.min(-0.0, 0.0) == 0.0) {
            System.out.println("igual");
        } else {
            System.out.println("maior");
        }
    }
}
