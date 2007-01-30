/*
 * SistemaNumeracao.java vers�o 1.0 16/10/2003 
 * Copyright (c) 2003 F�bio Lucena
 */

package progjava.math;

public class SistemaNumeracao {
    public static void main(String[] args) {
        for (int i = Byte.MIN_VALUE; i <= Byte.MAX_VALUE; i++) {
            System.out.print(i + "\t" + Integer.toHexString(i));
            System.out.println("\t" + Integer.toBinaryString(i));
        }
    }
}
