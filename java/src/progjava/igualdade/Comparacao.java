/*
 * Comparacao.java vers�o 1.0 17/10/2003 
 * Copyright (c) 2003 F�bio Lucena
 */

package progjava.igualdade;

public class Comparacao {
    public static void main(String[] args) {
        String str1 = "casa".intern();
        String str2 = "casa".intern();
        System.out.println(str1 == str2);
    }
}