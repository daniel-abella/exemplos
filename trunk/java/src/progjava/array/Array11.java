/*
 * Array11.java vers�o 1.0 20/10/2003 Copyright (c) 2003 F�bio Lucena
 */

package progjava.array;

public class Array11 {
    public static void main(String[] args) {
        int[] arrayInt = { 1, 2, 3 };

        System.out.println(arrayInt);
        Object obj = arrayInt.clone();
        System.out.println(arrayInt.equals(obj));
        System.out.println(((int[]) obj)[1]);
        ((int[]) obj)[1] = 234;
        System.out.println(((int[]) obj)[1]);
        System.out.println(arrayInt[1]);
    }
}
