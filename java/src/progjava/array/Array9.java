package progjava.array;

/**
 * Copyright (c) 2003
 * F�bio Nogueira de Lucena
 * Date: 02/08/2003
 * Time: 11:33:27
 */
public class Array9 {
    public static void main(String[] args) {
        byte b[][] = {{-1, 20, -30, 3}, {}, {1, 2, 1}, {3, 4, 5}};
        System.out.println(b[1] == null);
        System.out.println(b[1].length);
        byte aux[] = b[0];
        b[1] = b[2];
        b[0] = b[3];
        b[2] = aux;
        System.out.println(b[2][2] == 1);
        System.out.println(b[3][1] == 4);
    }
}
