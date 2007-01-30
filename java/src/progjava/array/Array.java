package progjava.array;

import java.util.Arrays;

public class Array {

    public static void main(String args []) {
        int[] a1 = new int[10];
        int[] a2 = retornaArray(2, 10);
        int[] a3 = new int[10];
        Arrays.fill(a3, 3);

        for (Integer itemI : a1)
        	System.out.print(itemI + " ");
        
        System.out.println();
        for (int i2 : a2)
        	System.out.print(i2 + " ");
        
        System.out.println("\n" + Arrays.toString(a3));
    }

    private static int retornaArray(int vi, int tamanho) [] {
        int[] array = new int[tamanho];

        for (int i = 0; i < array.length; i++)
            array[i] = vi;

        return array;
    }
}