/*
 * Inteiro.java vers�o 1.0 16/10/2003 
 * Copyright (c) 2003 F�bio Lucena
 */

package progjava.math;

public class Inteiro {
    public static void main(String[] args) {
        int i = Integer.MIN_VALUE;
        int f = Integer.MAX_VALUE;

        long l = (long)f - i;
        System.out.println("Chaves disponiveis: " + l);

        long dezAnos = l/3650;
        System.out.println("Chaves por dia durante 10 anos: " + dezAnos);

        long bytes = 64; // Por registro
        System.out.println("Tamanho de cada registro (media): " + bytes);
        bytes *= dezAnos;
        System.out.print("Tamanho da base (bytes): " + bytes);
        bytes /= 1024;
        System.out.print(" "+ bytes + " Kbytes ");
        bytes /= 1024;
        System.out.println(bytes + " Mbytes");
    }
}
