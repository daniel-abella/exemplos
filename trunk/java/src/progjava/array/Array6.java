package progjava.array;

/**
 * Copyright (c) 2003
 * F�bio Nogueira de Lucena
 * Date: 02/08/2003
 * Time: 10:27:07
 */
public class Array6 {
    public static void main(String[] args) {
        byte[][] b = new byte[2][2];
        byte[] aux = new byte[1];
        int soma = 0;

        b[0][0] = 1;
        b[0][1] = 1;

        for (int i = 0; i < b.length; i++)
            soma += b[0][i];
        System.out.println(soma);

        b[0] = aux;
        for (int i = 0; i < b.length; i++)
            soma += b[0][i];
        System.out.println(soma);
    }
}
