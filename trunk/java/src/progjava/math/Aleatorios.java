/*
 * Aleatorios.java vers�o 1.0 15/10/2003
 * Copyright (c) 2003 F�bio Lucena
 */

package progjava.math;

public class Aleatorios {
    public static void main(String[] args) {
        int[] sorteios = new int[100];

        for (int i = 0; i < 1000 * 1000; i++) {
            sorteios[(int) (Math.random() * sorteios.length)]++;
        }

        int min = 0;
        int max = 0;
        for (int i = 0; i < sorteios.length; i++) {
            min = sorteios[i] < sorteios[min] ? i : min;
            max = sorteios[i] > sorteios[max] ? i : max;
        }

        System.out.println("Mais sorteado: " + max + " #" + sorteios[max]);
        System.out.println("Menos sorteado: " + min + " #" + sorteios[min]);
    }
}
