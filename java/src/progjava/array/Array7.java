package progjava.array;

/**
 * Copyright (c) 2003
 * F�bio Nogueira de Lucena
 * Date: 02/08/2003
 * Time: 10:51:42
 */
public class Array7 {
    static int[] a;

    public static void main(String[] args) {
        // a.length = 2; Erro: length � final 
        a[0] = 1;
        a[1] = 2;
        System.out.println(a[0] + a[1]);
    }
}
