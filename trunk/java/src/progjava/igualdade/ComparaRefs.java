/*
 * ComparaRefs.java vers�o 1.0 17/10/2003 
 * Copyright (c) 2003 F�bio Lucena
 */

package progjava.igualdade;

public class ComparaRefs {
    public static void main(String[] args) {
        ComparaRefs a = new ComparaRefs();
        Object b = a;
        System.out.println(b == a);
    }
}
