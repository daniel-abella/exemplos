/*
 * Comparacao4.java vers�o 1.0 17/10/2003 
 * Copyright (c) 2003 F�bio Lucena
 */

package progjava.igualdade;

public class Comparacao4 {
    public static void main(String[] args) {
        Double d = new Double("1.2");
        Float  f = new Float("1.2");

        System.out.println(d == (Object)f);
    }
}
