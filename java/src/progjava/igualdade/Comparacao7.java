/*
 * Comparacao7.java vers�o 1.0 17/10/2003 
 * Copyright (c) 2003 F�bio Lucena
 */

package progjava.igualdade;

public class Comparacao7 {
    public static void main(String[] args) {
        System.out.print("A".equals("a".toUpperCase()) + " ");
        StringBuffer sb1 = new StringBuffer("A");
        StringBuffer sb2 = new StringBuffer("A");
        System.out.print(sb1.equals(sb2));
    }
}
